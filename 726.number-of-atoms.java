/*
 * @lc app=leetcode id=726 lang=java
 *
 * [726] Number of Atoms
 *
 * https://leetcode.com/problems/number-of-atoms/description/
 *
 * algorithms
 * Hard (45.27%)
 * Likes:    228
 * Dislikes: 89
 * Total Accepted:    11.8K
 * Total Submissions: 26.1K
 * Testcase Example:  '"H2O"'
 *
 * Given a chemical formula (given as a string), return the count of each
 * atom.
 * 
 * An atomic element always starts with an uppercase character, then zero or
 * more lowercase letters, representing the name.
 * 
 * 1 or more digits representing the count of that element may follow if the
 * count is greater than 1.  If the count is 1, no digits will follow.  For
 * example, H2O and H2O2 are possible, but H1O2 is impossible.
 * 
 * Two formulas concatenated together produce another formula.  For example,
 * H2O2He3Mg4 is also a formula.  
 * 
 * A formula placed in parentheses, and a count (optionally added) is also a
 * formula.  For example, (H2O2) and (H2O2)3 are formulas.
 * 
 * Given a formula, output the count of all elements as a string in the
 * following form: the first name (in sorted order), followed by its count (if
 * that count is more than 1), followed by the second name (in sorted order),
 * followed by its count (if that count is more than 1), and so on.
 * 
 * Example 1:
 * 
 * Input: 
 * formula = "H2O"
 * Output: "H2O"
 * Explanation: 
 * The count of elements are {'H': 2, 'O': 1}.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation: 
 * The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: 
 * formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation: 
 * The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * 
 * 
 * 
 * Note:
 * All atom names consist of lowercase letters, except for the first character
 * which is uppercase.
 * The length of formula will be in the range [1, 1000].
 * formula will only consist of letters, digits, and round parentheses, and is
 * a valid formula as defined in the problem.
 * 
 */
class Solution {
    int i;

    public String countOfAtoms(String formula) {
        StringBuilder res = new StringBuilder();
        i = 0;
        Map<String, Integer> count = parse(formula);
        for (String name : count.keySet()) {
            res.append(name);
            int multiplicity = count.get(name);
            if (multiplicity > 1) {
                res.append("" + multiplicity);
            }
        }
        return res.toString();

    }

    public Map<String, Integer> parse(String formula) {
        int N = formula.length();
        Map<String, Integer> count = new TreeMap<>();
        while (i < N && formula.charAt(i) != ')') {
            if (formula.charAt(i) == '(') {
                i++;
                for (Map.Entry<String, Integer> entry: parse(formula).entrySet()) {
                    count.put(entry.getKey(), count.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            } else {
                int iStart = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = iStart < i ? Integer.valueOf(formula.substring(iStart, i)) : 1;
                System.out.println()
                count.put(name, count.getOrDefault(name, 0) + multiplicity);
            }
        }
        int iStart = ++i;
        while (i < N && Character.isDigit(formula.charAt(i))) {
            i++;
        }
        if (iStart < i) {
            int multiplicity = Integer.parseInt(formula.substring(iStart, i));
            for (String key: count.keySet()) {
                System.out.println(key);
                count.put(key, count.get(key) * multiplicity);
            }
        }
        return count;
    }
}

