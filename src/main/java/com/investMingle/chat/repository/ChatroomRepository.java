package com.investMingle.chat.repository;

import com.investMingle.chat.entity.Chatroom;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

import java.util.List;

public interface ChatroomRepository extends JpaRepository<Chatroom, Long> {
    List<Chatroom> findAll();
    List<Chatroom> findAllByNameContainingIgnoreCase(String name);
}
