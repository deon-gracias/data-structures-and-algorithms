// https://leetcode.com/problems/find-the-duplicate-number/description/

class Solution {
  public int findDuplicate(int[] nums) {
    int slow = 0, fast = 0;

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    int p = 0;
    while (nums[slow] != nums[p]) {
      slow = nums[slow];
      p = nums[p];
    }

    return nums[p];
  }
}
