package fast_slow_pointer;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/description">leetcode problem
 * 287</a>
 *
 * <p>Given an array of integers nums containing n + 1 integers where each integer is in the range
 * [1, n] inclusive.
 *
 * <p>There is only one repeated number in nums, return this repeated number.
 *
 * <p>You must solve the problem without modifying the array nums and using only constant extra
 * space.
 *
 * <p>Example 1: <br>
 * Input: nums = [1,3,4,2,2] <br>
 * Output: 2
 *
 * <p>Example 2: <br>
 * Input: nums = [3,1,3,4,2] <br>
 * Output: 3
 *
 * <p>Example 3: <br>
 * Input: nums = [3,3,3,3,3] <br>
 * Output: 3
 *
 * <p>Constraints: <br>
 * 1 <= n <= 10^5 <br>
 * nums.length == n + 1 <br>
 * 1 <= nums[i] <= n <br>
 * All the integers in nums appear only once except for precisely one integer which appears two or
 * more times.
 *
 * <p>Follow up: <br>
 * How can we prove that at least one duplicate number must exist in nums? <br>
 * Can you solve the problem in linear runtime complexity?
 */
public class FindDuplicate {

  // Note: This problem will be solved by floyd's algorithm
  public int findDuplicate(final int[] nums) {
    // If we consider that the numbers in the array represents two things:
    // 1: Number itself
    // 2: pointer two the next number
    // Now since nums[i] >= 1, we can say cycle will never start from the first elements
    // initialize two pointers to the start of the array.
    int slow = nums[0];
    int fast = nums[0];
    do {
      // travel a slow pointer with 1 step and a fast pointer 2 steps to find where they intersect
      slow = nums[slow];
      fast = nums[fast];
      fast = nums[fast];
    } while (slow != fast);
    //  reinitialize slow pointer to the first element in the array and again find the intersection,
    // but
    // this time both slow and fast pointer travels at same speed
    slow = nums[0];
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return fast;
  }
}
