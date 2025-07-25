public class ContaBancaria {
    private double saldo;
    private double chequeEspecial;
    private double chequeEspecialUsado;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;

        if (depositoInicial <= 500) {
            this.chequeEspecial = 50.0;
        } else {
            this.chequeEspecial = depositoInicial * 0.5;
        }

        this.chequeEspecialUsado = 0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public double consultarChequeEspecial() {
        return chequeEspecial - chequeEspecialUsado;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }

        // Primeiro, tenta cobrir o valor do cheque especial usado
        if (chequeEspecialUsado > 0) {
            double taxa = chequeEspecialUsado * 0.20;
            double totalDevido = chequeEspecialUsado + taxa;

            if (valor >= totalDevido) {
                valor -= totalDevido;
                System.out.println("Cheque especial quitado com taxa de R$" + String.format("%.2f", taxa));
                chequeEspecialUsado = 0;
            } else {
                double valorPago = valor / 1.20; // reverso do cálculo
                chequeEspecialUsado -= valorPago;
                System.out.println("Parte do cheque especial foi quitado. Valor restante: R$" + String.format("%.2f", chequeEspecialUsado));
                return;
            }
        }

        saldo += valor;
        System.out.println("Depósito realizado. Novo saldo: R$" + String.format("%.2f", saldo));
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }

        if (valor <= saldo) {
            saldo -= valor;
        } else {
            double restante = valor - saldo;

            if (restante <= consultarChequeEspecial()) {
                saldo = 0;
                chequeEspecialUsado += restante;
            } else {
                System.out.println("Saque negado. Saldo insuficiente, mesmo com cheque especial.");
                return;
            }
        }

        System.out.println("Saque realizado. Novo saldo: R$" + String.format("%.2f", saldo));
    }

    public void pagarBoleto(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de boleto inválido.");
            return;
        }

        sacar(valor);
    }

    public boolean estaUsandoChequeEspecial() {
        return chequeEspecialUsado > 0;
    }
}
