package com.diegodelacruz.notificationtestservice.repository;

import com.diegodelacruz.notificationtestservice.model.Notification;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepoImpl implements INotificationRepo {

    @Override
    public Notification getActualNotification() {
        return new Notification(1, "SMS", "Short Message Service");
    }
}
