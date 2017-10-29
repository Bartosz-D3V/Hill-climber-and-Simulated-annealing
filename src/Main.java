import alghoritm.SimulatedAnnealing;
import controller.ChartController;
import domain.Point;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final List<Point> matrix = new ArrayList<>();
        final SimulatedAnnealing simulatedAnnealing;
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 4);
        Point point3 = new Point(9, 98);
        Point point4 = new Point(0, 1.1);
        matrix.add(point1);
        matrix.add(point2);
        matrix.add(point3);
        matrix.add(point4);

        ChartController chartController = new ChartController(matrix);
        simulatedAnnealing = new SimulatedAnnealing(chartController);
        System.out.print(simulatedAnnealing.findOptima());
    }
}
