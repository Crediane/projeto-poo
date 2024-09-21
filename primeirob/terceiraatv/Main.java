package primeirob.terceiraatv;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final int PORTA = 8089;

    private static Set<PrintWriter> escritores = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORTA)) {
            System.out.println("Servidor rodando na porta" + PORTA + "...");
            while(true) {
                new Cliente(
                    server.accept(),
                    escritores
                ).start();
            }

            }catch (IOException IOException) {
                IOException.printStackTrace();
            }
        }
    }
