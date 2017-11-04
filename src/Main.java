import alghoritm.SimulatedAnnealing;
import dejong.DeJongOne;

public class Main {

    public static void main(String[] args) {
        DeJongOne deJongOne = new DeJongOne(-5.12, 5.12);
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(deJongOne.getUniverse());

        // Start the annealing
        final long startTime = System.currentTimeMillis();
        final double foundOptima = simulatedAnnealing.findOptima();
        final long stopTime = System.currentTimeMillis();
        System.out.println("Found solution: " + foundOptima);
        System.out.println("Elapsed time: " + (stopTime - startTime) + " milliseconds");
//        DeJongTwo deJongTwo = new DeJongTwo(-2.048, 2.048);
//        System.out.print(deJongTwo.getUniverse());
    }
}
