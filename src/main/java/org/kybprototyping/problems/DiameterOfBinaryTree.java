package org.kybprototyping.problems;

final class DiameterOfBinaryTree {

  private DiameterOfBinaryTree() {}

  public int diameterOfBinaryTree(TreeNode root) {
    return diameterAndHeightOfBinaryTree(root).diameter();
  }

  private static Pair diameterAndHeightOfBinaryTree(TreeNode root) {
    if (root == null) {
      return new Pair(0, 0);
    }

    Pair leftTree = null;
    if (root.left != null) {
      leftTree = diameterAndHeightOfBinaryTree(root.left);
    }
    Pair rightTree = null;
    if (root.right != null) {
      rightTree = diameterAndHeightOfBinaryTree(root.right);
    }

    int diameter = leftTree != null ? leftTree.diameter() : Integer.MIN_VALUE;
    diameter = Math.max(diameter, rightTree != null ? rightTree.diameter() : Integer.MIN_VALUE);
    diameter = Math.max(diameter,
        (leftTree == null ? 0 : leftTree.height) + (rightTree == null ? 0 : rightTree.height));
    int height =
        Math.max(leftTree == null ? 0 : leftTree.height, rightTree == null ? 0 : rightTree.height)
            + 1;
    return new Pair(diameter, height);
  }

  private record Pair(int diameter, int height) {
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
