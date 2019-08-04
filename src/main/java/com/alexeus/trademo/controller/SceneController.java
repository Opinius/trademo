package com.alexeus.trademo.controller;

import com.alexeus.trademo.domain.Scene;
import com.alexeus.trademo.domain.SceneObject;
import com.alexeus.trademo.dto.StatusInfo;
import com.alexeus.trademo.service.SceneService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Get all scenes", response = Scene[].class)
    @GetMapping("/list")
    public Iterable<Scene> getScenes() {
        return sceneService.getAllScenes();
    }

    @ApiOperation(value = "Create new scene")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Scene> createScene(@RequestBody Scene scene) {
        return new ResponseEntity<>(sceneService.createScene(scene), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update scene")
    @PutMapping
    public ResponseEntity<Scene> updateScene(@RequestBody Scene scene) {
        return new ResponseEntity<>(sceneService.updateScene(scene), HttpStatus.OK);
    }

    @ApiOperation(value = "Get scene by ID")
    @GetMapping("{id}")
    public Scene getScene(@PathVariable("id") Integer id) {
        return sceneService.getScene(id);
    }

    @ApiOperation(value = "Delete scene")
    @DeleteMapping("{id}")
    public ResponseEntity<StatusInfo> deleteScene(@PathVariable("id") Integer id) {
        sceneService.deleteScene(id);
        return new ResponseEntity<>(new StatusInfo(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all scene objects", response = SceneObject[].class)
    @GetMapping("/{id}/objects")
    public Iterable<SceneObject> getSceneObjects(@PathVariable("id") Integer sceneId) {
        return sceneService.getSceneObjects(sceneId);
    }

    @ApiOperation(value = "Get scene object by ID")
    @GetMapping("{id}/object/{objectId}")
    public ResponseEntity<StatusInfo> getSceneObject(@PathVariable("id") Integer id,
                                                     @PathVariable("objectId") Integer objectId) {
        sceneService.removeObject(id, objectId);
        return new ResponseEntity<>(new StatusInfo(), HttpStatus.OK);
    }

    @ApiOperation(value = "Remove object from scene")
    @DeleteMapping("{id}/object/{objectId}")
    public ResponseEntity<StatusInfo> removeSceneObject(@PathVariable("id") Integer id,
                                                        @PathVariable("objectId") Integer objectId) {
        sceneService.removeObject(id, objectId);
        return new ResponseEntity<>(new StatusInfo(), HttpStatus.OK);
    }

    @ApiOperation(value = "Place standalone object on scene")
    @PostMapping("{id}/place")
    public SceneObject placeObject(@PathVariable("id") Integer sceneId,
                                     @RequestParam("objectId") Integer objectId,
                                     @RequestParam("label") String label,
                                     @RequestParam("x") int x,
                                     @RequestParam("y") int y) {
        return sceneService.placeObject(sceneId, objectId, label, x, y);
    }

    @ApiOperation(value = "Equip scene object")
    @PostMapping("{id}/place/{parentObjectId}")
    public SceneObject placeObject(@PathVariable("id") Integer sceneId,
                                     @PathVariable("parentObjectId") Integer parentObjectId,
                                     @RequestParam("objectId") Integer objectId,
                                     @RequestParam("label") String label) {
        return sceneService.rigOutObject(sceneId, objectId, label, parentObjectId);
    }
}
