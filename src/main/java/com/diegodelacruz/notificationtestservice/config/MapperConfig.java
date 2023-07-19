package com.diegodelacruz.notificationtestservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("categoryMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean("userMapper")
    public ModelMapper userMapper() {
        return new ModelMapper();
    }

    @Bean("notificationMapper")
    public ModelMapper notificationMapper() {
        return new ModelMapper();
    }

}
