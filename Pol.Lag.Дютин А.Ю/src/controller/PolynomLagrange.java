package controller;

import controller.Polynom;

public class PolynomLagrange {

    public static double[] polynomLagrange(double[] x, double[] y) {
        int index = 0;
        for (int i = 1; i < x.length; i++) {
            index = i;
        }
        double[] polyLagr={1};
        double[] poly = {1};
        double delta = 1;
        for (int j = 0; j < y.length; j++) {
            for (int i = 0; i < x.length; i++) {
                if (i != index) {
                    double[] ymnozh = {y[j]};
                    double[] currentTerm = {1, -x[i]};
                    delta = delta * (x[index] - x[i]);
                    poly = Polynom.mult(poly, currentTerm);
                    polyLagr=Polynom.mult(poly,ymnozh);
                }
            }
        }
        return polyLagr;
    }
}



