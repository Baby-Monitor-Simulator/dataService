package com.example.dataservice.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class DataController {

    @SendTo("/data")
    public Object SendData(Object message){
        return message;
    }
}
