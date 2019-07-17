/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 *
 * https://leetcode.com/problems/super-ugly-number/description/
 *
 * algorithms
 * Medium (41.54%)
 * Likes:    373
 * Dislikes: 96
 * Total Accepted:    62.2K
 * Total Submissions: 148.5K
 * Testcase Example:  '12\n[2,7,13,19]'
 *
 * Write a program to find the n^th super ugly number.
 * 
 * Super ugly numbers are positive numbers whose all prime factors are in the
 * given prime list primes of size k.
 * 
 * Example:
 * 
 * 
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32 
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first
 * 12 
 * ⁠            super ugly numbers given primes = [2,7,13,19] of size 4.
 * 
 * Note:
 * 
 * 
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000.
 * The n^th super ugly number is guaranteed to fit in a 32-bit signed integer.
 * 
 * 
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        
        PriorityQueue<Candidate> pq = new PriorityQueue<>();
        ugly[0] = 1;
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new Candidate(primes[i], 0, primes[i]));
        }
        for (int i = 1; i < n; i++) {
            int next = pq.peek().curVal;
            ugly[i] = next;
            while(pq.peek().curVal == ugly[i]) {
                Candidate cur = pq.poll();
                pq.add(new Candidate(ugly[cur.index] * cur.base, cur.index + 1, cur.base));
            }
        }
        return ugly[n - 1];

    }

    public class Candidate implements Comparable<Candidate> {
        int curVal;
        int index;
        int base;

        public Candidate(int curVal, int index, int base) {
            this.curVal = curVal;
            this.index = index;
            this.base = base;
        }

        @Override
        public int compareTo(Candidate that) {
            return this.curVal - that.curVal;
        }
    }
}

