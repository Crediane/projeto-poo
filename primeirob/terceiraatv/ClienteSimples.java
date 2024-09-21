package primeirob.terceiraatv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSimples {

    private static final String SERVIDOR = "localhost";
    private static final int PORTA = 8089; 

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVIDOR, PORTA);
             PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado ao servidor. Digite suas mensagens...");

            new Thread(new RecebeMensagensDoServidor(entrada)).start();

            String mensagem;
            while ((mensagem = teclado.readLine()) != null) {
                saida.println(mensagem);
            }

        } catch (IOException e) {
            System.out.println("Erro ao conectar ao servidor: " + e.getMessage());
        }
    }
}

class RecebeMensagensDoServidor implements Runnable {
    private BufferedReader entrada;

    public RecebeMensagensDoServidor(BufferedReader entrada) {
        this.entrada = entrada;
    }

    @Override
    public void run() {
        try {
            String mensagem;
            while ((mensagem = entrada.readLine()) != null) {
                System.out.println("Mensagem recebida: " + mensagem);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler mensagens do servidor: " + e.getMessage());
        }
    }
}

