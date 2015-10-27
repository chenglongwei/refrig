package com.longyi.dist.server.repository;

import com.longyi.dist.server.domain.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by chenglongwei on 10/26/15.
 */
public interface TemperatureRepository extends MongoRepository<Temperature, String> {
    @Query(value = "{'endpointClientName' : ?0 }")
    public List<Temperature> findByEndpointClientName(String ep);
}
