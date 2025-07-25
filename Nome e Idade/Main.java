import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var anobase = 2025;

        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu nome: ");

        var nome = input.nextLine();

        System.out.println("Digite seu ano de nascimento: ");
        var ano = input.nextInt();

        var idade = anobase - ano;
        System.out.printf("Olá %s você tem %d anos\n ", nome, idade);
    }
}
