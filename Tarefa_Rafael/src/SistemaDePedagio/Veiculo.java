package SistemaDePedagio;

public abstract class Veiculo {
	protected String placa;
	protected String modelo;
	protected int velocidadeAtual;
	private static final int LIMITE_VELOCIDADE = 100;

    public Veiculo(String placa, String modelo, int velocidadeInicial) throws VelocidadeExcedidaException {
        this.placa = placa;
        this.modelo = modelo;
        if (velocidadeInicial > LIMITE_VELOCIDADE) {
            throw new VelocidadeExcedidaException("Veículo " + placa + " excedeu o limite de " + LIMITE_VELOCIDADE + " km/h!");
        }
        this.velocidadeAtual = velocidadeInicial;
    }

    public void exibirInformacoes() {
        System.out.println("Placa: " + placa + ", Modelo: " + modelo + ", Velocidade: " + velocidadeAtual + " km/h");
    }

    public String getPlaca() {
        return placa;
    }
}