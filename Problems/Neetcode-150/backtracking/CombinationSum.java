// https://leetcode.com/problems/combination-sum/

import java.util.*;

class Solution {
    int candidates[];
    List<List<Integer>> result;

    public void backtrack(int index, int remaining, List<Integer> currSubset) {
        if (remaining == 0) {
            result.add(new ArrayList<>(currSubset));
            return;
        }

        if (index >= candidates.length || remaining < 0) {
            return;
        }

        backtrack(index + 1, remaining, currSubset);

        int currRemaining = remaining;
        int count = 0;
        while (currRemaining > 0) {
            currRemaining -= candidates[index];
            currSubset.add(candidates[index]);
            backtrack(index + 1, currRemaining, currSubset);
            count++;
        }

        while (count > 0) {
            currSubset.removeLast();
            count--;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.result = new ArrayList<>();
        backtrack(0, target, new ArrayList<>());
        return result;
    }
}
