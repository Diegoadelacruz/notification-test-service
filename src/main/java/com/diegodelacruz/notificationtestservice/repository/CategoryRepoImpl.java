package com.diegodelacruz.notificationtestservice.repository;

import com.diegodelacruz.notificationtestservice.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepoImpl implements ICategoryRepo {

    @Override
    public Category getActualCategory(){
        return new Category(1, "Sport", "Activity involving physical exertion and skill in which an individual or team competes against another or other for enterteiment.");
    }

}
