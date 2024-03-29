/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (28.84%)
 * Likes:    1205
 * Dislikes: 71
 * Total Accepted:    120.6K
 * Total Submissions: 411.6K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * board = [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 * 
 * 
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, ans, i, j);
            }
        }
        return ans;
    }

    public void dfs(char[][] board, TrieNode p, List<String> ans, int i, int j) {
        char c = board[i][j];
        if (c == '*' || p.next[c - 'a'] == null) {
            return;
        }
        p = p.next[c - 'a'];
        if (p.word != null) {
            ans.add(p.word);
            p.word = null;
        }

        board[i][j] = '*';
        if (i >= 1)
            dfs(board, p, ans, i - 1, j);
        if (i < board.length - 1)
            dfs(board, p, ans, i + 1, j);
        if (j >= 1)
            dfs(board, p, ans, i, j - 1);
        if (j < board[0].length - 1)
            dfs(board, p, ans, i, j + 1);
        board[i][j] = c;

    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}

