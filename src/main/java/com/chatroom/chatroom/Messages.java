package com.chatroom.chatroom;

public class Messages {
    private String username;
    private String message;
    public Messages(String username, String message) {
        this.username = username;
        this.message = message;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    
}
