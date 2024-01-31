package org.kybprototyping.problems;

import java.util.ArrayList;

final class MinimumAbsoluteDifferenceInBST {

  private MinimumAbsoluteDifferenceInBST() {}

  public static int getMinimumDifference(TreeNode root) {
    ArrayList<Integer> vals = new ArrayList<>();
    addSubtreeValues(root, vals);
    return extractMinDiff(vals);
  }

  private static void addSubtreeValues(TreeNode cur, ArrayList<Integer> vals) {
    if (cur == null) {
      return;
    }

    addSubtreeValues(cur.left, vals);
    vals.add(cur.val);
    addSubtreeValues(cur.right, vals);
  }

  private static int extractMinDiff(ArrayList<Integer> vals) {
    int i = 0;
    int j = 1;
    int minDiff = Integer.MAX_VALUE;
    while (j < vals.size()) {
      int diff = Math.abs(vals.get(i) - vals.get(j));
      if (diff < minDiff) {
        minDiff = diff;
      }

      i++;
      j++;
    }
    return minDiff;
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
