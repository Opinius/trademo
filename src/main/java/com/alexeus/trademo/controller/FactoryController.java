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

    @ApiOperation(value = "View a list of available object types", response = ObjectType[].class)
    @GetMapping("/type/list")
    public Iterable<ObjectType> getObjectTypes() {
        return factoryService.listObjectTypes();
    }

    @ApiOperation(value = "Create new object type")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/type")
    public ResponseEntity<ObjectType> createObjectType(@RequestBody ObjectType objType) {
        return new ResponseEntity<>(factoryService.createObjectType(objType), HttpStatus.CREATED);
    }

    @ApiOperation(value = "View a list of available factory objects", response = FactoryObject[].class)
    @GetMapping("/object/list")
    public Iterable<FactoryObject> getObjects() {
        return factoryService.listObjects();
    }

    @ApiOperation(value = "Get Factory object by ID")
    @GetMapping("/object/{id}")
    public ResponseEntity<FactoryObject> getObject(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(factoryService.getObject(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Search factory objects by criteria", response = FactoryObject[].class)
    @GetMapping("/object/search")
    public Iterable<FactoryObject> searchObjects(HttpServletRequest request) {
        return factoryService.findObjects(request.getParameterMap());
    }

    @ApiOperation(value = "Create new Factory object")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/object")
    public ResponseEntity<FactoryObject> createObject(@RequestBody FactoryObject obj, HttpServletRequest request) {
        return new ResponseEntity<>(factoryService.createObject(obj), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Factory object")
    @PutMapping("/object")
    public ResponseEntity<FactoryObject> updateObject(@RequestBody FactoryObject obj) {
        return new ResponseEntity<>(factoryService.updateObject(obj), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Factory object")
    @DeleteMapping("/object/{id}")
    public ResponseEntity<StatusInfo> deleteObject(@PathVariable("id") Integer id) {
        factoryService.deleteObject(id);
        return new ResponseEntity<>(new StatusInfo(), HttpStatus.OK);
    }
}
