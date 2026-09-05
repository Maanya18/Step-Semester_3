import java.util.*;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) return true;

        if (text.charAt(left) != text.charAt(right))
            return false;

        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        char[] rev = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }

        return text.equals(new String(rev));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " +
                isPalindromeIterative(text));

        System.out.println("Recursive: " +
                isPalindromeRecursive(text, 0, text.length() - 1));

        System.out.println("Array Reversal: " +
                isPalindromeArrayReversal(text));
    }
}