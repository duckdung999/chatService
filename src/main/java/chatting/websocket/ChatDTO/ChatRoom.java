package chatting.websocket.ChatDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = 6494678977089006639L;

    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}

/*
더이상 세션을 관리할 필요가 없어짐..

@Getter
public class ChatRoom {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
        // 메시지 타입이 enter면 입장
        if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
            //sessions 라는 변수에 저장... (동시성 이슈가 있을것 같다)
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
        }
        // 메시지 타입이 enter가 아니면, sendMessage
        sendMessage(chatMessage, chatService);
    }

    public <T> void sendMessage(T message, ChatService chatService) {
        //받아온 sessions에서 session을 하나씩 가져와서 사용자가 작성한 메시지를 보낸다.
        sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
    }
}
*/
