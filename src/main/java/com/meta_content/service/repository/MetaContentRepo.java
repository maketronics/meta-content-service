package com.meta_content.service.repository;

import com.meta_content.service.model.MetaContentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaContentRepo extends MongoRepository<MetaContentEntity, String > {
}
