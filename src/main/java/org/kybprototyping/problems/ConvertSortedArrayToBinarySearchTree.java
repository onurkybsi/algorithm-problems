package org.kybprototyping.problems;

final class ConvertSortedArrayToBinarySearchTree {

  private ConvertSortedArrayToBinarySearchTree() {}

  public static TreeNode sortedArrayToBST(int[] nums) {
    return insert(nums, 0, nums.length);
  }

  private static TreeNode insert(int[] nums, int l, int r) {
    int m = l + (r - l) / 2;
    if (m >= nums.length) {
      return null;
    }

    TreeNode n = new TreeNode(nums[m]);
    if (m != l && m != r) {
      n.left = insert(nums, l, m);
      n.right = insert(nums, m + 1, r);
    }
    return m == l && m == r ? null : n;
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
