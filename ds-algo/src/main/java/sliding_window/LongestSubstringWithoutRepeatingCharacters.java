package sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description">leetcode
 * problem 3</a>
 *
 * <p>Given a string s, find the length of the longest substring without duplicate characters.
 *
 * <p>Example 1: <br>
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 *
 * <p>Example 2:<br>
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 *
 * <p>Example 3: <br>
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3.
 *
 * <p>Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * <p>Constraints: <br>
 * 0 <= s.length <= 5 * 10^4 <br>
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {

    if (s.isEmpty()) {
      return 0;
    }

    int lengthOfString = s.length();
    final Set<Character> lookup = new HashSet<>();
    int maxLength = 0;
    int currIndex = 0;
    int left = 0;

    while (currIndex < lengthOfString) {
      char ch = s.charAt(currIndex);

      while (lookup.contains(ch)) {
        lookup.remove(s.charAt(left));
        left++;
      }

      lookup.add(ch);
      maxLength = Math.max(maxLength, (currIndex - left + 1));
      currIndex++;
    }
    return maxLength;
  }
}
