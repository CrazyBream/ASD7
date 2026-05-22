package org.example;

import java.util.function.BiFunction;

public interface ODESolverStrategy {
    void solve(BiFunction<Double, Double, Double> f, double x0, double y0, double xEnd, double h);
}
