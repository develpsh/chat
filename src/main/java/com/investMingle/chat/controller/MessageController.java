package com.investMingle.chat.controller;

import com.investMingle.chat.dto.MessageDto;
import com.investMingle.chat.entity.Chat;
import com.investMingle.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class MessageController {
    private final SimpMessageSendingOperations simpMessageSendingOperations;
    private final ChatRepository chatRepository;

    @MessageMapping("/{roomName}")
    public void message(MessageDto message,
                        @DestinationVariable String roomName) {
        Chat record = Chat.builder()
                .roomName(roomName)
                .chatUser(message.getSender())
                .chat(message.getData())
                .chatTime(LocalDateTime.now())
                .build();

        chatRepository.save(record);

        simpMessageSendingOperations.convertAndSend("/sub/channel/"+message.getChannelId(), message);
    }
}
