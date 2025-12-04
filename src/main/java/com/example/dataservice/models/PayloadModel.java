package com.example.dataservice.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PayloadModel {
    public int totalTimesteps;
    public int timesteps;
    public int fetusCount;
    public MaternalDataModel maternalDataModel;
    public int[][] fetusData;
}
