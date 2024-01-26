package org.kybprototyping.problems;

final class InvertBinaryTree {

  private InvertBinaryTree() {}

  public static TreeNode invertTree(TreeNode root) {
    invert(root);
    return root;
  }

  private static void invert(TreeNode cur) {
    if (cur == null || (cur.left == null && cur.right == null)) {
      return;
    }
    if (cur.left != null && cur.right != null) {
      invert(cur.left);
      invert(cur.right);
      TreeNode temp = cur.left;
      cur.left = cur.right;
      cur.right = temp;
      return;
    }
    if (cur.left != null) {
      invert(cur.left);
      cur.right = cur.left;
      cur.left = null;
      return;
    }
    if (cur.right != null) {
      invert(cur.right);
      cur.left = cur.right;
      cur.right = null;
    }
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
