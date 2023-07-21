package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.dto.NotificationDTO;
import com.diegodelacruz.notificationtestservice.exception.ModelNotFoundException;
import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.service.INotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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

@WebMvcTest(NotificationController.class)
public class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private INotificationService service;

    @MockBean(name = "notificationMapper")
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    private Notification NOTIFICATION_1;

    private Notification NOTIFICATION_2;

    private Notification NOTIFICATION_3;

    private NotificationDTO NOTIFICATIONDTO_1;
    private NotificationDTO NOTIFICATIONDTO_2;
    private NotificationDTO NOTIFICATIONDTO_3;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        NOTIFICATION_1 = new Notification(1, "SMS", "SMS description test");
        NOTIFICATION_2 = new Notification(2, "E-mail", "E-mail description test");
        NOTIFICATION_3 = new Notification(3, "Push Notification", "Push Notification description test");
        NOTIFICATIONDTO_1 = new NotificationDTO(1, "SMS", "SMS description test");
        NOTIFICATIONDTO_2 = new NotificationDTO(2, "E-mail", "E-mail description test");
        NOTIFICATIONDTO_3 = new NotificationDTO(3, "Push Notification", "Push Notification description test");
    }

    @Test
    public void readAllTest() throws Exception {

        List<Notification> notifications = Arrays.asList(NOTIFICATION_1, NOTIFICATION_2, NOTIFICATION_3);

        Mockito.when(service.readAll()).thenReturn(notifications);
        Mockito.when(modelMapper.map(NOTIFICATION_1, NotificationDTO.class)).thenReturn(NOTIFICATIONDTO_1);
        Mockito.when(modelMapper.map(NOTIFICATION_2, NotificationDTO.class)).thenReturn(NOTIFICATIONDTO_2);
        Mockito.when(modelMapper.map(NOTIFICATION_3, NotificationDTO.class)).thenReturn(NOTIFICATIONDTO_3);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/notifications")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$.[1].nameNotification", is("E-mail")));
    }

    @Test
    public void readByIdTest() throws Exception {
        int ID = 1;

        Mockito.when(service.readById(Mockito.any())).thenReturn(NOTIFICATION_1);
        Mockito.when(modelMapper.map(NOTIFICATION_1, NotificationDTO.class)).thenReturn(NOTIFICATIONDTO_1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/notifications/" + ID)
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect((jsonPath("$.nameNotification", is("SMS"))));
    }

    @Test
    public void createTest() throws Exception {

        Mockito.when(service.save(Mockito.any())).thenReturn(NOTIFICATION_3);
        Mockito.when(modelMapper.map(NOTIFICATION_3, NotificationDTO.class)).thenReturn(NOTIFICATIONDTO_3);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .post("/notifications")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(NOTIFICATIONDTO_3));

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isCreated())
                .andExpect((jsonPath("$.nameNotification", is("Push Notification"))));
    }

    @Test
    public void updateTest() throws Exception {
        int ID = 1;

        Mockito.when(service.update(Mockito.any(), Mockito.anyInt())).thenReturn(NOTIFICATION_1);
        Mockito.when(modelMapper.map(NOTIFICATION_1, NotificationDTO.class)).thenReturn(NOTIFICATIONDTO_1);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .put("/notifications/" + ID)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(NOTIFICATIONDTO_2));

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk())
                .andExpect((jsonPath("$.nameNotification", is("SMS"))));
    }

    @Test
    public void updateErrorTest() throws Exception {
        int ID = 2;

        Mockito.when(service.update(Mockito.any(), Mockito.anyInt())).thenThrow(new ModelNotFoundException("Test Exception"));

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .put("/notifications/" + ID)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(NOTIFICATIONDTO_2));

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ModelNotFoundException));
    }

    @Test
    public void deleteTest() throws Exception {
        int ID_NOTIFICATION = 1;

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/notifications/" + ID_NOTIFICATION)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(NOTIFICATIONDTO_2)));

    }

}
