//package chatting.websocket.handler;
//
//import chatting.websocket.ChatDTO.ChatMessage;
//import chatting.websocket.ChatDTO.ChatRoom;
//import chatting.websocket.service.ChatService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//
//// 많은 종류의 WebSocketHandler중에 TexxtWebSocketHandler를 상속받고 component를 이용해 빈에 등록, 이후 config를 통해 핸들러로써 등록해야함.
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class WebSocketChatHandler extends TextWebSocketHandler {
//    private final ObjectMapper objectMapper;
//    private final ChatService chatService;
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload();
//        log.info("payload {}", payload);
//// 삭제        TextMessage textMessage = new TextMessage("Welcome chatting sever~^^ ");
//// 삭제       session.sendMessage(textMessage);
//        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
//        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
//        room.handleActions(session, chatMessage, chatService);
//    }
//}