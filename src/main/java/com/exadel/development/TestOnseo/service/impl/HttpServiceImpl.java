package com.exadel.development.TestOnseo.service.impl;

import com.exadel.development.TestOnseo.service.HttpService;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpServiceImpl implements HttpService {
    @Override
    public String doGet(String url) {
        try {
            HttpGet request = new HttpGet(url);
            request.addHeader("accept", "application/json");
            HttpResponse response = HttpClientBuilder.create()
                    .build()
                    .execute(request);

            return IOUtils.toString(response.getEntity().getContent(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
    }
}
