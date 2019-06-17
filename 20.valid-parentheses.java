/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (36.53%)
 * Likes:    2912
 * Dislikes: 144
 * Total Accepted:    595.2K
 * Total Submissions: 1.6M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution {
    private HashMap<Character, Character> parentheses;

    public Solution() {
        this.parentheses = new HashMap<Character, Character>();
        this.parentheses.put('}', '{');
        this.parentheses.put(']', '[');
        this.parentheses.put(')', '(');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char currElem = s.charAt(i);
            //if left parentheses, push
            if(!this.parentheses.containsKey(currElem)) {
                stack.push(s.charAt(i));
            } else {
                char top = stack.empty() ? '#': stack.pop();
                if(top != this.parentheses.get(currElem)) {
                    return false;
                }
            }
        }
        return stack.empty(); 
    }
}

