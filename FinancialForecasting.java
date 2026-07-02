public class FinancialForecasting {

    // Recursive method
    public static double forecast(double currentValue,
                                  double growthRate,
                                  int years) {

        // Base case
        if (years == 0) {
            return currentValue;
        }

        // Recursive case
        return forecast(currentValue * (1 + growthRate),
                        growthRate,
                        years - 1);
    }

    public static void main(String[] args) {

        double presentValue = 10000;   // Initial amount
        double growthRate = 0.10;      // 10%
        int years = 5;

        double futureValue =
                forecast(presentValue, growthRate, years);

        System.out.printf("Present Value : %.2f%n", presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.printf("Future Value  : %.2f%n", futureValue);
    }
}