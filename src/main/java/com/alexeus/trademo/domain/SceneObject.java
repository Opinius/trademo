package com.alexeus.trademo.domain;

import javax.persistence.*;

@Entity
@Table(name = "scenes_objects")
public class SceneObject {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private Integer sceneId;
    private Integer factoryObjectId;
    private String label;
    private Integer parentObjectId;
    private Integer x;
    private Integer y;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getFactoryObjectId() {
        return factoryObjectId;
    }

    public void setFactoryObjectId(Integer factoryObjectId) {
        this.factoryObjectId = factoryObjectId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getParentObjectId() {
        return parentObjectId;
    }

    public void setParentObjectId(Integer parentObjectId) {
        this.parentObjectId = parentObjectId;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
