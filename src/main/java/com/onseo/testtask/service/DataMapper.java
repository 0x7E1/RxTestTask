package com.onseo.testtask.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onseo.testtask.service.exceptions.DataMappingException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
class DataMapper {

    private ObjectMapper objectMapper;

    DataMapper() {
        this.objectMapper = new ObjectMapper();
    }

    <T> T mapToObject(String json, Class<T[]> targetClass) {
        try {
            T[] result = objectMapper.readValue(json, targetClass);
            log.info("Successfully mapped to " + targetClass.getName());
            return result[0];
        } catch (IOException | IndexOutOfBoundsException e) {
            throw new DataMappingException("Can't map initial json to " + targetClass.getName(), e);
        }
    }
}
