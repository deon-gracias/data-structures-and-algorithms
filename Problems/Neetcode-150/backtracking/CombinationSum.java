// https://leetcode.com/problems/combination-sum/

import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    int target;

    public List<List<Integer>> recursive(int index) {
        List<List<Integer>> subproblem = new ArrayList<>();

        if (index >= candidates.length) {
            subproblem.add(new ArrayList<>());
            return subproblem;
        }

        List<List<Integer>> p_subproblem = recursive(index + 1);
        for (List<Integer> n : p_subproblem) {
            subproblem.add(n);

            int sum = n.stream().mapToInt(i -> i).sum();

            int new_sum = candidates[index] + sum;
            List<Integer> new_subproblem = new ArrayList<>(n);
            new_subproblem.add(candidates[index]);

            while (new_sum <= target) {
                if (new_sum == target) {
                    result.add(new ArrayList(new_subproblem));
                    break;
                }

                subproblem.add(new ArrayList(new_subproblem));
                new_sum += candidates[index];
                new_subproblem.add(candidates[index]);
            }
        }

        return subproblem;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;

        recursive(0);

        return result;
    }
}
