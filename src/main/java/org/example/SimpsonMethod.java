package org.example;

import java.util.function.Function;

public class SimpsonMethod implements IntegrationStrategy {
    @Override
    public double integrate(Function<Double, Double> f, double a, double b, double h) {
        double sum = f.apply(a) + f.apply(b);
        int n = (int) Math.round((b - a) / h);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += f.apply(x) * (i % 2 == 0 ? 2 : 4);
        }
        return sum * h / 3.0;
    }
}