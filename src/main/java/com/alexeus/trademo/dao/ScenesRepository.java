package com.alexeus.trademo.dao;

import com.alexeus.trademo.domain.Scene;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenesRepository extends CrudRepository<Scene, Integer> {
}
