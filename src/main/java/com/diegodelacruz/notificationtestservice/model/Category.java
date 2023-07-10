package com.diegodelacruz.notificationtestservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Category {

    private Integer idCategory;

    private String name;

    private String description;

}
