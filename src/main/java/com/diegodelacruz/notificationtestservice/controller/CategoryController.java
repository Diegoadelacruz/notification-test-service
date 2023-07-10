package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.model.Category;
import com.diegodelacruz.notificationtestservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @GetMapping
    public Category getActualCategory(){
        return service.getActual2023();
    }

}
