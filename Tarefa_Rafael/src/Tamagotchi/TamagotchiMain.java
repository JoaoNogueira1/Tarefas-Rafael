package Tamagotchi;

import java.util.Scanner;

public class TamagotchiMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Animal pet = null;

        System.out.println("=== TAMAGOTCHI ===");
        System.out.println("Escolha o tipo de animal:");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");
        System.out.println("3 - Papagaio");
        System.out.print("Opção: ");
        int opc = sc.nextInt();

        switch (opc) {
            case 1 -> pet = new Cachorro();
            case 2 -> pet = new Gato();
            case 3 -> pet = new Papagaio();
            default -> {
                System.out.println("Opção inválida. Encerrando...");
                System.exit(0);
            }
        }

        int escolha;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Brincar");
            System.out.println("2 - Dormir");
            System.out.println("3 - Comer");
            System.out.println("4 - Tomar banho");
            System.out.println("5 - Cuidar da saúde");
            System.out.println("6 - Mostrar status");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            escolha = sc.nextInt();

            if (!pet.estaVivo() && escolha != 0) {
                System.out.println("\nSeu bichinho morreu. Reinicie o jogo para criar outro.");
                break;
            }

            switch (escolha) {
                case 1 -> pet.brincar();
                case 2 -> pet.dormir();
                case 3 -> pet.comer();
                case 4 -> pet.tomarBanho();
                case 5 -> pet.cuidarSaude();
                case 6 -> pet.mostrarStatus();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (escolha != 0);

        sc.close();
    }
}
