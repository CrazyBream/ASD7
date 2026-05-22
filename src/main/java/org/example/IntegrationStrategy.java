package org.example;

import java.util.function.Function;

public interface IntegrationStrategy {
    double integrate(Function<Double, Double> f, double a, double b, double h);
}
