import java.util.*;

import java.util.*;

class Solution {
  public int trap(int[] height) {
    int result = 0;
    int l = 0, r = height.length - 1;
    int mxL = height[l], mxR = height[r];

    while (l < r) {
      int currMin = Math.min(mxL, mxR);

      int diff1 = currMin - height[l];
      int diff2 = currMin - height[r];

      if (diff1 >= 0) {
        result += diff1;
        l++;
      }

      if (diff2 >= 0) {
        result += diff2;
        r--;
      }

      mxL = Math.max(height[l], mxL);
      mxR = Math.max(height[r], mxR);
    }

    if (l == r && l < height.length) {
      int currMin = Math.min(mxL, mxR);

      int diff1 = currMin - height[l];
      int diff2 = currMin - height[r];

      if (diff1 >= 0) {
        result += diff1;
        l++;
      } else if (diff2 >= 0) {
        result += diff2;
        r--;
      }
    }

    return result;
  }
}
