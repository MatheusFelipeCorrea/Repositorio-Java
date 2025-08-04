package org.example;

import java.util.Scanner;

public class RecursividadeClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n============================================");
            System.out.println("\nSelecione a opcao desejada:\n");
            System.out.println("1. Fibonacci");
            System.out.println("2. Combinação");
            System.out.println("3. Arranjo Simples");
            System.out.println("4. Tamanho do vetor");
            System.out.println("5. Sair");
            System.out.print("\nEscolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu o método Fibonacci");
                    System.out.println("Escolha uma posição da sequencia: ");
                    int nfib = scanner.nextInt();

                    System.out.println("Resultado do metodo Fibonacci: " + Fibonacci(nfib));

                    break;
                case 2:
                    System.out.println("Você escolheu o método Combinação");
                    System.out.println("Declare o valor de N: ");
                    int ncomb = scanner.nextInt();
                    System.out.println("Declare o valor de P: ");

                    int pcomb = scanner.nextInt();


                    System.out.println("Resultado do metodo Combinação: " + combinacao(ncomb, pcomb));
                    break;

                case 3:
                    System.out.println("Você escolheu o método Arranjo Simples");

                    System.out.println("Declare o valor de N: ");
                    int num = scanner.nextInt();
                    System.out.println("Declare o valor de P: ");

                    int p = scanner.nextInt();

                    System.out.println("Chame o método recursivo e apresente o resultado:");
                    System.out.println("Resultado do metodo Arranjo Simples: " + ArranjoSimples(num, p));
                    break;


                case 4:
                    System.out.print("Digite o tamanho do vetor: ");
                    int n = scanner.nextInt();
                    int[] vet = new int[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        vet[i] = scanner.nextInt();
                    }
                    System.out.print("Digite o numero a ser encontrado: ");
                    int x = scanner.nextInt();
                    System.out.println("Numero " + x + " -> posicao: " + encontrar(vet, n, x));
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    public static int Fibonacci(int nfib) {
        if (nfib == 0 || nfib == 1) {
            return nfib;
        } else {
            return Fibonacci(nfib - 1) + Fibonacci(nfib - 2);
        }
    }





    public static long combinacao(int ncomb, int pcomb) {

        if (pcomb == 0 || pcomb == ncomb) {
            return 1;
        } else {
            return combinacao(ncomb - 1, pcomb - 1) + combinacao(ncomb - 1, pcomb);
        }
    }



    public static long fatorial(int num) {

            if (num == 0 || num == 1)
                return 1;
            return num * fatorial(num - 1);
    }

    public static long ArranjoSimples(int n, int p) {
        if (p > n || n < 0 || p < 0) return 0;
        return fatorial(n) / fatorial(n - p);
    }

    public static int encontrar(int[] A, int n, int x){
        int pos = -1;
        if(n>0){
            if(A[n-1] == x){
                pos = n-1;
            } else {
                pos = encontrar(A, n-1, x);
            }
        }
        return pos;
    }

}
