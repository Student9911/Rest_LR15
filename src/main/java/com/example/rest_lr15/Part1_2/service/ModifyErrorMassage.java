package com.example.rest_lr15.Part1_2.service;

import com.example.rest_lr15.Part1_2.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("ModifyErrorMassage")

public class ModifyErrorMassage implements MyModifyService {
        @Override
        public Response modify(Response response) {
                response.setErrorMessage("Что-то сломалось");
                return response;
        }
}
