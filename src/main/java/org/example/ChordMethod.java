package org.example;

import java.util.function.Function;

public class ChordMethod implements RootFindingStrategy {
    @Override
    public double findRoot(Function<Double, Double> f, Function<Double, Double> df, double a, double b, double eps) {
        double x0 = a, x1 = b, x2;
        do {
            x2 = x1 - f.apply(x1) * (x1 - x0) / (f.apply(x1) - f.apply(x0));
            x0 = x1;
            x1 = x2;
        } while (Math.abs(f.apply(x2)) > eps);
        return x2;
    }
}
