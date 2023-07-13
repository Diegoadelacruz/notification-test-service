package com.diegodelacruz.notificationtestservice.service.impl;

import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.repository.INotificationRepo;
import com.diegodelacruz.notificationtestservice.service.INotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements INotificationService {

    private final INotificationRepo repo;

    @Override
    public Notification save(Notification notification) throws Exception {
        return repo.save(notification);
    }

    @Override
    public Notification update(Notification notification) throws Exception {
        return null;
    }

    @Override
    public List<Notification> readAll() throws Exception {
        return null;
    }
}
