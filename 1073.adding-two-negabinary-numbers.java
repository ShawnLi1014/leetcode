/*
 * @lc app=leetcode id=1073 lang=java
 *
 * [1073] Adding Two Negabinary Numbers
 *
 * https://leetcode.com/problems/adding-two-negabinary-numbers/description/
 *
 * algorithms
 * Medium (31.24%)
 * Likes:    44
 * Dislikes: 23
 * Total Accepted:    2.9K
 * Total Submissions: 9.1K
 * Testcase Example:  '[1,1,1,1,1]\n[1,0,1]'
 *
 * Given two numbers arr1 and arr2 in base -2, return the result of adding them
 * together.
 * 
 * Each number is given in array format:  as an array of 0s and 1s, from most
 * significant bit to least significant bit.  For example, arr = [1,1,0,1]
 * represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.  A number arr in array
 * format is also guaranteed to have no leading zeros: either arr == [0] or
 * arr[0] == 1.
 * 
 * Return the result of adding arr1 and arr2 in the same format: as an array of
 * 0s and 1s with no leading zeros.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * Output: [1,0,0,0,0]
 * Explanation: arr1 represents 11, arr2 represents 5, the output represents
 * 16.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= arr1.length <= 1000
 * 1 <= arr2.length <= 1000
 * arr1 and arr2 have no leading zeros
 * arr1[i] is 0 or 1
 * arr2[i] is 0 or 1
 * 
 */
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1, carry = 0;
        List<Integer> ans = new ArrayList<Integer>();
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0)
                carry += arr1[i--];
            if (j >= 0)
                carry += arr2[j--];
            ans.add(0, carry & 1);
            carry = -(carry >> 1);
        }
        while (ans.size() > 1 && ans.get(0) == 0) {
            ans.remove(0);
        }
        int[] resultArray = new int[ans.size()];
        for (int k = 0; k < resultArray.length; k++) {
            resultArray[k] = ans.get(k);
        }
        return resultArray;
    }
}

