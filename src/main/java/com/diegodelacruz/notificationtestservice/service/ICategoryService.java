package com.diegodelacruz.notificationtestservice.service;

import com.diegodelacruz.notificationtestservice.model.Category;

import java.util.List;

public interface ICategoryService {

    Category save(Category category) throws Exception;

    Category update(Category category) throws Exception;

    List<Category> readAll() throws Exception;

    Category readById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;


}
