package com.longyi.dist.client.repository;

import com.longyi.dist.client.domain.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by chenglongwei on 10/5/15.
 */
public interface TemperatureRepository extends MongoRepository<Temperature, String> {
}
