// https://leetcode.com/problems/balanced-binary-tree/

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
  public int depth(TreeNode root) {
    if (root == null)
      return 0;

    return 1 + Math.max(depth(root.left), depth(root.right));
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null)
      return true;

    boolean balanced = isBalanced(root.left);
    balanced = balanced && isBalanced(root.right);

    int leftDepth = depth(root.left);
    int rightDepth = depth(root.right);

    return balanced && (Math.abs(leftDepth - rightDepth) <= 1);
  }
}
