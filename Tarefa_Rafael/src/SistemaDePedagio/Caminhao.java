package SistemaDePedagio;

public class Caminhao extends Veiculo implements Pagavel {
    private int numeroEixos;
    private static final double TARIFA_POR_EIXO = 7.00;

    public Caminhao(String placa, String modelo, int velocidadeInicial, int numeroEixos) throws VelocidadeExcedidaException {
        super(placa, modelo, velocidadeInicial);
        this.numeroEixos = numeroEixos;
    }

    @Override
    public double calcularTarifa() {
        return numeroEixos * TARIFA_POR_EIXO;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Eixos: " + numeroEixos);
    }
}