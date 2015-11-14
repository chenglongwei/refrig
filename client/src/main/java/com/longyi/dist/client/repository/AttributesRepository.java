package com.longyi.dist.client.repository;

import com.longyi.dist.client.domain.Attributes;
import com.longyi.dist.client.domain.Bacteria;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by chenglongwei on 11/14/15.
 */
public interface AttributesRepository extends MongoRepository<Attributes, String> {
}
