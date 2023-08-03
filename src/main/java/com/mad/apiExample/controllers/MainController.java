package com.mad.apiExample.controllers;

import com.mad.apiExample.constants.GeneralResponseConstant;
import com.mad.apiExample.models.responses.EnterpriseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    String[] students = new String[]{"Kuldeep", "Sam", "Rohan", "Vishrut", "Mrinalini"};


    @GetMapping("/ping")
    public ResponseEntity<EnterpriseResponse<String>> ping() {

        ResponseEntity response =
                EnterpriseResponse.success(GeneralResponseConstant.RECORD_FETCHED_SUCCESSFUL, "pong");
        return response;
    }


    @GetMapping("/students")
    public ResponseEntity<EnterpriseResponse<String[]>> getStudents() {

        ResponseEntity response =
                EnterpriseResponse.success(GeneralResponseConstant.RECORD_FETCHED_SUCCESSFUL, students);
        return response;
    }

}
