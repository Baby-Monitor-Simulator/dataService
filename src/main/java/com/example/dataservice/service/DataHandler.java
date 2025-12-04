package com.example.dataservice.service;

import com.example.dataservice.models.DataModel;
import tools.jackson.databind.ObjectMapper;

public class DataHandler {


    public DataModel HandleMessage(Object message){
        return new DataModel(message);
    }
}
