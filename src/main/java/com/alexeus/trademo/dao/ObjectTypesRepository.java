package com.alexeus.trademo.dao;

import com.alexeus.trademo.domain.ObjectType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectTypesRepository extends CrudRepository<ObjectType, Integer> {
}
