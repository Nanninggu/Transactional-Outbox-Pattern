package com.example.TransactionalOutBoxPattern.UserMapper;

import com.example.TransactionalOutBoxPattern.dto.Outbox;
import com.example.TransactionalOutBoxPattern.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users(id, username, email) VALUES(#{id}, #{username}, #{email})")
    void insertUser(User user);

    @Insert("INSERT INTO outbox(\"aggregateId\", \"aggregateType\", \"eventType\", payload) " +
            "VALUES(#{aggregateId}, #{aggregateType}, #{eventType}, #{payload})")
    void insertOutbox(Outbox outbox);

}
