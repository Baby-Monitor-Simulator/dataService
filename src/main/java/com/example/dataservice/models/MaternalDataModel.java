package com.example.dataservice.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MaternalDataModel {
    public int[] toco;
    public int[] maternalOxygenSaturation;
}
