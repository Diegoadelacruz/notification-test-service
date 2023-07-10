package com.diegodelacruz.notificationtestservice.service;

import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.repository.INotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private INotificationRepo repo;

    @Override
    public Notification getActualNotification() {
        return repo.getActualNotification();
    }
}
