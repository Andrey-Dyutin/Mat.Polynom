package controller;
import controller.Polynom;

public class PolynomLagrange {//само вычисл
    public static double[] polynomLagrange(double[] x, double[] y) {
        int k = x.length;
        double[] rez = new double[]{0};
        for (int i = 0; i < k; i++) {
            double[] l = new double[k-1];
            boolean p = true;
            for (int j = 0; j < k; j++) {

                if (i != j) {
                    if(p)
                    {
                        l = Polynom.scale(new double[]{1, -x[i]},1);
                        p = false;
                    }
                    else
                    {
                        l = Polynom.mult(l, new double[]{1, -x[i]});
                    }
                    l = Polynom.scale(l,1 / (x[i] - x[j]));
                }
            }
            rez=Polynom.sum(rez,Polynom.scale(l,y[i]));
        }
        return rez;
    }