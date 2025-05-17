package two_pointers;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/">leetcode problem 151</a>
 *
 * <p>Given an input string s, reverse the order of the words.
 *
 * <p>A word is defined as a sequence of non-space characters. The words in s will be separated by
 * at least one space.
 *
 * <p>Return a string of the words in reverse order concatenated by a single space.
 *
 * <p>Note that s may contain leading or trailing spaces or multiple spaces between two words. The
 * returned string should only have a single space separating the words. Do not include any extra
 * spaces.
 *
 * <p>Example 1: <br>
 * Input: s = "the sky is blue" <br>
 * Output: "blue is sky the"
 *
 * <p>Example 2: <br>
 * Input: s = " hello world " <br>
 * Output: "world hello" <br>
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * <p>Example 3: <br>
 * Input: s = "a good example" <br>
 * Output: "example good a" <br>
 * Explanation: You need to reduce multiple spaces between two words to a single space in the
 * reversed string.
 *
 * <p>Constraints: <br>
 * 1 <= s.length <= 10^4 <br>
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '. <br>
 * There is at least one word in s.
 *
 * <p>Follow-up: If the string data type is mutable in your language, can you solve it in-place with
 * O(1) extra space?
 */
public class ReverseWords {

  public String reverseWords(String sentence) {

    int current = sentence.length() - 1;
    StringBuilder result = new StringBuilder();
    char[] input = sentence.toCharArray();
    while (current >= 0) {
      int wordStart = -1;
      int wordEnd = -1;
      while (current >= 0) {
        if (Character.isWhitespace(input[current])) {
          current--;
        } else {
          break;
        }
      }
      wordEnd = current;
      while (current >= 0) {
        if (!Character.isWhitespace(input[current])) {
          current--;
        } else {
          break;
        }
      }
      wordStart = current + 1;
      if (wordStart != -1 && wordEnd != -1) {
        for (int i = wordStart; i <= wordEnd; i++) {
          result.append(input[i]);
        }
        result.append(" ");
      }
    }
    return result.deleteCharAt(result.length() - 1).toString();
  }
}
