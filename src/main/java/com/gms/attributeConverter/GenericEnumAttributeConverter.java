package com.gms.attributeConverter;

import com.gms.enums.State;
import com.gms.service.Utils;
import com.google.common.collect.BiMap;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

public abstract class GenericEnumAttributeConverter<J, D> implements AttributeConverter<J, D> {

    protected BiMap<J, D> map;

    abstract protected BiMap<J, D> createMap();

    public GenericEnumAttributeConverter() {
        map = createMap();
    }

    @Override
    public D convertToDatabaseColumn(J javaObject) {
        return map.get(javaObject);
    }

    @Override
    public J convertToEntityAttribute(D dbData) {

        J javaObject = map.inverse().get(dbData);
        return javaObject;
    }

}
