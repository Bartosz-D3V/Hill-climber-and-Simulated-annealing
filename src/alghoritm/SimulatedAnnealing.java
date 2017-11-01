package alghoritm;

import java.util.List;
import java.util.Random;

public class SimulatedAnnealing {

    private final static double coolingRate = 0.003;
    private static double temperature = 200000;
    private final List<Double> universe;

    public SimulatedAnnealing(final List<Double> universe) {
        this.universe = universe;
    }

    public double findOptima() {
        double currentSolution = this.universe.get(this.getRandomIndex());
        while (temperature > coolingRate) {
            // Create new solution that initially bases on the current one
            double newSolution = currentSolution;
            // Get random position in our universe
            int newSolutionPosition = this.getRandomIndex();

            temperature *= 1 - coolingRate;
        }

        return currentSolution;
    }

    private double acceptanceProbability(final double energy, final double newEnergy, final double temperature) {
        if (newEnergy < energy) {
            return 1.0;
        }

        return Math.exp((energy - newEnergy) / temperature);
    }

    private int getRandomIndex() {
        final Random random = new Random();

        return random.nextInt(this.universe.size());
    }
}
