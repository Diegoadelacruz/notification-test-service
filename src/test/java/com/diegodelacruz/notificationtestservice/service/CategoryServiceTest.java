package com.diegodelacruz.notificationtestservice.service;

import com.diegodelacruz.notificationtestservice.model.Category;
import com.diegodelacruz.notificationtestservice.repository.ICategoryRepo;
import com.diegodelacruz.notificationtestservice.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {

    @MockBean
    private CategoryServiceImpl service;

    @MockBean
    private ICategoryRepo repo;

    private Category CATEGORY_1;

    private Category CATEGORY_2;

    private Category CATEGORY_3;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.service = new CategoryServiceImpl(repo);
        CATEGORY_1 = new Category(1, "Sport", "Sport description test");
        CATEGORY_2 = new Category(2, "Finance", "Finance description test");
        CATEGORY_3 = new Category(3, "Movies", "Movies description test");
        List<Category> categories = Arrays.asList(CATEGORY_1, CATEGORY_2, CATEGORY_3);
        Mockito.when(repo.findAll()).thenReturn(categories);
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.of(CATEGORY_1));
    }

    @Test
    public void readAllTest() throws Exception {
        List<Category> response = service.readAll();
        assertEquals(response.size(), 3);
    }

    @Test
    public void readByIdTest() throws Exception {
        Category response = service.readById(1);
        assertNotNull(response);
    }

    @Test
    public void saveTest() throws Exception {
        Category response = service.save(CATEGORY_1);
        assertNotNull(response);
    }

    @Test
    public void updateTest() throws Exception {
        Category response = service.update(CATEGORY_1, Mockito.anyInt());
        assertNotNull(response);
    }

    @Test
    public void deleteTest() throws Exception {
        repo.deleteById(1);
        Mockito.verify(repo, Mockito.times(1)).deleteById(1);
    }

}
