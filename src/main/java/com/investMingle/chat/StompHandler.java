package com.investMingle.chat;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StompHandler implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);
        StompHeaderAccessor headerAccessor2 = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (message.getHeaders().get("stompCommand").equals(StompCommand.CONNECT)) {
            List<String> authorization = headerAccessor2.getNativeHeader("Auth");
            System.out.println(authorization);

            Object nativeHeaders = message.getHeaders().get("nativeHeaders");
            System.out.println("nativeHeaders = " + nativeHeaders);

            System.out.println("full message : " + message);
            System.out.println("channel : " + channel);
            System.out.println("Auth : " + headerAccessor.getNativeHeader("Auth"));
            System.out.println("header.nativeHeaders : " + headerAccessor.getHeader("nativeHeaders"));
            if (headerAccessor2.getNativeHeader("Auth").get(0).equals("abc")) {
                System.out.println("Hi");
            }
        }
        if (StompCommand.CONNECT.equals(headerAccessor.getCommand())) {
            System.out.println("msg: " + "conne");
        }

        if (message.getHeaders().get("stompCommand").equals(StompCommand.SUBSCRIBE)) {
            System.out.println("full message : " + message);
            System.out.println("header.nativeHeaders : " + headerAccessor.getHeader("nativeHeaders"));
            System.out.println(message.getPayload().toString());
        }
        //throw new MessagingException("no permission! ");
        return message;
    }

//    @Override
//    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
//        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//        String sessionId = accessor.getSessionId();
//        System.out.println("sessionId = " + sessionId);
//        switch (accessor.getCommand()) {
//            case CONNECT:
//                // 유저가 Websocket으로 connect()를 한 뒤 호출됨
//                System.out.println("[postSend] connected");
//                break;
//            case DISCONNECT:
//                // 유저가 Websocket으로 disconnect() 를 한 뒤 호출됨 or 세션이 끊어졌을 때 발생함(페이지 이동~ 브라우저 닫기 등)
//                System.out.println("[postSend] disconnected");
//                break;
//            default:
//                break;
//        }
//    }
}
