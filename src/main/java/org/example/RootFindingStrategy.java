package org.example;

import java.util.function.Function;

public interface RootFindingStrategy {
    double findRoot(Function<Double, Double> f, Function<Double, Double> df, double a, double b, double eps);
}
