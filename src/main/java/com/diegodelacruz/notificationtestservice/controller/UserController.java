package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.model.User;
import com.diegodelacruz.notificationtestservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping
    public ResponseEntity<List<User>> readAll() throws Exception {
        List<User> list = service.readAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) throws Exception {
        User userSaved = service.save(user);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Integer id, @RequestBody User user) throws Exception {
        user.setIdUser(id);
        User userUpdated = service.save(user);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }
}
