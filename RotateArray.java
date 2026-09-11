import java.util.Arrays;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {

        int n = nums.length;

        k = k % n;

        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {

            rotated[(i + k) % n] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(
                Arrays.toString(
                        rotateArray(nums, 3)));
    }
}