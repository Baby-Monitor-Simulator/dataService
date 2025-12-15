package com.example.dataservice.component;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.net.URI;
import java.util.concurrent.CompletionStage;
import java.net.http.HttpClient;
import java.net.http.WebSocket;

@Component
public class DataController {

    private WebSocket webSocket;

    @EventListener(ApplicationReadyEvent.class)
    public void connect() {
        HttpClient client = HttpClient.newHttpClient();

        webSocket = client.newWebSocketBuilder()
                .buildAsync(URI.create("ws://localhost:8722/ws"), new WebSocket.Listener() {
                    @Override
                    public void onOpen(WebSocket webSocket) {
                        System.out.println("Connected to server");
                        webSocket.sendText("Hello from Spring component!", true);
                        WebSocket.Listener.super.onOpen(webSocket);
                    }

                    @Override
                    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                        System.out.println("Received: " + data);
                        return WebSocket.Listener.super.onText(webSocket, data, last);
                    }

                    @Override
                    public void onError(WebSocket webSocket, Throwable error) {
                        error.printStackTrace();
                    }

                    @Override
                    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                        System.out.println("Connection closed: " + statusCode + " - " + reason);
                        return WebSocket.Listener.super.onClose(webSocket, statusCode, reason);
                    }
                }).join();
    }

    public Object SendData(Object message) {
        if (webSocket != null) {
            webSocket.sendText(message.toString(), true);
        }
        return message;
    }
}
