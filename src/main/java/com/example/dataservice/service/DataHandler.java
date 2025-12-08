package com.example.dataservice.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataHandler {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public DataHandler(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void SendData(Object message){
        simpMessagingTemplate.convertAndSend("/data", message);
    }
}
