package leetcode;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
    private int[] num;
    private Random random;
    public static void main(String[] args) {

    }
    public ShuffleArray(int[] nums) {
        this.num = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return num;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = Arrays.copyOf(num,num.length);
        for (int i = 0; i < num.length; i++) {
            int r = i+ random.nextInt(num.length-i);
            int tmp = shuffle[i];
            shuffle[i] = shuffle[r];
            shuffle[r] = tmp;
        }
        return shuffle;
    }
}
