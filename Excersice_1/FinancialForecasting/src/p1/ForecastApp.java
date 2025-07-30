package p1;

import java.util.*;

class Forecast {
    static double predictFutureValue(double presentValue, double rate, int years) {
        if (years == 0) return presentValue;
        return (1 + rate) * predictFutureValue(presentValue, rate, years - 1);
    }
}

public class ForecastApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter present value: ");
        double pv = sc.nextDouble();
        System.out.print("Enter annual growth rate (e.g. 0.05 for 5%): ");
        double rate = sc.nextDouble();
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double futureValue = Forecast.predictFutureValue(pv, rate, years);
        System.out.printf("Predicted future value after %d years: %.2f\n", years, futureValue);
    }
}