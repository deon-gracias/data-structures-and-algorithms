// https://leetcode.com/problems/diameter-of-binary-tree

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
  int mxD = 0;

  public int visitLongestPath(TreeNode root, int path) {
    if (root == null)
      return path;

    int left = visitLongestPath(root.left, path);
    int right = visitLongestPath(root.right, path);

    mxD = Math.max(
        left + right,
        mxD);

    return 1 + Math.max(left, right);
  }

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;
    visitLongestPath(root, 0);
    return mxD;
  }
}
