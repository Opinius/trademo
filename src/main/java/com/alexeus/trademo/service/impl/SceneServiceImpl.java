package com.alexeus.trademo.service.impl;

import com.alexeus.trademo.dao.FactoryObjectsRepository;
import com.alexeus.trademo.dao.SceneObjectsRepository;
import com.alexeus.trademo.dao.ScenesRepository;
import com.alexeus.trademo.domain.FactoryObject;
import com.alexeus.trademo.domain.Scene;
import com.alexeus.trademo.domain.SceneObject;
import com.alexeus.trademo.service.SceneService;
import com.alexeus.trademo.util.ExceptionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SceneServiceImpl implements SceneService {
    private final ScenesRepository scenesRepository;
    private final SceneObjectsRepository sceneObjectsRepository;
    private final FactoryObjectsRepository factoryObjectsRepository;

    @Autowired
    public SceneServiceImpl(ScenesRepository scenesRepository,
                            SceneObjectsRepository sceneObjectsRepository,
                            FactoryObjectsRepository factoryObjectsRepository) {
        this.scenesRepository = scenesRepository;
        this.sceneObjectsRepository = sceneObjectsRepository;
        this.factoryObjectsRepository = factoryObjectsRepository;
    }

    @Override
    public Iterable<Scene> getAllScenes() {
        return scenesRepository.findAll();
    }

    @Override
    public Scene getScene(Integer id) {
        return scenesRepository.findById(id).orElseThrow(() -> ExceptionFactory.sceneNotFoundException(id));
    }

    @Override
    public Scene createScene(Scene scene) {
        return scenesRepository.save(scene);
    }

    @Override
    public void deleteScene(Integer id) {
        scenesRepository.deleteById(id);
    }

    @Override
    public Scene updateScene(Scene scene) {
        return scenesRepository.save(scene);
    }

    @Override
    public Iterable<SceneObject> getSceneObjects(Integer sceneId) {
        return sceneObjectsRepository.getObjects(sceneId);
    }

    @Override
    public SceneObject getSceneObject(Integer sceneId, Integer objectId) {
        return sceneObjectsRepository.findById(objectId).orElseThrow(() -> ExceptionFactory.sceneHasNoSuchObject(sceneId, objectId));
    }

    @Override
    public SceneObject placeObject(Integer sceneId, Integer objectId, String label, int x, int y) {
        final FactoryObject factoryObject = factoryObjectsRepository.findById(objectId).orElseThrow(() -> ExceptionFactory.objectNotFoundException(objectId));
        if (!factoryObject.getType().isIndependent()) {
            throw ExceptionFactory.objectIsNotStandalone(factoryObject.getName());
        }
        SceneObject obj = new SceneObject();
        obj.setSceneId(sceneId);
        obj.setFactoryObjectId(objectId);
        obj.setLabel(label != null ? label : factoryObject.getName());
        obj.setX(x);
        obj.setY(y);
        return sceneObjectsRepository.save(obj);
    }

    @Override
    public SceneObject rigOutObject(Integer sceneId, Integer objectId, String label, Integer parentObjectId) {
        final FactoryObject factoryObject = factoryObjectsRepository.findById(objectId).orElseThrow(() -> ExceptionFactory.objectNotFoundException(objectId));
        if (factoryObject.getType().isIndependent()) {
            throw ExceptionFactory.objectIsStandalone(factoryObject.getName());
        }
        SceneObject obj = new SceneObject();
        obj.setSceneId(sceneId);
        obj.setFactoryObjectId(objectId);
        obj.setLabel(label != null ? label : factoryObject.getName());
        obj.setParentObjectId(parentObjectId);
        return sceneObjectsRepository.save(obj);
    }

    @Override
    public void removeObject(Integer sceneId, Integer objectId) {
        sceneObjectsRepository.deleteChildren(objectId);
        sceneObjectsRepository.deleteById(objectId);
    }
}
