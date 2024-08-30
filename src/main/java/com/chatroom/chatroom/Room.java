package com.chatroom.chatroom;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Room {
    
    @BsonId
    private String id;
    private String name;
    private String createdBy;
    private List<Messages> content;

    public Room() {
    }
    public Room(String id, String name, String createdBy, List<Messages> content) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.content = content;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public List<Messages> getContent() {
        return content;
    }
    public void setContent(List<Messages> content) {
        this.content = content;
    }

    
}
