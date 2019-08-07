/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 *
 * https://leetcode.com/problems/distant-barcodes/description/
 *
 * algorithms
 * Medium (39.20%)
 * Likes:    131
 * Dislikes: 9
 * Total Accepted:    6.5K
 * Total Submissions: 16.6K
 * Testcase Example:  '[1,1,1,2,2,2]'
 *
 * In a warehouse, there is a row of barcodes, where the i-th barcode is
 * barcodes[i].
 * 
 * Rearrange the barcodes so that no two adjacent barcodes are equal.  You may
 * return any answer, and it is guaranteed an answer exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,1,1,2,2,2]
 * Output: [2,1,2,1,2,1]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,2,1,2,1]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        /**
         * Count occurrences of each barcode using a hash map Use a set to sort barcodes
         * by their number of occurrences Starting from most frequent, fill even
         * positions with barcodes Then fill odd positions with remaining barcodes
         */
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            freq.put(barcodes[i], freq.getOrDefault(barcodes[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
        }

        Map.Entry<Integer, Integer> mostFreq = pq.poll();
        int key = mostFreq.getKey();
        int value = mostFreq.getValue();
        int[] res = new int[barcodes.length];
        int i = 0;
        while (value > 0) {
            res[i] = key;
            i += 2;
            value--;
        }
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> pair = pq.poll();
            for (int k = 0; k < pair.getValue(); k++) {
                if (i >= res.length) {
                    i = 1;
                }
                res[i] = pair.getKey();
                i += 2;
            }
        }
        return res;
    }
}
