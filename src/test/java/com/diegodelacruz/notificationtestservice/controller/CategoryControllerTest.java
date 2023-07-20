package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.dto.CategoryDTO;
import com.diegodelacruz.notificationtestservice.exception.ModelNotFoundException;
import com.diegodelacruz.notificationtestservice.model.Category;
import com.diegodelacruz.notificationtestservice.service.ICategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICategoryService service;

    @MockBean(name = "categoryMapper")
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    Category CATEGORY_1 = new Category(1, "Sport", "Sport description test");

    Category CATEGORY_2 = new Category(2, "Finance", "Finance description test");

    Category CATEGORY_3 = new Category(3, "Movies", "Movies description test");

    CategoryDTO CATEGORYDTO_1 = new CategoryDTO(1, "Sport", "Sport description test");
    CategoryDTO CATEGORYDTO_2 = new CategoryDTO(2, "Finance", "Finance description test");
    CategoryDTO CATEGORYDTO_3 = new CategoryDTO(3, "Movies", "Movies description test");


    @Test
    public void readAllTest() throws Exception {

        List<Category> categories = Arrays.asList(CATEGORY_1, CATEGORY_2, CATEGORY_3);

        Mockito.when(service.readAll()).thenReturn(categories);
        Mockito.when(modelMapper.map(CATEGORY_1, CategoryDTO.class)).thenReturn(CATEGORYDTO_1);
        Mockito.when(modelMapper.map(CATEGORY_2, CategoryDTO.class)).thenReturn(CATEGORYDTO_2);
        Mockito.when(modelMapper.map(CATEGORY_3, CategoryDTO.class)).thenReturn(CATEGORYDTO_3);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/categories")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$.[1].nameCategory", is("Finance")));
    }

    @Test
    public void readByIdTest() throws Exception {
        int ID = 1;

        Mockito.when(service.readById(Mockito.any())).thenReturn(CATEGORY_1);
        Mockito.when(modelMapper.map(CATEGORY_1, CategoryDTO.class)).thenReturn(CATEGORYDTO_1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/categories/" + ID)
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect((jsonPath("$.nameCategory", is("Sport"))));
    }

    @Test
    public void createTest() throws Exception {

        Mockito.when(service.save(Mockito.any())).thenReturn(CATEGORY_3);
        Mockito.when(modelMapper.map(CATEGORY_3, CategoryDTO.class)).thenReturn(CATEGORYDTO_3);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .post("/categories")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(CATEGORYDTO_3));

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isCreated())
                .andExpect((jsonPath("$.nameCategory", is("Movies"))));
    }

    @Test
    public void updateTest() throws Exception {
        int ID = 1;

        Mockito.when(service.update(Mockito.any(), Mockito.anyInt())).thenReturn(CATEGORY_2);
        Mockito.when(modelMapper.map(CATEGORY_2, CategoryDTO.class)).thenReturn(CATEGORYDTO_2);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .put("/categories/" + ID)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(CATEGORYDTO_2));

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk())
                .andExpect((jsonPath("$.nameCategory", is("Finance"))));
    }

    @Test
    public void updateErrorTest() throws Exception {
        int ID = 2;

        Mockito.when(service.update(Mockito.any(), Mockito.anyInt())).thenThrow(new ModelNotFoundException("Test Exception"));

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .put("/categories/" + ID)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(CATEGORYDTO_2));

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ModelNotFoundException));
    }

    @Test
    public void deleteTest()throws Exception{
        int ID_CATEGORY = 1;

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/categories/" + ID_CATEGORY)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(CATEGORYDTO_2)));

    }
}
