// https://leetcode.com/problems/valid-anagram/

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (final char c : t.toCharArray()) {
            final Integer count = freqMap.getOrDefault(c, 0);

            if (count < 1) {
                return false;
            }

            freqMap.put(c, freqMap.get(c) - 1);
        }

        for (final Character c : t.toCharArray()) {
            final Integer count = freqMap.getOrDefault(c, 0);
            if (count > 0)
                return false;
        }

        return true;
    }
}

public class ValidAnagram {
    public static void main() {
        String[][] inputs = {
                {
                        "anagram",
                        "nagaram"
                },
                {
                        "rat",
                        "car"
                },
                {
                        "a",
                        "ab"
                },
        };
        boolean[] outputs = { true, false, false };

        Solution sol = new Solution();

        for (int i = 0; i < inputs.length; i++) {
            boolean output = sol.isAnagram(inputs[i][0], inputs[i][1]);
            if (output == outputs[i]) {
                System.out.printf("[O] Test case %d passed\n", i);
            } else {
                System.out.printf("[X] Test case %d failed\n", i);
            }
        }

    }
}
