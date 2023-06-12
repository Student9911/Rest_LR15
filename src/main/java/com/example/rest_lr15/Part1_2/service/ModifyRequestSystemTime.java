package com.example.rest_lr15.Part1_2.service;

import com.example.rest_lr15.Part1_2.model.Request;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;

@Service
public class ModifyRequestSystemTime implements ModifyRequestService{
    @Override
    public void modify(Request request) {

        request.setSystemTime(LocalTime.now().toString()); // Установить текущее время и преобразовать в строку
        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8082/feedback", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<>() {
        });

    }
}
