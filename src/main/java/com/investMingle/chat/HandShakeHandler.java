package com.investMingle.chat;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeFailureException;
import org.springframework.web.socket.server.HandshakeHandler;

import java.util.Map;

public class HandShakeHandler implements HandshakeHandler {
    @Override
    public boolean doHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws HandshakeFailureException {
        request.getHeaders().forEach(((s, strings) -> {
            System.out.println("key : value = " + s + " : " + strings.toString());
        }));
//        System.out.println("authorization = " + request.getHeaders().get("authorization"));
//        System.out.println("authorization = " + request.getHeaders().get("authorization").get(0));
//        if (!request.getHeaders().get("authorization").get(0).equals("abc")){
//            return false;
//        }
//        String jwt = request.getHeaders().get("sec-websocket-token").get(0);
//        if (!jwt.equals("abc")) {
//            return false;
//        }
        return true;
    }
}
