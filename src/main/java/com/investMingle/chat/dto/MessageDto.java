package com.investMingle.chat.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.json.simple.JSONObject;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String type;
    private String sender;
    private String channelId;
    private String data;

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void newConnect() {
        this.type = "new";
    }

    public void closeConnect() {
        this.type = "close";
    }
}
