package com.diegodelacruz.notificationtestservice.repository;

import com.diegodelacruz.notificationtestservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepoImpl implements IUserRepo {

    @Override
    public User getActualUser() {
        return null;
    }
}
