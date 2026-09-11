public class SeatingGridOptimizer {

    static double rowAverage(int[] row) {

        int sum = 0;

        for (int num : row) {
            sum += num;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {

        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {

            double avg = rowAverage(seatingScores[i]);

            if (avg >= threshold) {
                result += "Row " + i + ": Buzzing Zone";
            } else {
                result += "Row " + i + ": Quiet Zone";
            }

            if (i != seatingScores.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] seatingScores = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };

        System.out.println(classifyRows(seatingScores, 60));
    }
}