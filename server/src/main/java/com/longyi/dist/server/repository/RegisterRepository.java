package com.longyi.dist.server.repository;

import com.longyi.dist.server.domain.RegisterInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by chenglongwei on 10/5/15.
 */
public interface RegisterRepository extends MongoRepository<RegisterInfo, String> {
    @Query(value = "{'endpointClientName' : ?0 }")
    public RegisterInfo findByEndpointClientName(String ep);
}
