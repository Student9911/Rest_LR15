package com.example.rest_lr15.Part1_2.controller;

import com.example.rest_lr15.Part1_2.model.Request;
import com.example.rest_lr15.Part1_2.model.Response;
import com.example.rest_lr15.Part1_2.service.MyModifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MyController {

    private final MyModifyService myModifyService;

    @Autowired
    public MyController(@Qualifier("ModifyErrorMassage") MyModifyService myModifyService) {
        this.myModifyService = myModifyService;
    }




    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request) {

        log.info("Входящий request: " + String.valueOf(request));

        Response response = Response.builder()
                .uid(request.getUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        Response responseAfterModify = myModifyService.modify(response);
        log.info("Исходящий response: " + String.valueOf(request));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
