package org.kybprototyping.problems;

final class SameTree {

  private SameTree() {}

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == q) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }

    boolean isSame = isSameTree(p.left, q.left);
    if (!isSame) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }

    return isSameTree(p.right, q.right);
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
