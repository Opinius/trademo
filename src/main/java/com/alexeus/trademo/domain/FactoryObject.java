package com.alexeus.trademo.domain;

import com.alexeus.trademo.domain.types.JsonbType;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@ApiModel(value = "Factory Object")
@Entity
@Table(name = "factory_objects")
@TypeDef(name = "jsonb", typeClass = JsonbType.class)
public class FactoryObject {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "type_id", foreignKey = @ForeignKey(name = "object_type_fk"))
    private ObjectType type;
    @Column(name = "subtype")
    private String subType;
    private String name;
    @ApiModelProperty(value = "Object attributes as key-value pairs", dataType = "java.lang.String", example = "length, width etc")
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private JsonNode attributes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ObjectType getType() {
        return type;
    }

    public void setType(ObjectType type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonNode getAttributes() {
        return attributes;
    }

    public void setAttributes(JsonNode attributes) {
        this.attributes = attributes;
    }
}
