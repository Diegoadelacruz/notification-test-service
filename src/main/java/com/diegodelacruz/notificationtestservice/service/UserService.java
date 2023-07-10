package com.diegodelacruz.notificationtestservice.service;

import com.diegodelacruz.notificationtestservice.model.User;
import com.diegodelacruz.notificationtestservice.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepo repo;

    @Override
    public User getActualUser() {
        return repo.getActualUser();
    }
}
