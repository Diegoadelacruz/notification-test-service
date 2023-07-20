package com.diegodelacruz.notificationtestservice.service.impl;

import com.diegodelacruz.notificationtestservice.model.Category;
import com.diegodelacruz.notificationtestservice.repository.ICategoryRepo;
import com.diegodelacruz.notificationtestservice.repository.IGenericRepo;
import com.diegodelacruz.notificationtestservice.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<Category, Integer> implements ICategoryService {

    private final ICategoryRepo repo;

    @Override
    protected IGenericRepo<Category, Integer> getRepo() {
        return repo;
    }

}
