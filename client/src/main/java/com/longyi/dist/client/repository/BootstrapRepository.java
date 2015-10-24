package com.longyi.dist.client.repository;

import com.longyi.dist.client.domain.Refrig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by chenglongwei on 10/5/15.
 */
public interface BootstrapRepository extends MongoRepository<Refrig, String> {
    @Query(value = "{'ep' : ?0 }")
    public Refrig findByEp(String ep);
}
