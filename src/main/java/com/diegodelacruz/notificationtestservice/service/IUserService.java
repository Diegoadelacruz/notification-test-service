package com.diegodelacruz.notificationtestservice.service;

import com.diegodelacruz.notificationtestservice.model.User;

import java.util.List;

public interface IUserService {

    User save(User user) throws Exception;

    User update(User user) throws Exception;

    List<User> readAll() throws Exception;

}
