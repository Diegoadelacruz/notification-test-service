package com.diegodelacruz.notificationtestservice.service.impl;

import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.repository.IGenericRepo;
import com.diegodelacruz.notificationtestservice.repository.INotificationRepo;
import com.diegodelacruz.notificationtestservice.service.INotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl extends CRUDImpl<Notification, Integer> implements INotificationService {

    private final INotificationRepo repo;


    @Override
    protected IGenericRepo<Notification, Integer> getRepo() {
        return repo;
    }
}