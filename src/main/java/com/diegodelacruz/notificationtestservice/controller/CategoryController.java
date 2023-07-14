package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.model.Category;
import com.diegodelacruz.notificationtestservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> readAll() throws Exception {
        List<Category> list = service.readAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> readById(@PathVariable("id") Integer id) throws Exception {
        Category category = service.readById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) throws Exception {
        Category categorySaved = service.save(category);
        return new ResponseEntity<>(categorySaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Integer id, @RequestBody Category category) throws Exception {
        category.setIdCategory(id);
        Category categoryUpdated = service.save(category);
        return new ResponseEntity<>(categoryUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
