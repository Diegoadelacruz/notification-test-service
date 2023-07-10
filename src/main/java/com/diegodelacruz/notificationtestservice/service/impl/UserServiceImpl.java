package com.diegodelacruz.notificationtestservice.service.impl;

import com.diegodelacruz.notificationtestservice.model.User;
import com.diegodelacruz.notificationtestservice.repository.IUserRepo;
import com.diegodelacruz.notificationtestservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepo repo;

    @Override
    public User getActualUser() {
        return repo.getActualUser();
    }
}
