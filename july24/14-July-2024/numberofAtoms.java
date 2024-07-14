package 14-July-2024;

public class numberofAtoms {


    Name Of The Problem :- 726. Number of Atoms

    Date :- 14-July-2024

    Given a string formula representing a chemical formula, return the count of each atom.

The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow.

For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
Two formulas are concatenated together to produce another formula.

For example, "H2O2He3Mg4" is also a formula.
A formula placed in parentheses, and a count (optionally added) is also a formula.

For example, "(H2O2)" and "(H2O2)3" are formulas.
Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

The test cases are generated so that all the values in the output fit in a 32-bit integer.

 

Example 1:

Input: formula = "H2O"
Output: "H2O"
Explanation: The count of elements are {'H': 2, 'O': 1}.
Example 2:

Input: formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
Example 3:

Input: formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 

Constraints:

1 <= formula.length <= 1000
formula consists of English letters, digits, '(', and ')'.
formula is always valid.

*****************************************************************************************************************************************************


class Solution {
    public String countOfAtoms(String formula) {
         int n = formula.length();

        Stack<Map<String, Integer>> stack = new Stack<>();
        
        stack.push(new HashMap<>());

        int i = 0;
        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }
                int multiplier = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                for (String key : top.keySet()) {
                    int value = top.get(key);
                    top.put(key, value * multiplier);
                }
                for (String key : top.keySet()) {
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + top.get(key));
                }
            } else {
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i++));
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    element.append(formula.charAt(i++));
                }
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i++));
                }
                int count = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                stack.peek().put(element.toString(), stack.peek().getOrDefault(element.toString(), 0) + count);
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(stack.peek());
        StringBuilder result = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            result.append(key);
            int count = sortedMap.get(key);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
        
    }
}
    
}
