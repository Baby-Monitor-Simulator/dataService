package com.example.dataservice.models;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DataModel{
    private String type;
    private String version;
    private PayloadModel payload;

    public DataModel(Object message){
    }
}