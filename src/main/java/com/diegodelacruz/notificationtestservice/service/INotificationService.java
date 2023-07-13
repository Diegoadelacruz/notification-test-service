package com.diegodelacruz.notificationtestservice.service;

import com.diegodelacruz.notificationtestservice.model.Category;
import com.diegodelacruz.notificationtestservice.model.Notification;

import java.util.List;

public interface INotificationService {

    Notification save(Notification notification) throws Exception;

    Notification update(Notification notification) throws Exception;

    List<Notification> readAll() throws Exception;

}
