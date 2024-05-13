package com.example.TransactionalOutBoxPattern.service;

import com.example.TransactionalOutBoxPattern.UserMapper.UserMapper;
import com.example.TransactionalOutBoxPattern.dto.Outbox;
import com.example.TransactionalOutBoxPattern.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final KafkaService kafkaService;

    @Autowired
    public UserService(UserMapper userMapper, KafkaService kafkaService) {
        this.userMapper = userMapper;
        this.kafkaService = kafkaService;
    }

    @Transactional
    public void createUser(User user) throws JsonProcessingException {
        String TOPIC = "exam";
        userMapper.insertUser(user);

        Outbox outbox = new Outbox();
        outbox.setAggregateId(user.getId());
        outbox.setAggregateType("User");
        outbox.setEventType("UserCreated");
        String payload = new ObjectMapper().writeValueAsString(user); // convert user to JSON string
        outbox.setPayload(payload);

        userMapper.insertOutbox(outbox);

        if ("UserCreated".equals(outbox.getEventType())) {
            kafkaService.sendMessage(TOPIC, payload);
        }
    }

}
