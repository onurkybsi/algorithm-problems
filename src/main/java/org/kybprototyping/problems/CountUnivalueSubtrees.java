package org.kybprototyping.problems;

final class CountUnivalueSubtrees {

  private CountUnivalueSubtrees() {}

  public int countUnivalSubtrees(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }

    int countUnivalSubtreesLeft = 0;
    int countUnivalSubtreesRight = 0;
    if (root.left != null) {
      countUnivalSubtreesLeft = countUnivalSubtrees(root.left);
    }
    if (root.right != null) {
      countUnivalSubtreesRight = countUnivalSubtrees(root.right);
    }

    if (root.left == null && root.val == root.right.val && canBeConnectedRight(root)) {
      return countUnivalSubtreesRight + 1;
    }
    if (root.right == null && root.val == root.left.val && canBeConnectedLeft(root)) {
      return countUnivalSubtreesLeft + 1;
    }
    if (root.left != null && root.right != null && root.val == root.left.val
        && root.val == root.right.val && canBeConnectedLeft(root) && canBeConnectedRight(root)) {
      return countUnivalSubtreesLeft + countUnivalSubtreesRight + 1;
    } else {
      return countUnivalSubtreesLeft + countUnivalSubtreesRight;
    }
  }

  private static boolean canBeConnectedLeft(TreeNode root) {
    var left = root.left;
    if (left.left != null && left.left.val != left.val) {
      return false;
    }
    if (left.right != null && left.right.val != left.val) {
      return false;
    }
    return true;
  }

  private static boolean canBeConnectedRight(TreeNode root) {
    var right = root.right;
    if (right.left != null && right.left.val != right.val) {
      return false;
    }
    if (right.right != null && right.right.val != right.val) {
      return false;
    }
    return true;
  }

  private static class TreeNode {
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
