package org.example;

import java.util.function.Function;

public class RectangleMethod implements IntegrationStrategy {
    @Override
    public double integrate(Function<Double, Double> f, double a, double b, double h) {
        double sum = 0;
        for (double x = a; x < b; x += h) {
            sum += f.apply(x + h / 2.0);
        }
        return sum * h;
    }
}
