package com.diegodelacruz.notificationtestservice.service.impl;

import com.diegodelacruz.notificationtestservice.model.Notification;
import com.diegodelacruz.notificationtestservice.model.User;
import com.diegodelacruz.notificationtestservice.repository.IUserRepo;
import com.diegodelacruz.notificationtestservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepo repo;


    @Override
    public User save(User user) throws Exception {
        return repo.save(user);
    }

    @Override
    public User update(User user) throws Exception {
        return repo.save(user);
    }

    @Override
    public List<User> readAll() throws Exception {
        return null;
    }
}
