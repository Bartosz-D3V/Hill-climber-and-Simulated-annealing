package alghoritm;

import controller.ChartController;
import domain.Line;
import domain.Point;

import java.util.List;
import java.util.Random;

public class SimulatedAnnealing {

    private final static double coolingRate = 0.004;
    private double temperature = 2000000;
    private final ChartController chartController;

    public SimulatedAnnealing(final ChartController chartController) {
        this.chartController = chartController;
    }

    public Line findOptima() {
        double currentEnergy;
        double neighbourEnergy;
        Line currentSolution = new Line(this.getRandomPoint(), this.getRandomPoint());
        Line bestSolution = new Line(currentSolution.getStartPoint(), currentSolution.getEndPoint());

        while (this.temperature > 1) {
            Line newSolution = new Line(currentSolution.getStartPoint(), currentSolution.getEndPoint());
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

    /**
     * Method that pick a random Point from the list
     * making sure that it is unique - i.e. it will not
     * pick the same point twice so the distance would be 0
     * in that case
     *
     * @return Point
     */
    private Point getRandomPoint() {
        final Random random = new Random();
        final List<Point> listOfPoints = this.chartController.getPoints();
        int randomIndex = random.nextInt(listOfPoints.size());

        final Point randomPoint = listOfPoints.get(randomIndex);
        listOfPoints.remove(randomPoint);

        return randomPoint;
    }
}
