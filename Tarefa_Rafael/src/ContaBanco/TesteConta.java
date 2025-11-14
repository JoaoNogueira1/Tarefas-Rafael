package ContaBanco;

public class TesteConta {
    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria(200, 300);

        try {
            System.out.println("Saldo inicial: " + conta.getSaldo());
            System.out.println("Saldo + Limite: " + conta.getSaldoComLimite());

            conta.depositar(500);
            System.out.println("Após depósito de 500: " + conta.getSaldo());

            conta.sacar(400);
            System.out.println("Após saque de 400: " + conta.getSaldo());

            conta.sacar(600); 

        } catch (ContaException e) {
            System.out.println("EXCEÇÃO CAPTURADA: " + e.getMessage());
        }

        try {
            conta.depositar(1500); 
        } catch (ContaException e) {
            System.out.println("EXCEÇÃO CAPTURADA: " + e.getMessage());
        }
    }
}