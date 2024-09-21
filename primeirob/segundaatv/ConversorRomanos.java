package primeirob.segundaatv;

public class ConversorRomanos { 

        private static final int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        private static final String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
        public static String toRoman(int numero) {
            if (numero < 1 || numero > 3999) {
                throw new IllegalArgumentException("Número fora do intervalo permitido (1-3999)");
            }
    
            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < valores.length; i++) {
                while (numero >= valores[i]) {
                    numero -= valores[i];
                    resultado.append(simbolos[i]);
                }
            }
            return resultado.toString();
        }
    
        public static void main(String[] args) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Digite um número para converter para números romanos (1-3999): ");
            int numero = scanner.nextInt();
            String romano = toRoman(numero);
            System.out.println("O número " + numero + " em números romanos é: " + romano);
        }
    }
