package com.alexeus.trademo.service;

import com.alexeus.trademo.dto.request.FactoryObject;
import com.alexeus.trademo.dto.request.IndependentObject;
import com.alexeus.trademo.dto.request.RiggingObject;
import com.alexeus.trademo.dto.request.SceneObject;

import java.util.Random;

public class SceneObjectFactory {

    public static SceneObject createSceneObject(FactoryObject factoryObject, String label) {
        if ("independent".equalsIgnoreCase(factoryObject.getType())) {
            IndependentObject obj = new IndependentObject();
            obj.setId(String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
            obj.setName(label != null ? label : factoryObject.getName());
            obj.setObjectId(factoryObject.getId());
            obj.setType(factoryObject.getType());
            obj.setSubType(factoryObject.getSubType());
            return obj;
        } else if ("rigging".equalsIgnoreCase(factoryObject.getType())) {
            RiggingObject obj = new RiggingObject();
            obj.setId(String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
            obj.setName(label != null ? label : factoryObject.getName());
            obj.setObjectId(factoryObject.getId());
            obj.setType(factoryObject.getType());
            obj.setSubType(factoryObject.getSubType());
            return obj;
        } else {
            throw new IllegalArgumentException("Unknown object type");
        }
    }

    public static SceneObject createSceneObject(FactoryObject factoryObject, String label, int x, int y) {
        if ("independent".equalsIgnoreCase(factoryObject.getType())) {
            IndependentObject obj = new IndependentObject();
            obj.setId(String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
            obj.setName(label != null ? label : factoryObject.getName());
            obj.setObjectId(factoryObject.getId());
            obj.setType(factoryObject.getType());
            obj.setSubType(factoryObject.getSubType());
            obj.setX(x);
            obj.setY(y);
            return obj;
        } else if ("rigging".equalsIgnoreCase(factoryObject.getType())) {
            RiggingObject obj = new RiggingObject();
            obj.setId(String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
            obj.setName(label != null ? label : factoryObject.getName());
            obj.setObjectId(factoryObject.getId());
            obj.setType(factoryObject.getType());
            obj.setSubType(factoryObject.getSubType());
            return obj;
        } else {
            throw new IllegalArgumentException("Unknown object type");
        }
    }

    public static SceneObject createSceneObject(FactoryObject factoryObject, String label, String sceneObjectId) {
        if ("independent".equalsIgnoreCase(factoryObject.getType())) {
            IndependentObject obj = new IndependentObject();
            obj.setId(String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
            obj.setName(label != null ? label : factoryObject.getName());
            obj.setObjectId(factoryObject.getId());
            obj.setType(factoryObject.getType());
            obj.setSubType(factoryObject.getSubType());
            return obj;
        } else if ("rigging".equalsIgnoreCase(factoryObject.getType())) {
            RiggingObject obj = new RiggingObject();
            obj.setId(String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
            obj.setName(label != null ? label : factoryObject.getName());
            obj.setObjectId(factoryObject.getId());
            obj.setType(factoryObject.getType());
            obj.setSubType(factoryObject.getSubType());
            obj.setParentObjectId(sceneObjectId);
            return obj;
        } else {
            throw new IllegalArgumentException("Unknown object type");
        }
    }
}
