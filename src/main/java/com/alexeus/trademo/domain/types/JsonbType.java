package com.alexeus.trademo.domain.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;

public class JsonbType extends AbstractSingleColumnStandardBasicType<JsonNode> {
    public JsonbType() {
        super(
                new JsonbSqlTypeDescriptor(),
                new JsonTypeDescriptor()
        );
    }

    @Override
    public String getName() {
        return "jsonb";
    }
}
