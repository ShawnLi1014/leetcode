/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 *
 * https://leetcode.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (17.86%)
 * Likes:    1043
 * Dislikes: 194
 * Total Accepted:    127.5K
 * Total Submissions: 698.5K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such
 * that:
 * 
 * 
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: []
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return ans;
        }
        Map<String, List<String>> graph = new HashMap<>();
        graph = buildGraph(beginWord, endWord, dict);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders(graph, beginWord, endWord, ans, path);
        return ans;

    }

    public Map<String, List<String>> buildGraph(String beginWord, String endWord, Set<String> dict) {

        Map<String, List<String>> graph = new HashMap<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        boolean found = false;
        boolean back = false;

        while (!beginSet.isEmpty() && !endSet.isEmpty() && !found) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
                back = !back;
            }

            Set<String> temp = new HashSet<>();
            for (String curr : beginSet) {
                visited.add(curr);
                for (String next : getNext(curr, dict)) {
                    if (visited.contains(next) || beginSet.contains(next)) {
                        continue;
                    }

                    if (endSet.contains(next)) {
                        found = true;
                    }
                    temp.add(next);
                    String parent = back ? next : curr;
                    String child = back ? curr : next;
                    if (!graph.containsKey(parent)) {
                        graph.put(parent, new ArrayList<>());
                    }
                    graph.get(parent).add(child);
                }
            }
            beginSet = temp;
        }
        return graph;
    }

    public List<String> getNext(String word, Set<String> dict) {
        System.out.println("word: " + word);
        List<String> res = new ArrayList<>();
        int strlen = word.length();
        char[] w = word.toCharArray();
        for (int i = 0; i < strlen; i++) {
            char ch = w[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == ch) {
                    continue;
                }
                w[i] = j;
                String newWord = String.valueOf(w);
                if (dict.contains(newWord)) {
                    res.add(newWord);
                }
                w[i] = ch;
            }
        }
        return res;
    }

    public void findLadders(Map<String, List<String>> graph, String beginWord, String endWord, List<List<String>> ans,
            List<String> path) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(path));
        }
        if (!graph.containsKey(beginWord)) {
            return;
        }
        for (String next : graph.get(beginWord)) {
            path.add(next);
            findLadders(graph, next, endWord, ans, path);
            path.remove(path.size() - 1);
        }
    }
}

