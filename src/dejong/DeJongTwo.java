package dejong;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of De Jong's testing function number 2
 * AKA Rosenbrock's valley
 */
public class DeJongTwo {

  private final double startingPoint;
  private final double endingPoint;
  private final static double interval = 0.001;

  public DeJongTwo(final double startingPoint, final double endingPoint) {
    this.startingPoint = startingPoint;
    this.endingPoint = endingPoint;
  }

  public List<Double> getUniverse() {
    final List<Double> universe = new ArrayList<>();
    double counter = startingPoint + interval;
    while (counter < endingPoint) {
      final double nextCounter = counter + interval;
      final double value = (100 * Math.pow((nextCounter - Math.pow(counter, 2)), 2)) + Math.pow((1 - counter), 2);
      universe.add(value);
      counter += interval;
    }

    return universe;
  }
}
