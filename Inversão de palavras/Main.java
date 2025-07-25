import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Entrada da string inicial
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre com a frase: ");
        String entrada = scanner.nextLine();

        // Converter string para vetor de caracteres
        char[] convert = entrada.toCharArray();
        int x = convert.length;

        // Array para armazenar a frase invertida
        char[] inverso = new char[x];

        // Índice para percorrer o vetor de saída
        int cn = 0;

        // Percorrer o array original de trás para frente
        for (int i = x - 1; i >= 0; i--) {
            // Encontrar o fim de uma palavra
            if (convert[i] == ' ' || i == 0) {
                // Se for a primeira palavra, ajusta a posição inicial
                int start = (i == 0) ? i : i + 1;
                int end = x;
                
                // Copiar a palavra para o vetor de saída
                for (int j = start; j < end && convert[j] != ' '; j++) {
                    inverso[cn++] = convert[j];
                }

                // Adicionar um espaço entre as palavras, se não for a última
                if (i > 0) {
                    inverso[cn++] = ' ';
                }
                // Atualiza o "x" para o início da palavra anterior
                x = i;
            }
        }
System.err.println("\n");
        // Exibir o resultado
        System.out.println("Frase invertida: ");
        System.out.println(inverso);
    }
}
