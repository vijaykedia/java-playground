package sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href="https://leetcode.com/problems/longest-repeating-character-replacement/description/">leetcode
 * problem 424</a>
 *
 * <p>You are given a string s and an integer k. You can choose any character of the string and
 * change it to any other uppercase English character. You can perform this operation at most k
 * times.
 *
 * <p>Return the length of the longest substring containing the same letter you can get after
 * performing the above operations.
 *
 * <p>Example 1: <br>
 * Input: s = "ABAB", k = 2 <br>
 * Output: 4 <br>
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * <p>Example 2: <br>
 * Input: s = "AABABBA", k = 1 <br>
 * Output: 4 <br>
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA". The substring "BBBB"
 * has the longest repeating letters, which is 4. There may exists other ways to achieve this answer
 * too.
 *
 * <p>Constraints: <br>
 * 1 <= s.length <= 10^5 <br>
 * s consists of only uppercase English letters. <br>
 * 0 <= k <= s.length
 */
public class LongestRepeatingCharacterReplacement {
  public int characterReplacement(String s, int k) {

    final int lengthOfInput = s.length();
    int left = 0;
    int current = 0;
    int max = -1;
    Map<Character, Integer> lookup = new HashMap<>();

    while (current < lengthOfInput) {
      char currentCharacter = s.charAt(current);
      lookup.compute(currentCharacter, (key, value) -> (value == null) ? 1 : value + 1);

      int maxOccurrence = lookup.values().stream().max(Integer::compare).orElse(0);

      if (current - left + 1 - maxOccurrence == k) {
        max = Math.max(max, current - left + 1);
      } else if (current - left + 1 - maxOccurrence > k) {
        lookup.computeIfPresent(s.charAt(left), (key, value) -> value - 1);
        left++;
      }
      current++;
    }
    return Math.max(max, current - left);
  }
}
