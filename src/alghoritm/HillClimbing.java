package alghoritm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HillClimbing {

  private final List<Double> universe;
  private final List<Double> notVisitedNeighbours;

  public HillClimbing(final List<Double> universe) {
    this.universe = universe;
    this.notVisitedNeighbours = new ArrayList<>();
    this.notVisitedNeighbours.addAll(universe);
  }

  public double findOptima() {
    double bestSolution = this.universe.get(this.getRandomIndex());
    boolean shouldContinue;
    do {
      double newSolution = this.universe.get(this.getRandomIndex());

      // Iterate through neighbours of initialSolution
      for (Double element : this.notVisitedNeighbours) {
        if (element < bestSolution) {
          newSolution = element;
        }
      }
      if (bestSolution > newSolution) {
        bestSolution = newSolution;
        shouldContinue = true;
      } else {
        shouldContinue = false;
      }
    } while (shouldContinue);

    return bestSolution;
  }

  private int getRandomIndex() {
    final Random random = new Random();
    final int randomIndex = random.nextInt(this.notVisitedNeighbours.size());
    this.notVisitedNeighbours.remove(randomIndex);

    return randomIndex;
  }
}
