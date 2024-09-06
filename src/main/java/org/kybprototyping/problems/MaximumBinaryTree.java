package org.kybprototyping.problems;

final class MaximumBinaryTree {

  private MaximumBinaryTree() {}

  public static TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructMaximumBinaryTree(nums, 0, nums.length);
  }

  public static TreeNode constructMaximumBinaryTree(int[] nums, int from, int to) {
    if (from == to) {
      return null;
    }

    int maxIx = findMaxIx(nums, from, to);
    TreeNode root = new TreeNode(nums[maxIx]);
    root.left = constructMaximumBinaryTree(nums, from, maxIx);
    root.right = constructMaximumBinaryTree(nums, maxIx + 1, to);
    return root;
  }

  private static int findMaxIx(int[] nums, int from, int to) {
    int maxVal = Integer.MIN_VALUE;
    int maxIx = -1;
    for (int i = from; i < to; i++) {
      if (nums[i] > maxVal) {
        maxVal = nums[i];
        maxIx = i;
      }
    }
    return maxIx;
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
