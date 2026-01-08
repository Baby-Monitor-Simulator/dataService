package com.example.dataservice.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.eclipse.jetty.ee11.servlet.ServletContextHandler;
import org.eclipse.jetty.ee11.websocket.jakarta.server.config.JakartaWebSocketServletContainerInitializer;
import org.eclipse.jetty.server.Server;
import org.springframework.stereotype.Service;

import com.example.dataservice.config.Testwebsocket;

@Service("websocketservice")
public class TestJettyWebSocketService {

    private Server server;

    @PostConstruct
    public void start() {
         // Jetty wil runs separately from Spring Boot, so we set it up here
        server = new Server(8722);

        // Add WebSocket endpoint
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        JakartaWebSocketServletContainerInitializer.configure(
            context,
            (servletContext, container) -> container.addEndpoint(Testwebsocket.class)
        );

        // Start Jetty in a separate thread (non-blocking)
        new Thread(() -> {
            try {
                server.start();
                server.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    @PreDestroy
    public void stop() throws Exception {
        if (server != null && server.isRunning()) {
            server.stop();
        }
    }
}
