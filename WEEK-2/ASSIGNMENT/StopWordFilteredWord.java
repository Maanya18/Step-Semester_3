import java.util.*;

public class StopWordFilteredWord {

    public static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
                "the", "was", "and", "a",
                "is", "of", "in"
        };

        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                map.put(word,
                        map.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort((a, b) ->
                b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey()
                    + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}