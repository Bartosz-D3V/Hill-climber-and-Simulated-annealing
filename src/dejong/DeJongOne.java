package dejong;

import java.util.ArrayList;
import java.util.List;

public class DeJongOne {

    private final double startingPoint;
    private final double endingPoint;
    private final double interval = 0.01;

    public DeJongOne(final double startingPoint, final double endingPoint) {
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    public List<Double> getUniverse() {
        List<Double> universe = new ArrayList<>();
        double counter = this.startingPoint + interval;
        while (counter < endingPoint) {
            counter += this.interval;
            universe.add(Math.pow(counter, 2));
        }

        return universe;
    }
}
