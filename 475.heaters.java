/*
 * @lc app=leetcode id=475 lang=java
 *
 * [475] Heaters
 *
 * https://leetcode.com/problems/heaters/description/
 *
 * algorithms
 * Easy (31.86%)
 * Likes:    504
 * Dislikes: 523
 * Total Accepted:    49.6K
 * Total Submissions: 155K
 * Testcase Example:  '[1,2,3]\n[2]'
 *
 * Winter is coming! Your first job during the contest is to design a standard
 * heater with fixed warm radius to warm all the houses.
 * 
 * Now, you are given positions of houses and heaters on a horizontal line,
 * find out minimum radius of heaters so that all houses could be covered by
 * those heaters.
 * 
 * So, your input will be the positions of houses and heaters seperately, and
 * your expected output will be the minimum radius standard of heaters.
 * 
 * Note:
 * 
 * 
 * Numbers of houses and heaters you are given are non-negative and will not
 * exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not
 * exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be
 * warmed.
 * All the heaters follow your radius standard and the warm radius will the
 * same.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the
 * radius 1 standard, then all the houses can be warmed.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to
 * use radius 1 standard, then all the houses can be warmed.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index == 0 ? Integer.MAX_VALUE : house - heaters[index - 1];
            int dist2 = index >= heaters.length ? Integer.MAX_VALUE : heaters[index] - house;
            result = Math.max(result, Math.min(dist1, dist2));
        }
        return result;
    }
}

