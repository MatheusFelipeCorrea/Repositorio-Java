import java.util.*;

public class SudokuGame {

    private static final int SIZE = 9;
    private final int[][] board = new int[SIZE][SIZE];
    private final boolean[][] fixed = new boolean[SIZE][SIZE];
    private final Scanner scanner = new Scanner(System.in);
    private boolean iniciado = false;

    // Inicializa o jogo com números fixos passados como args
    public void iniciarJogo(String[] args) {
        // Limpa tabuleiro e fixed
        for (int i = 0; i < SIZE; i++)
            Arrays.fill(board[i], 0);
        for (int i = 0; i < SIZE; i++)
            Arrays.fill(fixed[i], false);

        for (String arg : args) {
            // Formato esperado: linha,coluna,valor
            String[] parts = arg.split(",");
            if (parts.length != 3) continue;
            try {
                int linha = Integer.parseInt(parts[0]);
                int coluna = Integer.parseInt(parts[1]);
                int valor = Integer.parseInt(parts[2]);
                if (linha >= 0 && linha < SIZE && coluna >= 0 && coluna < SIZE && valor >= 1 && valor <= 9) {
                    board[linha][coluna] = valor;
                    fixed[linha][coluna] = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Argumento inválido ignorado: " + arg);
            }
        }
        iniciado = true;
        System.out.println("Jogo iniciado com tabuleiro:");
        imprimirTabuleiro();
    }

    // Imprime o tabuleiro atual
    private void imprimirTabuleiro() {
        System.out.println("    0 1 2   3 4 5   6 7 8");
        System.out.println("  +-------+-------+-------+");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
                if ((j + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
            if ((i + 1) % 3 == 0)
                System.out.println("  +-------+-------+-------+");
        }
    }

    // Verifica se o movimento é válido (linha, coluna, valor)
    private boolean movimentoValido(int linha, int coluna, int valor) {
        // Verifica linha
        for (int j = 0; j < SIZE; j++) {
            if (board[linha][j] == valor && j != coluna) return false;
        }
        // Verifica coluna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][coluna] == valor && i != linha) return false;
        }
        // Verifica bloco 3x3
        int boxRowStart = (linha / 3) * 3;
        int boxColStart = (coluna / 3) * 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board[i][j] == valor && (i != linha || j != coluna)) return false;
            }
        }
        return true;
    }

    // Opção 2: Colocar número
    private void colocarNumero() {
        if (!iniciado) {
            System.out.println("O jogo ainda não foi iniciado. Escolha a opção 1 primeiro.");
            return;
        }
        System.out.print("Informe o número (1-9): ");
        int valor = lerIntEntre(1, 9);
        System.out.print("Informe o índice horizontal (linha 0-8): ");
        int linha = lerIntEntre(0, 8);
        System.out.print("Informe o índice vertical (coluna 0-8): ");
        int coluna = lerIntEntre(0, 8);

        if (fixed[linha][coluna]) {
            System.out.println("Não é possível modificar um número fixo.");
            return;
        }
        if (board[linha][coluna] != 0) {
            System.out.println("Posição já preenchida. Remova antes de colocar um novo número.");
            return;
        }
        if (!movimentoValido(linha, coluna, valor)) {
            System.out.println("Movimento inválido: conflito com outros números.");
            return;
        }
        board[linha][coluna] = valor;
        System.out.println("Número colocado com sucesso.");
        imprimirTabuleiro();
    }

    // Opção 3: Remover número
    private void removerNumero() {
        if (!iniciado) {
            System.out.println("O jogo ainda não foi iniciado. Escolha a opção 1 primeiro.");
            return;
        }
        System.out.print("Informe o índice horizontal (linha 0-8) do número a remover: ");
        int linha = lerIntEntre(0, 8);
        System.out.print("Informe o índice vertical (coluna 0-8) do número a remover: ");
        int coluna = lerIntEntre(0, 8);

        if (fixed[linha][coluna]) {
            System.out.println("Número fixo não pode ser removido.");
            return;
        }
        if (board[linha][coluna] == 0) {
            System.out.println("Não há número nessa posição.");
            return;
        }
        board[linha][coluna] = 0;
        System.out.println("Número removido com sucesso.");
        imprimirTabuleiro();
    }

    // Opção 4: Verificar jogo (mostrar tabuleiro)
    private void verificarJogo() {
        if (!iniciado) {
            System.out.println("O jogo ainda não foi iniciado.");
            return;
        }
        imprimirTabuleiro();
    }

    // Verifica se o jogo está completo e válido
    private boolean completoESemErros() {
        // Verifica se todas posições estão preenchidas
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int val = board[i][j];
                if (val == 0 || !movimentoValido(i, j, val)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Verifica se o jogo contém erros
    private boolean contemErros() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int val = board[i][j];
                if (val != 0 && !movimentoValido(i, j, val)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Opção 5: Verificar status do jogo
    private void verificarStatus() {
        if (!iniciado) {
            System.out.println("Status: NÃO INICIADO (sem erros)");
            return;
        }
        boolean completo = completoESemErros();
        boolean erros = contemErros();
        boolean incompleto = !completo && !erros;

        System.out.print("Status do jogo: ");
        if (completo) {
            System.out.print("COMPLETO, sem erros");
        } else if (erros) {
            System.out.print("INCOMPLETO, com erros");
        } else {
            System.out.print("INCOMPLETO, sem erros");
        }
        System.out.println();
    }

    // Opção 6: Limpar números do usuário
    private void limpar() {
        if (!iniciado) {
            System.out.println("O jogo ainda não foi iniciado.");
            return;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!fixed[i][j]) {
                    board[i][j] = 0;
                }
            }
        }
        System.out.println("Números do usuário removidos. Números fixos mantidos.");
        imprimirTabuleiro();
    }

    // Opção 7: Finalizar jogo
    private void finalizarJogo() {
        if (!iniciado) {
            System.out.println("O jogo ainda não foi iniciado.");
            return;
        }
        if (completoESemErros()) {
            System.out.println("Parabéns! Você completou o Sudoku corretamente. Jogo encerrado.");
            iniciado = false;
        } else {
            System.out.println("O jogo ainda não está completo ou contém erros. Continue jogando.");
        }
    }

    // Ler inteiro com validação de intervalo
    private int lerIntEntre(int min, int max) {
        while (true) {
            try {
                int val = Integer.parseInt(scanner.nextLine());
                if (val >= min && val <= max) return val;
                System.out.printf("Informe um número entre %d e %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.printf("Entrada inválida. Informe um número entre %d e %d: ", min, max);
            }
        }
    }

    // Menu principal
    public void menu(String[] args) {
        while (true) {
            System.out.println("\nMenu Sudoku");
            System.out.println("1. Iniciar um novo jogo");
            System.out.println("2. Colocar um novo número");
            System.out.println("3. Remover um número");
            System.out.println("4. Verificar jogo");
            System.out.println("5. Verificar status do jogo");
            System.out.println("6. Limpar");
            System.out.println("7. Finalizar o jogo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = lerIntEntre(0, 7);

            switch (opcao) {
                case 1 -> iniciarJogo(args);
                case 2 -> colocarNumero();
                case 3 -> removerNumero();
                case 4 -> verificarJogo();
                case 5 -> verificarStatus();
                case 6 -> limpar();
                case 7 -> finalizarJogo();
                case 0 -> {
                    System.out.println("Saindo do jogo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public static void main(String[] args) {
        SudokuGame jogo = new SudokuGame();
        jogo.menu(args);
    }
}
