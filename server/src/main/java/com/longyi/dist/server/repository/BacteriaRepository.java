package com.longyi.dist.server.repository;

import com.longyi.dist.server.domain.Bacteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by chenglongwei on 11/14/15.
 */
public interface BacteriaRepository extends MongoRepository<Bacteria, String> {
    @Query(value = "{'endpointClientName' : ?0 }")
    public List<Bacteria> findByEndpointClientName(String ep);
}
