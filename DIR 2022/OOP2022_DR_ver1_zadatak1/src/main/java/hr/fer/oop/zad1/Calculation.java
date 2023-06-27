package hr.fer.oop.zad1;

public interface Calculation {

    String makeDescription();

    static double calculateAverage(double[] data) {
        double sum = 0;
        for (double d : data) {
            sum += d;
        }
        return sum / data.length;
    }
}