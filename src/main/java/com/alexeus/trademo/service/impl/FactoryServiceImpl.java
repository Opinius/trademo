package com.alexeus.trademo.service.impl;

import com.alexeus.trademo.dao.FactoryObjectsRepository;
import com.alexeus.trademo.dao.ObjectTypesRepository;
import com.alexeus.trademo.domain.FactoryObject;
import com.alexeus.trademo.domain.ObjectType;
import com.alexeus.trademo.service.FactoryService;
import com.alexeus.trademo.util.ExceptionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FactoryServiceImpl implements FactoryService {

    private final FactoryObjectsRepository factoryObjectsRepository;
    private final ObjectTypesRepository objectTypesRepository;

    @Autowired
    public FactoryServiceImpl(FactoryObjectsRepository factoryObjectsRepository,
                             ObjectTypesRepository objectTypesRepository) {
        this.factoryObjectsRepository = factoryObjectsRepository;
        this.objectTypesRepository = objectTypesRepository;
    }

    @Override
    public Iterable<ObjectType> listObjectTypes() {
        return objectTypesRepository.findAll();
    }

    @Override
    public ObjectType createObjectType(ObjectType type) {
        return objectTypesRepository.save(type);
    }

    @Override
    public Iterable<FactoryObject> listObjects() {
        return factoryObjectsRepository.findAll();
    }

    @Override
    public Collection<FactoryObject> findObjects(Map<String, String[]> searchData) {
        return factoryObjectsRepository.findObjects(searchData);
    }

    @Override
    public FactoryObject getObject(Integer id) {
        return factoryObjectsRepository.findById(id).orElseThrow(() -> ExceptionFactory.objectNotFoundException(id));
    }

    @Override
    public FactoryObject createObject(FactoryObject obj) {
        return factoryObjectsRepository.save(obj);
    }

    @Override
    public void deleteObject(Integer id) {
        factoryObjectsRepository.deleteById(id);
    }

    @Override
    public FactoryObject updateObject(FactoryObject obj) {
        return factoryObjectsRepository.save(obj);
    }
}
