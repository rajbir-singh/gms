package com.gms.attributeConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//@Converter(autoApply=true)
//uncommenting above line to avoid automatic application of the converter (will have to use correct representation of TRUE and FALSE in MYSQL (not "T" and "F")
//currently using this as a fix : @Type(type = "org.hibernate.type.NumericBooleanType") (https://codingexplained.com/coding/java/hibernate/hibernate-mapping-smallint-tinyint-int-column-to-boolean)
public class BooleanTFConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean value) {
        if (Boolean.TRUE.equals(value)) {
            return "T";
        } else {
            return "F";
        }
    }
    @Override
    public Boolean convertToEntityAttribute(String value) {
        return "T".equals(value);
    }
}
