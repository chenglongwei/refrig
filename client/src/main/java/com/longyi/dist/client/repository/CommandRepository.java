package com.longyi.dist.client.repository;

import com.longyi.dist.client.domain.Bacteria;
import com.longyi.dist.client.domain.Command;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by chenglongwei on 11/14/15.
 */
public interface CommandRepository extends MongoRepository<Command, String> {
}
