package ContaBanco;

public class ContaBancaria {

    private double saldo;   
    private double limite;  

    public ContaBancaria(double valorSaldo, double valorLimite) {
        this.saldo = valorSaldo;
        this.limite = valorLimite;
    }

    public double getSaldo() {
        return this.saldo;
    }

    protected double getLimite() {
        return this.limite;
    }

    public double getSaldoComLimite() {
        return this.saldo + this.limite;
    }

    public boolean sacar(double valor) throws ContaException {

        if (valor > 500) {
            throw new ContaException("Erro: Saques acima de R$500,00 não são permitidos.");
        }

        if ((this.saldo - valor) + this.limite < 0) {
            throw new ContaException("Erro: Saldo insuficiente considerando o limite.");
        }

        this.saldo -= valor;
        return true;
    }

    public void depositar(double valor) throws ContaException {

        if (valor > 1000) {
            throw new ContaException("Erro: Depósitos acima de R$1000,00 não são permitidos.");
        }

        this.saldo += valor;
    }
}