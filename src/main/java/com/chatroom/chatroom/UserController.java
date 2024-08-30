package com.chatroom.chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;



@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping("/")
    public String getMethodName() {
        return "Server Working";
    }

    @PostMapping("/create-user")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public String loginBody(@RequestBody User user) {
        return userService.login(user);
    }
    
    @PostMapping("/create-room")
    public String createRoomString(@RequestBody Room room) {
        return userService.createRoom(room);
    }

    @GetMapping("/get-rooms")
    @ResponseBody
    public List<Room> getRooms() {
        return userService.getRooms();
    }

    @GetMapping("/fetch-messages/{roomId}")
    @ResponseBody
    public List<Messages> getMessages(@PathVariable("roomId") String roomId) {
        System.out.println(roomId);
        return userService.getMessages(roomId);
    }

    @PostMapping("/send-message-to-database/{name}")
    public String sendMessageToDatabase(@PathVariable("name") String roomId, @RequestBody Messages message) {
        System.out.println(roomId);
        System.out.println(message.getMessage());
        return userService.sendMessageToDatabase(roomId, message);
    }
    
    
    
}
