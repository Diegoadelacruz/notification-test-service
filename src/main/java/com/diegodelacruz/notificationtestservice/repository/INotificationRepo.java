package com.diegodelacruz.notificationtestservice.repository;

import com.diegodelacruz.notificationtestservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationRepo extends JpaRepository<Notification, Integer> {

}
