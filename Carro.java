import java.util.Random;


public class Carro implements Runnable {


    private final String nome;
    private final double distanciaTotalCorrida;
    private double distanciaPercorrida;
    private final Random random = new Random();

    public Carro(String nome, double distanciaTotalCorrida) {
        this.nome = nome;
        this.distanciaTotalCorrida = distanciaTotalCorrida;
        this.distanciaPercorrida = 0; // todo carro começa na largada
    }

    public String getNome() {
        return nome;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    @Override
    public void run() {
        while (distanciaPercorrida < distanciaTotalCorrida) {


            int avanco = random.nextInt(41) + 10;
            distanciaPercorrida += avanco;


            if (distanciaPercorrida > distanciaTotalCorrida) {
                distanciaPercorrida = distanciaTotalCorrida;
            }

            System.out.println(nome + " andou " + avanco
                    + " metros e já percorreu " + (int) distanciaPercorrida
                    + " de " + (int) distanciaTotalCorrida + " metros.");
            try {
                Thread.sleep(random.nextInt(401) + 100);
            } catch (InterruptedException e) {
                System.out.println(nome + " foi interrompido!");
                return;
            }
        }

        System.out.println("[CHEGADA] O " + nome + " cruzou a linha de chegada!");
    }
}
