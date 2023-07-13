package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.model.Category;
import com.diegodelacruz.notificationtestservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @GetMapping
    public List<Category> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public Category readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) throws Exception {
        return service.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable("id") Integer id, @RequestBody Category category) throws Exception {
        return service.update(category);
    }

    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }

}
