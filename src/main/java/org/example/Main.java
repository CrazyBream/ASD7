package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Рівень 1: ЧИСЕЛЬНЕ ІНТЕГРУВАННЯ ===");
        Function<Double, Double> func1 = x -> Math.sin(Math.sqrt(1 + Math.pow(x, 2) + x));

        System.out.print("Введіть a (наприклад, 2): ");
        double a1 = scanner.nextDouble();
        System.out.print("Введіть b (наприклад, 5): ");
        double b1 = scanner.nextDouble();
        System.out.print("Введіть крок h (наприклад, 0.2): ");
        double h1 = scanner.nextDouble();

        System.out.printf("Метод прямокутників: %.6f\n", new RectangleMethod().integrate(func1, a1, b1, h1));
        System.out.printf("Метод трапецій:      %.6f\n", new TrapezoidalMethod().integrate(func1, a1, b1, h1));
        System.out.printf("Метод Сімпсона:      %.6f\n", new SimpsonMethod().integrate(func1, a1, b1, h1));

        System.out.println("\n=== Рівень 2: КОРЕНІ АЛГЕБРИЧНИХ РІВНЯНЬ ===");
        Function<Double, Double> func2 = x -> Math.pow(2, x) + 2 * Math.pow(x, 2) - 3;

        Function<Double, Double> dfunc2 = x -> Math.pow(2, x) * Math.log(2) + 4 * x;

        System.out.print("Введіть початок інтервалу a (наприклад, 0): ");
        double a2 = scanner.nextDouble();
        System.out.print("Введіть кінець інтервалу b (наприклад, 1): ");
        double b2 = scanner.nextDouble();
        System.out.print("Введіть точність eps (наприклад, 0.001): ");
        double eps = scanner.nextDouble();

        try {
            System.out.printf("Метод половинчастого ділення: %.6f\n", new BisectionMethod().findRoot(func2, dfunc2, a2, b2, eps));
            System.out.printf("Метод дотичних (Ньютона):     %.6f\n", new NewtonMethod().findRoot(func2, dfunc2, a2, b2, eps));
            System.out.printf("Метод хорд:                   %.6f\n", new ChordMethod().findRoot(func2, dfunc2, a2, b2, eps));
        } catch (Exception e) {
            System.out.println("Помилка обчислення коренів: " + e.getMessage());
        }

        System.out.println("\n=== Рівень 3: ДИФЕРЕНЦІАЛЬНІ РІВНЯННЯ ===");
        BiFunction<Double, Double, Double> func3 = (x, y) -> 1.0 / (2 * x - Math.pow(y, 2));

        System.out.print("Введіть початкове x0: ");
        double x0 = scanner.nextDouble();
        System.out.print("Введіть початкове y0: ");
        double y0 = scanner.nextDouble();
        System.out.print("Введіть кінцеве xEnd: ");
        double xEnd = scanner.nextDouble();
        System.out.print("Введіть крок h: ");
        double h3 = scanner.nextDouble();

        System.out.println("Метод Рунге-Кутта 2-го порядку:");
        new RungeKutta2Method().solve(func3, x0, y0, xEnd, h3);

        scanner.close();
    }
}
