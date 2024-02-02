package 02-feb-2024;

public class sequentialDigits {

    Name Of The Problem :- 1291. Sequential Digits

    Date :- 02-feb-2024


    An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9


----------------------------------------------------------------------------------------------------------------------------



class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
         Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 8; i++) {
            queue.offer(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            if (temp >= low && temp <= high) {
                result.add(temp);
            }

            int lastDigit = temp % 10;
            if (lastDigit + 1 <= 9) {
                queue.offer(temp * 10 + (lastDigit + 1));
            }
        }

        return result;
        
    }
}
    
}
