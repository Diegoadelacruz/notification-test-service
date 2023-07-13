package com.diegodelacruz.notificationtestservice.service.impl;

import com.diegodelacruz.notificationtestservice.model.User;
import com.diegodelacruz.notificationtestservice.repository.IGenericRepo;
import com.diegodelacruz.notificationtestservice.repository.IUserRepo;
import com.diegodelacruz.notificationtestservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService {

    private final IUserRepo repo;

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }
}
