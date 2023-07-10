package com.diegodelacruz.notificationtestservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
public class Notification {

    private Integer idNotification;

    private String name;

    private String description;

}
