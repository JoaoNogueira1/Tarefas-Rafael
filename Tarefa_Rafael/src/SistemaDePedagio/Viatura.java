package SistemaDePedagio;

public class Viatura extends Veiculo {
    private String tipo;

    public Viatura(String placa, String modelo, int velocidadeInicial, String tipo) throws VelocidadeExcedidaException {
        super(placa, modelo, velocidadeInicial);
        this.tipo = tipo;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tipo: " + tipo + " (ISENTO)");
    }
}