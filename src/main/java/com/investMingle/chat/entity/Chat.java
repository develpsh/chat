package com.investMingle.chat.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "chat", indexes = @Index(name = "idx_chat_room", columnList = "room_name"))
public class Chat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "chat_user")
    private String chatUser;

    @Column(name = "chat")
    private String chat;

    @Column(name = "chat_time")
    private LocalDateTime chatTime;
}
