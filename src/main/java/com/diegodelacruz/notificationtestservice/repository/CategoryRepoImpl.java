package com.diegodelacruz.notificationtestservice.repository;

import com.diegodelacruz.notificationtestservice.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepoImpl implements ICategoryRepo {

    @Override
    public Category getActualCategory() {
        return null;
    }

}
