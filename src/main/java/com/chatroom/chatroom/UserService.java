package com.chatroom.chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.mongodb.MongoException;
import java.util.*;

@Service
public class UserService {

    @Autowired 
    MongoTemplate mongoTemplate;

    public String createUser(User user) {

        try {
            mongoTemplate.save(user, "users");
            return "success";
        } catch (MongoException e) {
            return e.getMessage();
        }
    }

    public String login(User user) {

        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("username").is(user.getUsername()))
                .addCriteria(Criteria.where("password").is(user.getPassword()));
            user = mongoTemplate.findOne(query, User.class);
            return user.getUsername();
        } catch (Exception e) {
            return null;
        }

    }

    public String createRoom(Room room) {
        try {
            mongoTemplate.save(room, "rooms");
            return "success";
        } catch (MongoException e) {
            return e.getMessage();
        }
    }

    public List<Room> getRooms() {

        @SuppressWarnings({ "unchecked", "rawtypes" })
        List<Room> rooms = new ArrayList();
        rooms = mongoTemplate.findAll(Room.class, "rooms");
        return rooms;
    }

    public List<Messages> getMessages(String roomName) {

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(roomName));
        
        Room room = mongoTemplate.findOne(query, Room.class, "rooms");

        return room != null ? room.getContent() : new ArrayList<>();
    }

    public String sendMessageToDatabase(String roomId, Messages message) {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("name").is(roomId));

            Update update = new Update();
            update.push("content", message);

            mongoTemplate.updateFirst(query, update, Room.class, "rooms");

            return "success";
        } catch (MongoException e) {
            return e.getMessage();
        }
    }

    
}
