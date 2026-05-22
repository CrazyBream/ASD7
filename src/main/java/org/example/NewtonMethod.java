package org.example;

import java.util.function.Function;

public class NewtonMethod implements RootFindingStrategy {
    @Override
    public double findRoot(Function<Double, Double> f, Function<Double, Double> df, double a, double b, double eps) {
        double x = a; // Початкове наближення
        while (Math.abs(f.apply(x)) > eps) {
            x = x - f.apply(x) / df.apply(x);
        }
        return x;
    }
}
