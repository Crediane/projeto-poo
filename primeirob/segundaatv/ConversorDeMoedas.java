package primeirob.segundaatv;

public class ConversorDeMoedas {

        private static final String[] moedas = {"USD", "EUR", "JPY", "GBP", "BRL"};
        private static final double[] taxas = {1.0, 0.85, 110.0, 0.75, 5.4};
    
        public static int findCurrencyIndex(String currency) {
            for (int i = 0; i < moedas.length; i++) {
                if (moedas[i].equalsIgnoreCase(currency)) {
                    return i;
                }
            }
            throw new IllegalArgumentException("Moeda inválida: " + currency);
        }
    
        public static double convert(double amount, String fromCurrency, String toCurrency) {
            int fromIndex = findCurrencyIndex(fromCurrency);
            int toIndex = findCurrencyIndex(toCurrency);
    
            double valorEmUSD = amount / taxas[fromIndex];
    
            return valorEmUSD * taxas[toIndex];
        }
    
        public static void main(String[] args) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
    
            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();
            System.out.print("Digite a moeda de origem (USD, EUR, JPY, GBP, BRL): ");
            String origem = scanner.next();
            System.out.print("Digite a moeda de destino (USD, EUR, JPY, GBP, BRL): ");
            String destino = scanner.next();
    
            try {
                double valorConvertido = convert(valor, origem, destino);
                System.out.printf("O valor de %.2f %s em %s é: %.2f%n", valor, origem, destino, valorConvertido);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }