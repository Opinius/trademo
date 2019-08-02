package com.alexeus.trademo.domain.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

import java.io.IOException;

public class JsonTypeDescriptor extends AbstractTypeDescriptor<JsonNode> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonTypeDescriptor() {
        super(JsonNode.class);
    }

    @Override
    public JsonNode fromString(String string) {
        try {
            return objectMapper.readTree(string);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public <X> X unwrap(JsonNode value, Class<X> type, WrapperOptions options) {
        if (JsonNode.class.isAssignableFrom(type)) {
            return (X) value;
        } else {
            throw new RuntimeException("Can't unwrap type " + type.getName());
        }
    }

    @Override
    public <X> JsonNode wrap(X value, WrapperOptions options) {
        return fromString(String.valueOf(value));
    }
}
