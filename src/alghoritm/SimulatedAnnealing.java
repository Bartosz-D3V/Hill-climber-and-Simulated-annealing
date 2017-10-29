package alghoritm;

import controller.ChartController;
import domain.Line;
import domain.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SimulatedAnnealing {

    private final static double coolingRate = 0.004;
    private double temperature = 20000;
    private final ChartController chartController;

    final Set<Integer> forbiddenIndexes = new HashSet<>();

    public SimulatedAnnealing(ChartController chartController) {
        this.chartController = chartController;
    }

    public Line findOptima() {
        double currentEnergy;
        double neighbourEnergy;
        Line currentSolution = new Line(this.getRandomPoint(), this.getRandomPoint());
        Line bestSolution = new Line(currentSolution.getStartPoint(), currentSolution.getEndPoint());

        while (this.temperature > 1) {
            Line newSolution = new Line(currentSolution.getStartPoint(), currentSolution.getEndPoint());
            Point currentPoint = this.getRandomPoint();
            currentEnergy = currentSolution.getDistance();
            neighbourEnergy = newSolution.getDistance();

            if (acceptanceProbability(currentEnergy, neighbourEnergy, temperature) > Math.random()) {
                currentSolution = new Line(newSolution.getStartPoint(), newSolution.getEndPoint());
            }

            // Keep track of the best solution found
            if (currentSolution.getDistance() < bestSolution.getDistance()) {
                bestSolution = new Line(currentSolution.getStartPoint(), currentSolution.getEndPoint());
            }

            temperature *= 1 - coolingRate;
        }

        return bestSolution;
    }

    private double acceptanceProbability(final double energy, final double newEnergy, final double temperature) {
        if (newEnergy < energy) {
            return 1;
        }
        return Math.exp((energy - newEnergy) / temperature);
    }

    private Point getRandomPoint() {
        final Random random = new Random();
        final List<Point> listOfPoints = this.chartController.getPoints();
        int randomIndex = random.nextInt(listOfPoints.size());
        if (forbiddenIndexes.contains(randomIndex)) {
            randomIndex = random.nextInt(listOfPoints.size());
        }
        this.forbiddenIndexes.add(randomIndex);

        return listOfPoints.get(randomIndex);

    }
}