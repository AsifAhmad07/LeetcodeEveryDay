package 30-may-2024;

public class countTripletsThatCanFormTwoArraysofEqualXOR {



    Name Of The Problem :- 1442. Count Triplets That Can Form Two Arrays of Equal XOR

    Date :- 30-May-2024


    Given an array of integers arr.

We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

Let's define a and b as follows:

a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
Note that ^ denotes the bitwise-xor operation.

Return the number of triplets (i, j and k) Where a == b.

 

Example 1:

Input: arr = [2,3,1,6,7]
Output: 4
Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
Example 2:

Input: arr = [1,1,1,1,1]
Output: 10
 

Constraints:

1 <= arr.length <= 300
1 <= arr[i] <= 108


*****************************************************************************************************************************************************a
class Solution {
    public int countTriplets(int[] arr) {
        int[] prefixXor = new int[arr.length + 1];
        
        // Initializing the first element to 0
        prefixXor[0] = 0;

        // Compute prefix XOR
        for (int i = 1; i <= arr.length; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i - 1];
        }

        int triplets = 0;

        // Count the triplets
        for (int i = 0; i < prefixXor.length; i++) {
            for (int k = i + 1; k < prefixXor.length; k++) {
                if (prefixXor[k] == prefixXor[i]) {
                    triplets += k - i - 1;
                }
            }
        }

        return triplets;
        
    }
}
    
}
