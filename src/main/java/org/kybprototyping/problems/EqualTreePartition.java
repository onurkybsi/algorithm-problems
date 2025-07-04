package org.kybprototyping.problems;

import java.util.HashMap;

final class EqualTreePartition {

  private HashMap<TreeNode, Integer> sumMap = new HashMap<>();

  private EqualTreePartition() {}

  public boolean checkEqualTree(TreeNode root) {
    putSumStartingFrom(root);
    int totalSum = sumMap.get(root);
    for (var partialSum : sumMap.entrySet()) {
      if (partialSum.getKey() != root
          && totalSum - partialSum.getValue() == partialSum.getValue()) {
        return true;
      }
    }
    return false;
  }

  private int putSumStartingFrom(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftSum = putSumStartingFrom(node.left);
    int rightSum = putSumStartingFrom(node.right);
    int sum = leftSum + rightSum + node.val;
    this.sumMap.put(node, sum);
    return sum;
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
