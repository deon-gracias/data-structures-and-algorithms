// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freqMap = new HashMap<>();

    for (int num : nums)
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

    List<List<Integer>> buckets = new ArrayList<>();

    for (int i = 0; i <= nums.length; i++)
      buckets.add(new ArrayList<>());

    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      int freq = entry.getValue();

      List<Integer> bucket = buckets.get(freq);

      if (bucket == null)
        buckets.add(freq, new ArrayList<>());

      buckets.get(freq).add(entry.getKey());
    }

    int result[] = new int[k];
    int index = 0;
    for (int i = buckets.size() - 1; i >= 0; i--) {
      if (buckets.get(i) == null)
        continue;
      for (Integer num : buckets.get(i)) {
        result[index++] = num;

        if (index == k)
          return result;
      }
    }

    return result;
  }
}
