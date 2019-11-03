package controller;

public class Polynom {

    public static double[] sum(int x1[], int y1[]) {
        int k = x1.length;
        double[] m = new double[k];
        for (int i = 0; i < k; i++) {
            m[i] = x1[i] + y1[i];
        }
        return m;
    }

    public static double[] mult(double x1[], double y1[]) {
        int degA = x1.length;
        int degB = y1.length;
        double[] result = new double[degA + degB - 1];
        for (int i = 0; i < degA; i++) {
            for (int j = 0; j < degB; j++) {
                result[i + j] += x1[i] * y1[j];
            }
        }
        return result;
    }

    public static double[] scale(double[] x1, double k) {
        double[] y1 = new double[x1.length];
        for (int i = 0; i < x1.length; i++) {
            y1[i] = x1[i] * k;
        }
        return y1;
    }
}
