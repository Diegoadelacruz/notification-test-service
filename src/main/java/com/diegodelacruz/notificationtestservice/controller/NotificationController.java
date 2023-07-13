package com.diegodelacruz.notificationtestservice.controller;

import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private INotificationService service;

    @GetMapping
    public List<Notification> readAll() throws Exception{
        return service.readAll();
    }

    @PostMapping
    public Notification create(@RequestBody Notification notification) throws Exception{
        return service.save(notification);
    }

    @PutMapping
    public Notification update(Notification notification) throws Exception{
        return service.update(notification);
    }

}
