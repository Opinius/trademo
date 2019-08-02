package com.alexeus.trademo.service;

import com.alexeus.trademo.domain.Scene;
import com.alexeus.trademo.domain.SceneObject;

public interface SceneService {
    Iterable<Scene> getAllScenes();
    Scene getScene(Integer id);
    Scene createScene(Scene scene);
    void deleteScene(Integer id);
    Scene updateScene(Scene scene);
    Iterable<SceneObject> getSceneObjects(Integer sceneId);
    SceneObject getSceneObject(Integer sceneId, Integer objectId);
    SceneObject placeObject(Integer sceneId, Integer objectId, String label, int x, int y);
    SceneObject rigOutObject(Integer sceneId, Integer objectId, String label, Integer parentObjectId);
    void removeObject(Integer sceneId, Integer objectId);
}
