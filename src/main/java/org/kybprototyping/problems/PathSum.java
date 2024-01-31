package org.kybprototyping.problems;

import java.util.ArrayList;

final class PathSum {

  private PathSum() {}

  public static boolean hasPathSum(TreeNode root, int targetSum) {
    ArrayList<Integer> curSum = new ArrayList<>();
    return hasPathSum(root, curSum, targetSum);
  }

  private static boolean hasPathSum(TreeNode cur, ArrayList<Integer> curSum, int targetSum) {
    if (cur == null) {
      return false;
    }

    curSum.add(cur.val);
    if (isLeaf(cur) && curSum.stream().reduce(0, Integer::sum) == targetSum) {
      return true;
    }
    boolean hasTargetSumFound = hasPathSum(cur.left, curSum, targetSum);
    if (hasTargetSumFound) {
      return true;
    }
    hasTargetSumFound = hasPathSum(cur.right, curSum, targetSum);
    if (hasTargetSumFound) {
      return true;
    }
    curSum.remove(curSum.size() - 1);
    return false;
  }

  private static boolean isLeaf(TreeNode cur) {
    return cur.left == null && cur.right == null;
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
