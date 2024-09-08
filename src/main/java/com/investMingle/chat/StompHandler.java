package com.investMingle.chat;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
public class StompHandler implements ChannelInterceptor {

//    @Override
//    public Message<?> preSend(Message<?> message, MessageChannel channel) {
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);
//        System.out.println("full message:" + message);
//        System.out.println("auth:" + headerAccessor.getNativeHeader("Authorization"));
//        System.out.println(headerAccessor.getHeader("nativeHeaders").getClass());
//        if (StompCommand.CONNECT.equals(headerAccessor.getCommand())) {
//            System.out.println("msg: " + "conne");
//        }
//        //throw new MessagingException("no permission! ");
//        return message;
//    }

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
