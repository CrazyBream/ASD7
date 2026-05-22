package org.example;

import java.util.function.BiFunction;

public class RungeKutta2Method implements ODESolverStrategy {
    @Override
    public void solve(BiFunction<Double, Double, Double> f, double x0, double y0, double xEnd, double h) {
        double x = x0;
        double y = y0;

        System.out.printf("%-10s | %-10s\n", "x", "y");
        System.out.println("-----------------------");
        System.out.printf("%-10.4f | %-10.4f\n", x, y);

        while (x < xEnd) {
            double k1 = h * f.apply(x, y);
            double k2 = h * f.apply(x + h, y + k1);
            y = y + 0.5 * (k1 + k2);
            x += h;
            System.out.printf("%-10.4f | %-10.4f\n", x, y);
        }
    }
}
