package com.alexeus.trademo.controller;

import com.alexeus.trademo.domain.Scene;
import com.alexeus.trademo.domain.SceneObject;
import com.alexeus.trademo.dto.StatusInfo;
import com.alexeus.trademo.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scene")
public class SceneController {

    private final SceneService sceneService;

    @Autowired
    public SceneController(SceneService sceneService) {
        this.sceneService = sceneService;
    }

    @GetMapping("/list")
    public Iterable<Scene> getScenes() {
        return sceneService.getAllScenes();
    }

    @PostMapping
    public ResponseEntity<Scene> createScene(@RequestBody Scene scene) {
        return new ResponseEntity<>(sceneService.createScene(scene), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Scene> updateScene(@RequestBody Scene obj) {
        return new ResponseEntity<>(sceneService.updateScene(obj), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Scene getScene(@PathVariable("id") Integer id) {
        return sceneService.getScene(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StatusInfo> deleteScene(@PathVariable("id") Integer id) {
        sceneService.deleteScene(id);
        return new ResponseEntity<>(new StatusInfo(), HttpStatus.OK);
    }

    @GetMapping("/{id}/objects")
    public Iterable<SceneObject> getSceneObjects(@PathVariable("id") Integer sceneId) {
        return sceneService.getSceneObjects(sceneId);
    }

    @GetMapping("{id}/object/{objectId}")
    public ResponseEntity<StatusInfo> getSceneObject(@PathVariable("id") Integer id,
                                                     @PathVariable("objectId") Integer objectId) {
        sceneService.removeObject(id, objectId);
        return new ResponseEntity<>(new StatusInfo(), HttpStatus.OK);
    }

    @DeleteMapping("{id}/object/{objectId}")
    public ResponseEntity<StatusInfo> removeSceneObject(@PathVariable("id") Integer id,
                                                        @PathVariable("objectId") Integer objectId) {
        sceneService.removeObject(id, objectId);
        return new ResponseEntity<>(new StatusInfo(), HttpStatus.OK);
    }

    @PostMapping("{id}/place")
    public SceneObject placeObject(@PathVariable("id") Integer sceneId,
                                     @RequestParam("objectId") Integer objectId,
                                     @RequestParam("label") String label,
                                     @RequestParam("x") int x,
                                     @RequestParam("y") int y) {
        return sceneService.placeObject(sceneId, objectId, label, x, y);
    }

    @PostMapping("{id}/place/{parentObjectId}")
    public SceneObject placeObject(@PathVariable("id") Integer sceneId,
                                     @PathVariable("parentObjectId") Integer parentObjectId,
                                     @RequestParam("objectId") Integer objectId,
                                     @RequestParam("label") String label) {
        return sceneService.rigOutObject(sceneId, objectId, label, parentObjectId);
    }
}
