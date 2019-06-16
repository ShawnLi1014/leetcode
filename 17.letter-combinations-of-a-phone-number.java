import java.util.ArrayList;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (41.61%)
 * Likes:    2168
 * Dislikes: 293
 * Total Accepted:    391.1K
 * Total Submissions: 940.1K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    Map<String, String> phoneMap = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    List<String> output = new ArrayList<String>();

    public void backTrack(String combination, String nextDigits) {

        // If there's no remaining digit, add combination to output list
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            // Iterate over all letters that map the next digit
            String nextCharacter = phoneMap.get(nextDigits.substring(0, 1));
            for (int i = 0; i < nextCharacter.length(); i++) {
                String letter = nextCharacter.substring(i, i + 1);
                // Add the next letter to combination and move on
                backTrack(combination + letter, nextDigits.substring(1));
            }
        }
        
    }

    public List<String> letterCombinations(String digits) {
        // If digits.length() == 0, return empty list
        if (digits.length() != 0) {
            String combination = "";
            backTrack(combination, digits);
        }
        return output;
    }
}

