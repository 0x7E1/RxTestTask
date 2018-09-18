package com.exadel.development.TestOnseo.service;

import com.exadel.development.TestOnseo.service.exceptions.DataMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

class DataMapper {

    private ObjectMapper objectMapper;

    DataMapper() {
        this.objectMapper = new ObjectMapper();
    }

    <T> T mapToObject(String json, Class<T[]> targetClass) {
        try {
            T[] result = objectMapper.readValue(json, targetClass);
            return result[0];
        } catch (IOException | IndexOutOfBoundsException e) {
            throw new DataMappingException("Can't map initial json to " + targetClass.getName(), e);
        }
    }
}
