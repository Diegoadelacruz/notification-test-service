package com.diegodelacruz.notificationtestservice.service;

import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.repository.INotificationRepo;
import com.diegodelacruz.notificationtestservice.service.impl.NotificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class NotificationServiceTest {

    @MockBean
    private NotificationServiceImpl service;

    @MockBean
    private INotificationRepo repo;

    private Notification NOTIFICATION_1;

    private Notification NOTIFICATION_2;

    private Notification NOTIFICATION_3;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.service = new NotificationServiceImpl(repo);
        NOTIFICATION_1 = new Notification(1, "SMS", "SMS description test");
        NOTIFICATION_2 = new Notification(2, "E-mail", "E-mail description test");
        NOTIFICATION_3 = new Notification(3, "Movies", "Movies description test");
        List<Notification> notifications = Arrays.asList(NOTIFICATION_1, NOTIFICATION_2, NOTIFICATION_3);
        Mockito.when(repo.findAll()).thenReturn(notifications);
    }

    @Test
    public void readAllTest() throws Exception {
        List<Notification> response = service.readAll();
        assertEquals(response.size(), 3);
    }

    @Test
    public void saveTest() throws Exception {
        Notification response = service.save(NOTIFICATION_1);
        assertNotNull(response);
    }

    @Test
    public void updateTest() throws Exception {
        Notification response = service.update(NOTIFICATION_1, Mockito.anyInt());
        assertNotNull(response);
    }

}
