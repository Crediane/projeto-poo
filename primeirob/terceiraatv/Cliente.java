package primeirob.terceiraatv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;

public class Cliente extends Thread {
    private Socket socket;
    private Set<PrintWriter> escritores;
    private PrintWriter saida;

    public Cliente(Socket socket, Set<PrintWriter> escritores) {
        this.socket = socket;
        this.escritores = escritores;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            saida = new PrintWriter(socket.getOutputStream(), true);

            synchronized (escritores) {
                escritores.add(saida);
            }

            String mensagem;
            while ((mensagem = entrada.readLine()) != null) {
                System.out.println("Mensagem recebida: " + mensagem);
                synchronized (escritores) {
                    for (PrintWriter escritor : escritores) {
                        escritor.println(mensagem);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro de comunicação com o cliente: " + e.getMessage());
        } finally {
            if (saida != null) {
                synchronized (escritores) {
                    escritores.remove(saida);
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar o socket: " + e.getMessage());
            }
        }
    }
}

