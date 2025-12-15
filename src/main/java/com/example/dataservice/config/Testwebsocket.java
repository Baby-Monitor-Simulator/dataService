package com.example.dataservice.config;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(value = "/ws")
public class Testwebsocket {

    private static ObjectMapper objectMapper = new ObjectMapper();
    

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client connected: " + session.getId());
        session.getAsyncRemote().sendText("Connection established");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws Exception {

        JsonNode node = objectMapper.readTree(message);
        String type = node.get("type").asText();

        Map<String, Object> data = new HashMap<>();

        switch (type) {
            case "ping.ping":
                data.put("type", "ping.pong");
                break;
            case "echo":
                data.put("type", "echo");
                data.put("data", node.get("data").asText());
                break;
            case "broadcast":
                data.put("type", "broadcast");
                data.put("version", node.get("data").get("version").asText());
                data.put("payload", node.get("data").get("payload").asText());
                break;
            case "simulation.update":
                data.put("type", "simulation.update");
                data.put("version", node.get("data").get("version").asText());
                data.put("payload", node.get("data").get("payload").asText());
                break;
            default:
                data.put("type", "error");
                data.put("message", "Unknown message type: " + type);
                break;
        }

        data.put("timestamp", System.currentTimeMillis());

        String jsonString = objectMapper.writeValueAsString(data);

        if(type.equals("broadcast") || type.equals("simulation.update")){
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen()){
                    s.getAsyncRemote().sendText(jsonString);
                }
            }
        } else {
            // Send response to the sender only
            session.getAsyncRemote().sendText(jsonString);
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Client disconnected: " + session.getId());
        session.getAsyncRemote().sendText("Connection closed");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Error: " + throwable.getMessage());
        session.getAsyncRemote().sendText("Error: " + throwable.getMessage());
    }
}
