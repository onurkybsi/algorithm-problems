package org.kybprototyping.problems;

import java.util.LinkedList;
import java.util.Queue;

final class MaximumDepthOfBinaryTree {

  private MaximumDepthOfBinaryTree() {}

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> q1 = new LinkedList<>();
    q1.add(root);

    int maxDepth = 0;
    while (!q1.isEmpty()) {
      maxDepth++;
      Queue<TreeNode> q2 = new LinkedList<>();

      while (!q1.isEmpty()) {
        TreeNode next = q1.poll();

        if (next.left != null) {
          q2.add(next.left);
        }
        if (next.right != null) {
          q2.add(next.right);
        }
      }

      q1 = q2;
    }

    return maxDepth;
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
