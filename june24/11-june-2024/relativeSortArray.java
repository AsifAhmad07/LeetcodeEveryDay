package 11-june-2024;

public class relativeSortArray {


    Name of The Problem :- 1122. Relative Sort Array

    Date :- 11-June-2024

    Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]
 

Constraints:

1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
All the elements of arr2 are distinct.
Each arr2[i] is in arr1.

*****************************************************************************************************************************************************

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        // Mark elements not in arr2 with a large value (to be sorted at the end)
        int largeValue = 1000000000; // 1e9 equivalent in Java
        for (int i = 0; i < arr1.length; i++) {
            if (!map.containsKey(arr1[i])) {
                map.put(arr1[i], largeValue);
            }
        }

        // Define the comparator using a lambda expression
        Comparator<Integer> comparator = (num1, num2) -> {
            int index1 = map.get(num1);
            int index2 = map.get(num2);
            if (index1 == index2) {
                return Integer.compare(num1, num2);
            }
            return Integer.compare(index1, index2);
        };

        // Convert arr1 to a list for sorting
        List<Integer> arr1List = new ArrayList<>();
        for (int num : arr1) {
            arr1List.add(num);
        }

        // Sort the list using the defined comparator
        Collections.sort(arr1List, comparator);

        // Convert the sorted list back to an array
        int[] sortedArray = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            sortedArray[i] = arr1List.get(i);
        }

        return sortedArray;
        
    }
}
    
}
