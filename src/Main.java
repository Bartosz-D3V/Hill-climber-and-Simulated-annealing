import alghoritm.HillClimbing;
import alghoritm.SimulatedAnnealing;
import dejong.DeJongOne;
import dejong.DeJongTwo;

public class Main {

  public static void main(String[] args) {
    DeJongOne deJongOne = new DeJongOne(-5.12, 5.12);
    SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(deJongOne.getUniverse());
    HillClimbing hillClimbing = new HillClimbing(deJongOne.getUniverse());

    Main.runAlghoritms(simulatedAnnealing, hillClimbing);

    DeJongTwo deJongTwo = new DeJongTwo(-2.048, 2.048);
    simulatedAnnealing = new SimulatedAnnealing(deJongTwo.getUniverse());
    hillClimbing = new HillClimbing(deJongTwo.getUniverse());

    Main.runAlghoritms(simulatedAnnealing, hillClimbing);
  }

  private static void runAlghoritms(final SimulatedAnnealing simulatedAnnealing, final HillClimbing hillClimbing) {
    long startTime = System.currentTimeMillis();
    final double foundOptimaSA = simulatedAnnealing.findOptima();
    long stopTime = System.currentTimeMillis();
    System.out.println("Simulated Annealing found solution: " + foundOptimaSA);
    System.out.println("Elapsed time: " + (stopTime - startTime) + " milliseconds");

    startTime = System.currentTimeMillis();
    final double foundOptimaHC = hillClimbing.findOptima();
    stopTime = System.currentTimeMillis();
    System.out.println("Hill Climbing found solution: " + foundOptimaHC);
    System.out.println("Elapsed time: " + (stopTime - startTime) + " milliseconds");
  }
}
