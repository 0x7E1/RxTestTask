package com.onseo.testtask.service;

import com.onseo.testtask.service.exceptions.DataLoadingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

@Slf4j
class HttpService {

    String doGet(String url) {
        try {
            HttpResponse response = HttpClientBuilder.create()
                    .build()
                    .execute(createRequest(url));
            log.info("HTTP request success");
            return IOUtils.toString(response.getEntity().getContent(), "UTF-8");
        } catch (Exception e) {
            throw new DataLoadingException("Can't load data from: " + url, e);
        }
    }

    private HttpGet createRequest(String url) {
        HttpGet request = new HttpGet(url);
        request.addHeader("accept", "application/json");

        return request;
    }
}
