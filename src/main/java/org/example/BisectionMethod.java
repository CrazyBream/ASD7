package org.example;

import java.util.function.Function;

public class BisectionMethod implements RootFindingStrategy {
    @Override
    public double findRoot(Function<Double, Double> f, Function<Double, Double> df, double a, double b, double eps) {
        if (f.apply(a) * f.apply(b) >= 0) {
            throw new IllegalArgumentException("Функція повинна мати різні знаки на кінцях інтервалу.");
        }
        double c = a;
        while ((b - a) >= eps) {
            c = (a + b) / 2;
            if (f.apply(c) == 0.0) break;
            else if (f.apply(c) * f.apply(a) < 0) b = c;
            else a = c;
        }
        return c;
    }
}