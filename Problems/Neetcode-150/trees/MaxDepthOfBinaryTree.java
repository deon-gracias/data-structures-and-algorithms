// https://leetcode.com/problems/maximum-depth-of-binary-tree

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
  public int maxDepth(TreeNode root, int height) {
    if (root == null)
      return height;

    return Math.max(
        maxDepth(root.left, height + 1),
        maxDepth(root.right, height + 1));
  }

  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;

    return Math.max(
        maxDepth(root.left, 1),
        maxDepth(root.right, 1));
  }
}
