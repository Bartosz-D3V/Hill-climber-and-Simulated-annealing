package alghoritm;

import java.util.List;
import java.util.Random;

public class SimulatedAnnealing {

  private final static double coolingRate = 0.004;
  private static double temperature = 100000;
  private final List<Double> universe;

  public SimulatedAnnealing(final List<Double> universe) {
    this.universe = universe;
  }

  public double findOptima() {
    // Best found solution is initially, randomly picked
    double bestSolution = this.universe.get(this.getRandomIndex());
    // ... and mark it as a current solution
    double currentSolution = bestSolution;
    // Energy of the current solution is its' value
    double currentEnergy = currentSolution;
    // Start annealing
    while (temperature > coolingRate) {
      // Get random position in our universe
      int newSolutionPosition = this.getRandomIndex();
      // Retrieve new solution's value
      final double newSolutionEnergy = this.universe.get(newSolutionPosition);

      // Check whether new solution should be accepted
      if (this.acceptanceProbability(currentEnergy, newSolutionEnergy, temperature) > Math.random()) {
        // Move on to the new solution
        currentSolution = this.universe.get(newSolutionPosition);
      }

      // Compare to the global optima
      if (newSolutionEnergy < bestSolution) {
        // Mark as global optima (best found) if current global optima is greater
        bestSolution = currentSolution;
      }

      // Cool down
      temperature *= 1 - coolingRate;
    }

    return currentSolution;
  }

  private double acceptanceProbability(final double energy, final double newEnergy, final double temperature) {
    if (newEnergy < energy) {
      return 1;
    }

    return Math.exp((energy - newEnergy) / temperature);
  }

  private int getRandomIndex() {
    final Random random = new Random();

    return random.nextInt(this.universe.size());
  }
}
