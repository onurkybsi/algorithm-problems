package org.kybprototyping.problems;

final class FlipEquivalentBinaryTrees {

  private FlipEquivalentBinaryTrees() {}

  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    if (root1.val != root2.val) {
      return false;
    }

    int left1 = root1.left == null ? -1 : root1.left.val;
    int right1 = root1.right == null ? -1 : root1.right.val;
    int left2 = root2.left == null ? -1 : root2.left.val;
    int right2 = root2.right == null ? -1 : root2.right.val;
    // Already same
    if (left1 == left2 && right1 == right2) {
      return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }
    // Flip needed
    if (left1 == right2 && right1 == left2) {
      TreeNode temp = root1.left;
      root1.left = root1.right;
      root1.right = temp;
      return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }
    return false;
  }

  private class TreeNode {
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
