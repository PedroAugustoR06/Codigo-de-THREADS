import java.util.ArrayList;
import java.util.List;

public class Corrida {

    private static final double DISTANCIA_TOTAL = 1000;
    private static final int NUMERO_DE_CARROS = 5;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= NUMERO_DE_CARROS; i++) {
            Carro carro = new Carro("Carro " + i, DISTANCIA_TOTAL);
            Thread thread = new Thread(carro);
            threads.add(thread);
        }

        System.out.println("=== A CORRIDA VAI COMEÇAR! ===");

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("=== CORRIDA ENCERRADA! ===");
    }
}
