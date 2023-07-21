package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.dto.NotificationDTO;
import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.service.INotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private INotificationService service;

    @Qualifier("notificationMapper")
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<NotificationDTO>> readAll() throws Exception {
        List<NotificationDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Notification notification = service.readById(id);
        return new ResponseEntity<>(convertToDto(notification), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NotificationDTO> create(@RequestBody NotificationDTO notificationDTO) throws Exception {
        Notification notificationSaved = service.save(convertToEntity(notificationDTO));
        return new ResponseEntity<>(convertToDto(notificationSaved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationDTO> update(@PathVariable("id") Integer id, @RequestBody NotificationDTO notificationDTO) throws Exception {
        notificationDTO.setId(id);
        Notification notificationUpdated = service.update(convertToEntity(notificationDTO), id);
        return new ResponseEntity<>(convertToDto(notificationUpdated), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private NotificationDTO convertToDto(Notification notification) {
        return mapper.map(notification, NotificationDTO.class);
    }

    private Notification convertToEntity(NotificationDTO notificationDTO) {
        return mapper.map(notificationDTO, Notification.class);
    }

}
