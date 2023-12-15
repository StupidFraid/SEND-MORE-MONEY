import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<SendMoreMoney2> initialPopulation = new ArrayList<>();
        final int POPULATION_SIZE = 1000;
        final int GENERATIONS = 1000;
        final double THRESHOLD = 1.0;
        for (int i = 0; i < POPULATION_SIZE; i++) {
            initialPopulation.add(SendMoreMoney2.randomInstance());
        }
        GeneticAlgorithm<SendMoreMoney2> ga = new GeneticAlgorithm<>(
                initialPopulation,
                0.2, 0.7, GeneticAlgorithm.SelectionType.ROULETTE);
        SendMoreMoney2 result = ga.run(GENERATIONS, THRESHOLD);
        System.out.println(result);

        try {
            FileWriter writer = new FileWriter("fileForWrite.txt", true);

            writer.write(String.valueOf(result)+ "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }

    }
}

