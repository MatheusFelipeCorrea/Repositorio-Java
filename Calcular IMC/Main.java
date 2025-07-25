import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a sua altura: ");
        var altura = input.nextFloat();

        System.out.println("Digite o seu peso: ");
        var peso = input.nextFloat();

        var calcularIMC= peso/ (altura*altura);

        if (calcularIMC<=18.5) {
            System.out.printf("Seu IMC deu: %f, logo você está abaixo do peso." , calcularIMC);
        } else if (calcularIMC>=18.6 && calcularIMC<=24.9) {
            System.out.printf("Seu IMC deu: %f, logo você está com o peso ideal." , calcularIMC);
        } else if (calcularIMC>=25 && calcularIMC<=29.9) {
            System.out.printf("Seu IMC deu: %f, logo você está levemente acima do peso." , calcularIMC);
        } else if (calcularIMC>=30 && calcularIMC<=34.9) {
            System.out.printf("Seu IMC deu: %f, logo você está com Obesidade Grau I" , calcularIMC);
        } else if (calcularIMC>=35 && calcularIMC<=39.9) {
            System.out.printf("Seu IMC deu: %f, logo você está com Obesidade Grau II (Severa)" , calcularIMC);
        }else if (calcularIMC >= 40) {
            System.out.printf("Seu IMC deu: %f, logo você está com Obesidade Grau III (Mórbida)" , calcularIMC);
        }
    }
}
