package com.alexeus.trademo.dao;

import com.alexeus.trademo.domain.FactoryObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryObjectsRepository extends CrudRepository<FactoryObject, Integer>, FactoryObjectsSearchRepository {

}
