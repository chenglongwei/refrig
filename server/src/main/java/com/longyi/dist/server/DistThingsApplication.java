package com.longyi.dist.server;

/**
 * Created by chenglongwei on 9/17/15.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@Configuration
@EnableMongoRepositories
@ImportResource("classpath:application-context.xml")
@EnableAutoConfiguration
public class DistThingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistThingsApplication.class, args);

    }
}
