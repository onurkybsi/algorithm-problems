package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

final class AverageOfLevelsInBinaryTree {

  private AverageOfLevelsInBinaryTree() {}

  public static List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();

    Queue<TreeNode> q1 = new LinkedList<>();
    q1.add(root);

    long levelSum = 0;
    long levelCount = 0;

    while (!q1.isEmpty()) {
      levelSum = 0;
      levelCount = 0;

      Queue<TreeNode> q2 = new LinkedList<>();
      while (!q1.isEmpty()) {
        TreeNode node = q1.peek();
        levelSum += node.val;
        levelCount++;
        if (node.left != null) {
          q2.add(node.left);
        }
        if (node.right != null) {
          q2.add(node.right);
        }

        q1.remove();
      }
      result.add(((double) levelSum) / ((double) levelCount));

      q1 = q2;
    }

    return result;
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
