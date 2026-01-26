// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {
  public boolean dfs(TreeNode root, TreeNode p, List<TreeNode> path) {
    if (root == null)
      return false;
    if (root.val == p.val)
      return true;

    path.add(root.left);
    if (dfs(root.left, p, path)) {
      return true;
    }
    path.removeLast();

    path.add(root.right);
    if (dfs(root.right, p, path)) {
      return true;
    }
    path.removeLast();

    return false;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;

    List<TreeNode> pathToP = new ArrayList<>(Arrays.asList(root));
    List<TreeNode> pathToQ = new ArrayList<>(Arrays.asList(root));

    dfs(root, p, pathToP);
    dfs(root, q, pathToQ);

    int i = 0;
    while (i < Math.min(pathToP.size(), pathToQ.size()) &&
        pathToP.get(i).val == pathToQ.get(i).val) {
      i++;
    }

    return pathToP.get(--i);
  }
}
