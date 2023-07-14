package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private INotificationService service;

    @GetMapping
    public ResponseEntity<List<Notification>> readAll() throws Exception {
        List<Notification> list = service.readAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notification> create(@RequestBody Notification notification) throws Exception {
        Notification notificationSaved = service.save(notification);
        return new ResponseEntity<>(notificationSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> update(@PathVariable("id") Integer id, @RequestBody Notification notification) throws Exception {
        notification.setIdNotification(id);
        Notification notificationUpdated = service.update(notification);
        return new ResponseEntity<>(notificationUpdated, HttpStatus.OK);
    }

}
