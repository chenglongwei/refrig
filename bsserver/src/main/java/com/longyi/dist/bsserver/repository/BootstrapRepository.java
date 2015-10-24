package com.longyi.dist.bsserver.repository;

import com.longyi.dist.bsserver.domain.Bootstrap;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by chenglongwei on 10/5/15.
 */
public interface BootstrapRepository extends MongoRepository<Bootstrap, String> {
    @Query(value = "{'ep' : ?0 }")
    public Bootstrap findByEp(String ep);
}
