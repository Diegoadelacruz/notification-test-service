package com.diegodelacruz.notificationtestservice.service.impl;

import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.repository.INotificationRepo;
import com.diegodelacruz.notificationtestservice.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements INotificationService {

    @Autowired
    private INotificationRepo repo;

    @Override
    public Notification getActualNotification() {
        return repo.getActualNotification();
    }
}
