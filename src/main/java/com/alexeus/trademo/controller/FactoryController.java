package com.alexeus.trademo.controller;

import com.alexeus.trademo.dto.StatusInfo;
import com.alexeus.trademo.domain.FactoryObject;
import com.alexeus.trademo.domain.ObjectType;
import com.alexeus.trademo.service.FactoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/factory")
public class FactoryController {

    private final FactoryService factoryService;

    @Autowired
    public FactoryController(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GetMapping("/type/list")
    public Iterable<ObjectType> getObjectTypes() {
        return factoryService.listObjectTypes();
    }

    @PostMapping("/type")
    public ResponseEntity<ObjectType> createObjectType(@RequestBody ObjectType objType) {
        return new ResponseEntity<>(factoryService.createObjectType(objType), HttpStatus.CREATED);
    }

    @ApiOperation(value = "View a list of available factory objects", response = Iterable.class)
    @GetMapping("/object/list")
    public Iterable<FactoryObject> getObjects() {
        return factoryService.listObjects();
    }

    @ApiOperation(value = "Get Factory object by ID", response = FactoryObject.class)
    @GetMapping("/object/{id}")
    public ResponseEntity<FactoryObject> getObject(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(factoryService.getObject(id), HttpStatus.OK);
    }

    @GetMapping("/object/search")
    public Iterable<FactoryObject> searchObjects(HttpServletRequest request) {
        return factoryService.findObjects(request.getParameterMap());
    }

    @PostMapping("/object")
    public ResponseEntity<FactoryObject> createObject(@RequestBody FactoryObject obj, HttpServletRequest request) {
        return new ResponseEntity<>(factoryService.createObject(obj), HttpStatus.CREATED);
    }

    @PutMapping("/object")
    public ResponseEntity<FactoryObject> updateObject(@RequestBody FactoryObject obj) {
        return new ResponseEntity<>(factoryService.updateObject(obj), HttpStatus.OK);
    }

    @DeleteMapping("/object/{id}")
    public ResponseEntity<StatusInfo> deleteObject(@PathVariable("id") Integer id) {
        factoryService.deleteObject(id);
        return new ResponseEntity<>(new StatusInfo(), HttpStatus.OK);
    }
}
