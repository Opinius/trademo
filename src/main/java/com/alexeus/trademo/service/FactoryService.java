package com.alexeus.trademo.service;

import com.alexeus.trademo.domain.FactoryObject;
import com.alexeus.trademo.domain.ObjectType;

import java.util.Map;

public interface FactoryService {
    Iterable<ObjectType> listObjectTypes();
    ObjectType createObjectType(ObjectType type);
    Iterable<FactoryObject> listObjects();
    Iterable<FactoryObject> findObjects(Map<String, String[]> searchData);
    FactoryObject getObject(Integer id);
    FactoryObject createObject(FactoryObject obj);
    void deleteObject(Integer id);
    FactoryObject updateObject(FactoryObject obj);
}
