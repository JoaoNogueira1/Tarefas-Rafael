package SistemaDePedagio;
import java.util.ArrayList;
import java.util.List;

public class PedagioMain {
    public static void main(String[] args) {
        List<Veiculo> filaDeVeiculos = new ArrayList<>();
        double totalArrecadado = 0.0;
        double totalIsento = 0.0;

        try {
            filaDeVeiculos.add(new Carro("ABC1234", "Polo", 80));
            filaDeVeiculos.add(new Caminhao("DEF5678", "Volvo FH", 95, 4));
            filaDeVeiculos.add(new Viatura("GHI9012", "Fiat Doblò", 50, "Ambulância"));
            filaDeVeiculos.add(new Carro("JKL3456", "Onix", 101));
        } catch (VelocidadeExcedidaException e) {
            System.err.println("ALERTA DE RADAR: " + e.getMessage());
        }

        System.out.println("--- Início da Cobrança do Pedágio ---");
        System.out.println("");

        for (Veiculo veiculo : filaDeVeiculos) {
            System.out.println("\nProcessando veículo:");
            veiculo.exibirInformacoes();

            if (veiculo instanceof Pagavel) {
                Pagavel pagador = (Pagavel) veiculo;
                double tarifa = pagador.calcularTarifa();
                totalArrecadado += tarifa;
                System.out.printf("Cobrança Realizada: R$ %.2f\n", tarifa);
            } else {
                totalIsento += 0.0;
                System.out.println("Isento de Pedágio (Viatura Oficial).");
            }
        }

        System.out.println("\n--- Resumo do Pedágio ---");
        System.out.printf("Total Arrecadado (Pagantes): R$ %.2f\n", totalArrecadado);
        System.out.printf("Total de Isenções (Viaturas): R$ %.2f\n", totalIsento);
    }
}