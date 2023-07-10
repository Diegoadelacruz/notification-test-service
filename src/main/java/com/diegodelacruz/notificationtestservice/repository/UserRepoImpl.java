package com.diegodelacruz.notificationtestservice.repository;

import com.diegodelacruz.notificationtestservice.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements IUserRepo{
    @Override
    public User getActualUser() {
        return new User(1, "Diego", "diego@email.com", "5512345678", "List of Categories", "List of Notifications");
    }
}
