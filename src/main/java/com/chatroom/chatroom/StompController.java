package com.chatroom.chatroom;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    @MessageMapping("/hello/{roomId}")
    @SendTo("/topic/greetings/{roomId}")
    public Hello hello(HelloMessage message) {
        return new Hello("Hello, " + message.getName() + " has entered the room!");
    }
    
    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/chat/{roomId}")
    public Messages chat(Messages chat) {
        System.out.println("/chat");
        return new Messages(chat.getUsername(), chat.getMessage());
    }
    
}
