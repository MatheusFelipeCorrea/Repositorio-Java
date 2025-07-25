import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor do lado: ");
        var lado1 = input.nextInt();

        System.out.println("Digite o valor do segundo lado: ");
        var lado2 = input.nextInt();

        var area= lado1 * lado2;
        System.out.printf("O valor da área do retângulo é: %d", area);
    }
}
