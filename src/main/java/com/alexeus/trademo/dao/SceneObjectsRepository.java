package com.alexeus.trademo.dao;

import com.alexeus.trademo.domain.SceneObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SceneObjectsRepository extends CrudRepository<SceneObject, Integer> {

    @Query("SELECT o FROM SceneObject o WHERE o.sceneId = ?1")
    Collection<SceneObject> getObjects(Integer sceneId);

    @Query("DELETE FROM SceneObject o WHERE o.parentObjectId = ?1")
    void deleteChildren(Integer objectId);
}
