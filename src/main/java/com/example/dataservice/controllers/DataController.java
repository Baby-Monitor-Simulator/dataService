package com.example.dataservice.controllers;

import com.example.dataservice.models.DataModel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.messaging.handler.annotation.MessageMapping;


@Controller
@RequestMapping("/data")
public class DataController {

    private final SimpMessagingTemplate template;

    public DataController(SimpMessagingTemplate template){
        this.template = template;
    }

    public void sendData(Object message){
        template.convertAndSend("/data", message);
    }
}
