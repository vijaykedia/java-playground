package two_pointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/sort-colors/description/">leetcode problem 75</a>
 *
 * <p>Given an array nums with n objects colored red, white, or blue, sort them in-place so that
 * objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * <p>We will use the integers 0, 1, and 2 to represent the color red, white, and blue,
 * respectively.
 *
 * <p>You must solve this problem without using the library's sort function.
 *
 * <p>Example 1: <br>
 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 *
 * <p>Example 2: <br>
 * Input: nums = [2,0,1] Output: [0,1,2]
 *
 * <p>Constraints: <br>
 * n == nums.length <br>
 * 1 <= n <= 300 <br>
 * nums[i] is either 0, 1, or 2.
 *
 * <p>Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors {
  public void sortColors(int[] nums) {

    int red = 0;
    int current = 0;
    int blue = nums.length - 1;
    while (current <= blue) {
      if (nums[current] == 0) {
        if (current != red) {
          swap(nums, red, current);
        }
        red++;
        current++;
      } else if (nums[current] == 1) {
        current++;
      } else {
        swap(nums, current, blue);
        blue--;
      }
    }
    System.out.println(Arrays.toString(nums));
  }

  static void swap(int[] input, int idx1, int idx2) {
    int temp = input[idx1];
    input[idx1] = input[idx2];
    input[idx2] = temp;
  }
}
