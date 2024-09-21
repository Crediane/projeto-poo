package primeirob.terceiraatv;

import javax.websocket.*;
import java.net.URI;

@ClientEndpoint
public class WebSocketClient {

    private Session session;

    // Método chamado quando a conexão for aberta
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println("Conectado ao servidor");
    }

    // Método chamado quando uma mensagem for recebida do servidor
    @OnMessage
    public void onMessage(String message) {
        System.out.println("Mensagem recebida do servidor: " + message);
    }

    // Método chamado quando a conexão for fechada
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        System.out.println("Conexão fechada: " + reason.getReasonPhrase());
    }

    // Método para enviar mensagens para o servidor
    public void sendMessage(String message) {
        this.session.getAsyncRemote().sendText(message);
    }

    // Método principal para conectar ao servidor
    public static void main(String[] args) {
        try {
            // Definir o URI do servidor WebSocket
            URI uri = new URI("ws://localhost:8080/chat");
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            // Conectar ao servidor
            WebSocketClient client = new WebSocketClient();
            container.connectToServer(client, uri);
            
            // Enviar uma mensagem de exemplo para o servidor
            client.sendMessage("Olá, servidor!");
            
            // Manter o cliente rodando por um tempo
            Thread.sleep(10000);  // 10 segundos
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
