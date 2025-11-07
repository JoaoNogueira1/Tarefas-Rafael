package Tamagotchi;

public abstract class Animal {
    protected String tipo;
    protected int energia;
    protected int saude;
    protected int felicidade;
    protected int higiene;
    protected boolean vivo;

    public Animal(String tipo) {
        this.tipo = tipo;
        this.energia = 100;
        this.saude = 100;
        this.felicidade = 100;
        this.higiene = 100;
        this.vivo = true;
    }

    public void brincar() {
        if (!vivo) return;
        felicidade += 15;
        energia -= 10;
        higiene -= 5;
        validar();
        System.out.println(tipo + " brincou! +Felicidade, -Energia, -Higiene");
    }

    public void dormir() {
        if (!vivo) return;
        energia += 20;
        higiene -= 10;
        validar();
        System.out.println(tipo + " dormiu! +Energia, -Higiene");
    }

    public void comer() {
        if (!vivo) return;
        energia += 10;
        saude += 10;
        higiene -= 5;
        validar();
        System.out.println(tipo + " comeu! +Saúde, +Energia, -Higiene");
    }

    public void cuidarSaude() {
        if (!vivo) return;
        saude += 20;
        energia -= 10;
        validar();
        System.out.println(tipo + " foi ao veterinário! +Saúde, -Energia");
    }

    public void tomarBanho() {
        if (!vivo) return;
        higiene += 30;
        energia -= 5;
        felicidade -= 5;
        validar();
        System.out.println(tipo + " tomou banho! +Higiene, -Energia, -Felicidade");
    }

    protected void validar() {
        energia = Math.min(Math.max(energia, 0), 100);
        saude = Math.min(Math.max(saude, 0), 100);
        felicidade = Math.min(Math.max(felicidade, 0), 100);
        higiene = Math.min(Math.max(higiene, 0), 100);

        if (felicidade == 0) {
            saude -= 20;
            System.out.println("⚠ " + tipo + " está triste! -20 Saúde");
        }
        if (higiene == 0) {
            saude -= 15;
            System.out.println("⚠ " + tipo + " está sujo! -15 Saúde");
        }
        if (energia == 0) {
            saude -= 10;
            System.out.println("⚠ " + tipo + " está exausto! -10 Saúde");
        }

        if (saude <= 0) {
            morrer();
        }
    }

    public void mostrarStatus() {
        System.out.println("\n=== STATUS DO " + tipo.toUpperCase() + " ===");
        System.out.println("Energia: " + energia);
        System.out.println("Saúde: " + saude);
        System.out.println("Felicidade: " + felicidade);
        System.out.println("Higiene: " + higiene);
        System.out.println("Vivo: " + (vivo ? "Sim" : "Não"));
    }

    public void morrer() {
        vivo = false;
        saude = 0;
        energia = 0;
        felicidade = 0;
        higiene = 0;
        System.out.println("\n💀 Seu " + tipo + " morreu...");
    }

    public boolean estaVivo() {
        return vivo;
    }
}
