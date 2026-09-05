public class BMICalculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    public static void main(String[] args) {

        double[] heights = {1.75, 1.60, 1.80, 1.68, 1.72};
        double[] weights = {70, 90, 65, 80, 95};

        System.out.printf("%-8s %-10s %-10s %-10s %-15s\n",
                "Person", "Height", "Weight", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%-8d %-10.2f %-10.2f %-10.2f %-15s\n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    getBmiStatus(bmi));
        }
    }
}