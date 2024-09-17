package primeirob.primeiraatv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Planilha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número de colunas: ");
        int numColunas = scanner.nextInt();
        scanner.nextLine(); 

        String[] colunas = new String[numColunas];
        for (int i = 0; i < numColunas; i++) {
            System.out.print("Informe o nome da coluna " + (i + 1) + ": ");
            colunas[i] = scanner.nextLine();
        }

        System.out.print("Informe o número de linhas de dados: ");
        int numLinhas = scanner.nextInt();
        scanner.nextLine();

        String[][] dados = new String[numLinhas][numColunas];
        for (int i = 0; i < numLinhas; i++) {
            System.out.println("Linha " + (i + 1) + ":");
            for (int j = 0; j < numColunas; j++) {
                System.out.print("Digite o valor para " + colunas[j] + ": ");
                dados[i][j] = scanner.nextLine();
            }
        }

        try (FileWriter writer = new FileWriter("dados.csv")) {
            
            for (int i = 0; i < numColunas; i++) {
                writer.write(colunas[i]);
                if (i < numColunas - 1) {
                    writer.write(","); 
                }
            }
            writer.write("\n");

            for (int i = 0; i < numLinhas; i++) {
                for (int j = 0; j < numColunas; j++) {
                    writer.write(dados[i][j]);
                    if (j < numColunas - 1) {
                        writer.write(","); 
                    }
                }
                writer.write("\n");
            }

            System.out.println("Arquivo CSV criado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

