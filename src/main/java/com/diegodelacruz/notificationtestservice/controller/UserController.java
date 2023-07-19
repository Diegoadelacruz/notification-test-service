package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.dto.NotificationDTO;
import com.diegodelacruz.notificationtestservice.dto.UserDTO;
import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.model.User;
import com.diegodelacruz.notificationtestservice.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService service;

    Qualifier("userMapper")
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> readAll() throws Exception {
        List<UserDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) throws Exception {
        User userSaved = service.save(convertToEntity(userDTO));
        return new ResponseEntity<>(convertToDto(userSaved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) throws Exception {
        userDTO.setId(id);
        User userUpdated = service.save(convertToEntity(userDTO));
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    private UserDTO convertToDto(User user) {
        return mapper.map(user, UserDTO.class);
    }

    private User convertToEntity(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }

}
