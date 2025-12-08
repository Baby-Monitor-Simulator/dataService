package com.example.dataservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@ExtendWith(MockitoExtension.class)
public class DataHandlerTest {

    @Mock
    private SimpMessagingTemplate simpMessagingTemplate;

    @InjectMocks
    private DataHandler dataHandler;

    @Test
    public void SendDataTest(){
        //Arrange
        String message = "Test";

        //Act
        dataHandler.SendData(message);

        //Assert
        Mockito.verify(simpMessagingTemplate)
                .convertAndSend("/data", message);
    }
}
