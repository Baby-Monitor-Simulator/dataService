package com.example.dataservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.dataservice.component.DataController;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private DataController dataController;

    @Test
    public void DataControllerTest() throws IOException {
        //Arrange
        String message = "Test";

        //Act
        Object result = dataController.SendData(message);

        //Assert

        assertEquals(message, result);
    }
}
