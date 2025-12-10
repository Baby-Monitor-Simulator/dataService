package com.example.dataservice.service;

import com.example.dataservice.controller.DataController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.ModelAndViewAssert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private DataController dataController;

    @Test
    public void DataControllerTest(){
        //Arrange
        Object message = "Test";

        //Act
        Object result = dataController.SendData(message);

        //Assert

        assertEquals(message, result);
    }
}
