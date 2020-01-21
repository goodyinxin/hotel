package com.example.hotel.config;

import com.example.hotel.utils.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {

    @Bean
     public SnowflakeIdWorker snowflakeIdWorker(){
          return  new SnowflakeIdWorker(1,1);
     }

}
