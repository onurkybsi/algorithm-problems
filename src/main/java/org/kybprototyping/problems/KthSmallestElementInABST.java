package org.kybprototyping.problems;

final class KthSmallestElementInABST {

  private KthSmallestElementInABST() {}

  public static int kthSmallest(TreeNode root, int k) {
    return kthSmallest(root, k, new MutableInteger());
  }

  private static Integer kthSmallest(TreeNode cur, int k, MutableInteger i) {
    if (i.val == k) {
      return cur.val;
    }
    if (cur == null) {
      return -1;
    }

    int kthSmallest = kthSmallest(cur.left, k, i);
    if (kthSmallest != -1)
      return kthSmallest;

    i.val = i.val + 1;
    if (i.val == k)
      return cur.val;

    kthSmallest = kthSmallest(cur.right, k, i);
    if (kthSmallest != -1)
      return kthSmallest;

    return -1;
  }

  static class MutableInteger {

    int val = 0;

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
