package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.dto.CategoryDTO;
import com.diegodelacruz.notificationtestservice.model.Category;
import com.diegodelacruz.notificationtestservice.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> readAll() throws Exception {
        List<CategoryDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Category category = service.readById(id);
        return new ResponseEntity<>(convertToDto(category), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO categoryDTO) throws Exception {
        Category categorySaved = service.save(convertToEntity(categoryDTO));
        return new ResponseEntity<>(convertToDto(categorySaved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable("id") Integer id, @RequestBody CategoryDTO categoryDTO) throws Exception {
        categoryDTO.setId(id);
        Category categoryUpdated = service.save(convertToEntity(categoryDTO));
        return new ResponseEntity<>(convertToDto(categoryUpdated), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CategoryDTO convertToDto(Category category) {
        return mapper.map(category, CategoryDTO.class);
    }

    private Category convertToEntity(CategoryDTO categoryDTO) {
        return mapper.map(categoryDTO, Category.class);
    }

}
