package org.example;

import java.util.function.Function;

public class TrapezoidalMethod implements IntegrationStrategy {
    @Override
    public double integrate(Function<Double, Double> f, double a, double b, double h) {
        double sum = (f.apply(a) + f.apply(b)) / 2.0;
        for (double x = a + h; x < b; x += h) {
            sum += f.apply(x);
        }
        return sum * h;
    }
}
