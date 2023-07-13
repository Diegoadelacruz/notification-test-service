package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.model.User;
import com.diegodelacruz.notificationtestservice.service.IUserService;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping
    public List<User> readAll() throws Exception {
        return service.readAll();
    }

    @PostMapping
    public User create(@RequestBody User user) throws Exception {
        return service.save(user);
    }

    @PutMapping
    public User update(@PathVariable("id") Integer id, @RequestBody User user) throws Exception {
        return service.update(user);
    }
}
