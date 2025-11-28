package SistemaDePedagio;

public class Carro extends Veiculo implements Pagavel {
    private static final double TARIFA_FIXA = 7.00;

    public Carro(String placa, String modelo, int velocidadeInicial) throws VelocidadeExcedidaException {
        super(placa, modelo, velocidadeInicial);
    }

    @Override
    public double calcularTarifa() {
        return TARIFA_FIXA;
    }
}