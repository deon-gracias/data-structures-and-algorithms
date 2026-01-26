// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  List<List<Integer>> levels;

  public void levelDfs(TreeNode root, int level) {
    if (root == null)
      return;

    while (level >= levels.size()) {
      levels.add(
          new ArrayList<Integer>());
    }

    levels.get(level).add(root.val);

    levelDfs(root.left, level + 1);
    levelDfs(root.right, level + 1);
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    levels = new ArrayList<>();
    levelDfs(root, 0);
    return levels;
  }
}
