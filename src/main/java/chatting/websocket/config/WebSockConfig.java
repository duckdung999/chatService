package chatting.websocket.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

// STOMP 사용하기!
// Config 클래스이란 본디 xml 설정을 자바 클래스로 설정하게 끔 도와주는 애노테이션를 이용한 클래스..
// WebSockConfig = WebSocketMessageBrokerConfigurer 쯤으로 설정하고 세부 사항을 설정하는 거라고 보면 된다.
@Configuration
@EnableWebSocketMessageBroker
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // /sub 를 주소로 broker하나 열기, 구독요청은 /sub로 받게된다.
        config.enableSimpleBroker("/sub");
        // /pub 을 통해서 메시지를 뿌릴 수 있다.
        config.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp").setAllowedOriginPatterns("*")
                .withSockJS();
    }
}


/**
 *  웹 소켓
 // EnableWebSocket으로 웹소캣 활상화, 웹소켓 핸들러 등록하기
 @RequiredArgsConstructor
 @Configuration
 @EnableWebSocket
 public class WebSockConfig implements WebSocketConfigurer {
 private final WebSocketHandler webSocketHandler;

 @Override
 public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
 registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
 }
 }
 **/