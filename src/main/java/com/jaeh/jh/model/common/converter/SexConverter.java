package com.jaeh.jh.model.common.converter;

import com.jaeh.jh.model.user.Sex;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SexConverter implements AttributeConverter<Sex, String> {

    @Override
    public String convertToDatabaseColumn(Sex attribute) {
        return attribute.getStringValue();
    }

    @Override
    public Sex convertToEntityAttribute(String dbData) {
        return Sex.ofStringValue(dbData);
    }
}
