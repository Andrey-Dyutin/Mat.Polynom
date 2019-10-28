
import model.*;
import view.*;
import controller.*;
import model.Uzly;


public class Main {

    public  Main(Uzly uzly, ConcoleView consoleview) {
        this.consoleview = consoleview;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Старт");
        double[] x=consoleview.uzlyx();
        double[] y=consoleview.uzlyy();
        System.out.println(ConcoleView.convert(PolynomLagrange.polynomLagrange(x,y)));
    }
}