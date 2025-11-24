package com.example.dataservice.controllers;

import com.example.dataservice.models.DataModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.messaging.handler.annotation.MessageMapping;


@Controller
@RequestMapping("/data")
public class DataController {

    public DataController(){

    }

    @MessageMapping("/")
    public void postData(DataModel data){

    }
}
