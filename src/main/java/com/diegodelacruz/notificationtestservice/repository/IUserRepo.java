package com.diegodelacruz.notificationtestservice.repository;

import com.diegodelacruz.notificationtestservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {

}
