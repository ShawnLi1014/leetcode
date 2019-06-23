/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * algorithms
 * Easy (52.52%)
 * Likes:    1276
 * Dislikes: 2683
 * Total Accepted:    431.5K
 * Total Submissions: 820.7K
 * Testcase Example:  '"III"'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: "III"
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: "IV"
 * Output: 4
 * 
 * Example 3:
 * 
 * 
 * Input: "IX"
 * Output: 9
 * 
 * Example 4:
 * 
 * 
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 */
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> romanToInt = new HashMap<Character, Integer>();
        char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] integer = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < roman.length; i++) {
            romanToInt.put(roman[i], integer[i]);
        }
        for (int j = 0; j < s.length(); j++) {
            char currRoman = s.charAt(j);
            result += romanToInt.get(currRoman);
            if (j < s.length() - 1) {
                switch (currRoman) {
                    case 'I':
                        if (s.charAt(j + 1) == 'V' || s.charAt(j + 1) == 'X')
                            result -= 2;
                        break;
                    case 'X':
                        if (s.charAt(j + 1) == 'L' || s.charAt(j + 1) == 'C')
                            result -= 20;
                        break;
                    case 'C':
                        if (s.charAt(j + 1) == 'D' || s.charAt(j + 1) == 'M')
                            result -= 200;
                        break;
                }
            }
        }
        return result;
    }
}

