package primeirob.terceiraatv;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/chat")
public class WebSocketServer {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Cliente conectado: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("Mensagem recebida de " + session.getId() + ": " + message);
        // Enviar de volta a mesma mensagem para o cliente
        session.getBasicRemote().sendText("Eco: " + message);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Sessão " + session.getId() + " desconectada: " + closeReason.getReasonPhrase());
    }
}

}
