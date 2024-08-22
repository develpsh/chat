package com.investMingle.chat.config;

//import com.investMingle.chat.CorsFilter;
//import com.investMingle.chat.HandShakeHandler;
//import com.investMingle.chat.SocketInterceptor;
import com.investMingle.chat.StompHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private StompHandler stompHandler;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry
//                .addEndpoint("/chat")
////                .setHandshakeHandler(new HandShakeHandler())
////                .addInterceptors(new SocketInterceptor())
////                .setAllowedOrigins("*")
//                .setAllowedOriginPatterns("*")//("*","http://localhost:5173","http://localhost:3000","http://localhost:8080/ws")
//                .withSockJS();
        registry
                .addEndpoint("/chat");
//                .setAllowedOriginPatterns("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(stompHandler);
    }
}
