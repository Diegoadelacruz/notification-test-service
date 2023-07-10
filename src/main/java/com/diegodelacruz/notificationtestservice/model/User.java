package com.diegodelacruz.notificationtestservice.model;

import lombok.Data;

@Data
public class User {

    private Integer idUser;

    private String name;

    private String email;

    private Integer phoneNumber;

    private String subscribed;

    private String channels;

}
