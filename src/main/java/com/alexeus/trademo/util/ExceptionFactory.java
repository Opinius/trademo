package com.alexeus.trademo.util;

import com.alexeus.trademo.exception.ConflictException;
import com.alexeus.trademo.exception.NotFoundException;

public class ExceptionFactory {
    private static final String OBJECT_NOT_FOUND = "Object with %d is not found";
    private static final String TYPE_NOT_FOUND = "Object type with %d is not found";
    private static final String SCENE_NOT_FOUND = "Scene with %d is not found";
    private static final String SCENE_HAS_NO_SUCH_OBJECT = "Scene with %d has no object with id %d";
    private static final String OBJECT_IS_NOT_STANDALONE = "Object with %s can not be standalone";
    private static final String OBJECT_IS_STANDALONE = "Object with %s can not be rig out to other";

    public static RuntimeException objectNotFoundException(Integer objectId) {
        return new NotFoundException(String.format(OBJECT_NOT_FOUND, objectId));
    }

    public static RuntimeException typeNotFoundException(Integer objectId) {
        return new NotFoundException(String.format(TYPE_NOT_FOUND, objectId));
    }

    public static RuntimeException sceneNotFoundException(Integer objectId) {
        return new NotFoundException(String.format(SCENE_NOT_FOUND, objectId));
    }

    public static RuntimeException sceneHasNoSuchObject(Integer sceneId, Integer objectId) {
        return new NotFoundException(String.format(SCENE_HAS_NO_SUCH_OBJECT, sceneId, objectId));
    }

    public static RuntimeException objectIsNotStandalone(String objectName) {
        return new NotFoundException(String.format(OBJECT_IS_NOT_STANDALONE, objectName));
    }

    public static RuntimeException objectIsStandalone(String objectName) {
        return new ConflictException(String.format(OBJECT_IS_STANDALONE, objectName));
    }
}
