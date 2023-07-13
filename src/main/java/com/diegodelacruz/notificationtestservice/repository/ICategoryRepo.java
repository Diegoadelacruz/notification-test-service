package com.diegodelacruz.notificationtestservice.repository;

import com.diegodelacruz.notificationtestservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category, Integer> {

}
