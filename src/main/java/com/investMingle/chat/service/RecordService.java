package com.investMingle.chat.service;

import com.investMingle.chat.repository.ChatroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private ChatroomRepository chatroomRepository;

    public List<String> getRoomList() {
        return chatroomRepository.findAll().stream().map(chatroom -> chatroom.getName()).toList();
    }
    public List<String> getRoomList(String roomName) {
        return chatroomRepository.findAllByNameContainingIgnoreCase(roomName).stream().map(chatroom -> chatroom.getName()).toList();
    }

}
