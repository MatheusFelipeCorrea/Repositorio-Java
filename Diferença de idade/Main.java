import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);
        System.out.println("Digite a idade da primeira pessoa: ");
        var idade1 = input.nextInt();

        System.out.println("Digite a idade da segunda pessoa: ");
        var idade2 = input.nextInt();

        var diferença= idade1 - idade2;
        System.out.printf("A diferença de idade é: %d", diferença);
    }
}
