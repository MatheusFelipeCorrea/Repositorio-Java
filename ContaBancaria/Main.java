public class Main {
    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria(600);

        System.out.println("Saldo: R$" + conta.consultarSaldo());
        System.out.println("Cheque especial disponível: R$" + conta.consultarChequeEspecial());
        System.out.println("Está usando cheque especial? " + conta.estaUsandoChequeEspecial());

        System.out.println("\n--- Saque de R$800 ---");
        conta.sacar(800);
        
        System.out.println("Saldo: R$" + conta.consultarSaldo());
        System.out.println("Cheque especial disponível: R$" + conta.consultarChequeEspecial());
        System.out.println("Está usando cheque especial? " + conta.estaUsandoChequeEspecial());

        System.out.println("\n--- Depósito de R$100 (deverá abater cheque especial com taxa) ---");
        conta.depositar(100);

        System.out.println("Saldo: R$" + conta.consultarSaldo());
        System.out.println("Cheque especial disponível: R$" + conta.consultarChequeEspecial());
        System.out.println("Está usando cheque especial? " + conta.estaUsandoChequeEspecial());
    }
}
