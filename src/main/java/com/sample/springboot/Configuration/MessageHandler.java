package com.sample.springboot.Configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageHandler extends TextWebSocketHandler {

    List<WebSocketSession> sessionList = new ArrayList<>();

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
            throws Exception {
        System.out.println("Disconnecting from server");
        session.sendMessage(new TextMessage("You are now disconnecting" +
                " the server. This is the first message."));
        // The WebSocket has been closed
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // The WebSocket has been opened
        // I might save this session object so that I can send messages
        // to it outside of this method
        sessionList.add(session);

        // Let's send the first message
        session.sendMessage(new TextMessage("You are now connected " +
                    "to the server. This is the first message."));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage textMessage) throws Exception {
        // A message has been received
        System.out.println("Message received: " + textMessage.getPayload());
        for(int i=0 ; i<5; i++){
            Thread.sleep(2000);
            session.sendMessage(new TextMessage("Message Received: "
                    + textMessage.getPayload() + "Request Number: "+i));
            Thread.sleep(2000);
            for(WebSocketSession sess: sessionList){
                sess.sendMessage(new TextMessage("This is a global message "+i));
            }
        }

    }
}
