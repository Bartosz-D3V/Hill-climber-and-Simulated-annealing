package alghoritm;

import java.util.List;
import java.util.Random;

public class HillClimbing {

  private final List<Double> universe;

  public HillClimbing(final List<Double> universe) {
    this.universe = universe;
  }

  public double findOptima() {
    // Select a random value as a starting point aka 'best solution'
    double bestSolution = this.universe.get(this.getRandomIndex());
    boolean shouldContinue;
    do {
      // Select a random neighbour
      double newSolution = this.universe.get(this.getRandomIndex());
      // If a new solution's value is greater than current, best solution
      if (bestSolution < newSolution) {
        // Change the best solution
        bestSolution = newSolution;
        // And continue searching
        shouldContinue = true;
      } else {
        // Otherwise stop
        shouldContinue = false;
      }
    } while (shouldContinue);

    return bestSolution;
  }

  private int getRandomIndex() {
    final Random random = new Random();

    return random.nextInt(this.universe.size());
  }
}
