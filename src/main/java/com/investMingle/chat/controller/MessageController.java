package com.investMingle.chat.controller;

import com.investMingle.chat.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/hello")
    public void message(MessageDto message) {
        simpMessageSendingOperations.convertAndSend("/sub/channel/"+message.getChannelId(), message);
    }
}
