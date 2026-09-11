public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {

            StringBuilder reversed = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reversed.append(word.charAt(i));
            }

            result.append(reversed).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {

        System.out.println(
                reverseEachWord("hello club"));
    }
}