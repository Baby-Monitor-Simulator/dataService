package com.example.dataservice.service;

import com.example.dataservice.controller.DataController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RabbitMQListenerTest {

    @Mock
    private DataController dataController;

    @InjectMocks
    private RabbitMQListener rabbitMQListener;

    @Test
    public void MatlabListenerTest(){
        //Arrange
        String message = "Test";
        String RoutingKey = "TestRouting";

        //Act
        rabbitMQListener.MatlabListener(message, RoutingKey);

        //Assert
        Mockito.verify(dataController).SendData(message);
    }
}
