import alghoritm.SimulatedAnnealing;
import dejong.DeJongOne;

public class Main {

    public static void main(String[] args) {
        DeJongOne deJongOne = new DeJongOne(-5.12, 5.12);
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(deJongOne.getUniverse());
        System.out.print(simulatedAnnealing.findOptima());
    }
}
