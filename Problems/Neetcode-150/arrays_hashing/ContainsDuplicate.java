// https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> duplicates = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (duplicates.contains(nums[i]))
                return true;

            duplicates.add(nums[i]);
        }

        return false;
    }
}

public class ContainsDuplicate {
    public static void main() {
        int[][] inputs = {
                { 1, 2, 3, 1 },
                { 1, 2, 3, 4 },
                { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 },
        };
        boolean[] outputs = { true, false, true };

        Solution sol = new Solution();

        for (int i = 0; i < inputs.length; i++) {
            boolean output = sol.containsDuplicate(inputs[i]);
            if (output == outputs[i]) {
                System.out.printf("[O] Test case %d passed\n", i);
            } else {
                System.out.printf("[X] Test case %d failed\n", i);
            }
        }

    }
}
