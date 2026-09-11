import java.util.ArrayList;
import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + codingScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Candidate other) {

        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }
}

public class PlacementRanking {

    static boolean isEligible(double cgpa) {

        return cgpa >= 7.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {

        ArrayList<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {

            double score = c.getCompositeScore();

            double cgpa = (score - (score % 10)) / 10;

            if (isEligible(cgpa) || isEligible(cgpa, (int)(score % 100))) {
                shortlisted.add(c);
            }
        }

        Candidate[] result =
                shortlisted.toArray(new Candidate[0]);

        Arrays.sort(result);

        String output = "";

        for (int i = 0; i < result.length; i++) {

            output += (i + 1) + ". "
                    + result[i].getName()
                    + " ("
                    + result[i].getCompositeScore()
                    + ")";

            if (i != result.length - 1) {
                output += " | ";
            }
        }

        return output;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}