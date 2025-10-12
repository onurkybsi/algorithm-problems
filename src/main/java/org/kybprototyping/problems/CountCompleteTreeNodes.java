package org.kybprototyping.problems;

import java.util.LinkedList;
import java.util.Queue;

final class CountCompleteTreeNodes {

  private CountCompleteTreeNodes() {}

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int count = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      var cur = queue.poll();
      count++;

      if (cur.left != null) {
        queue.add(cur.left);
      }
      if (cur.right != null) {
        queue.add(cur.right);
      }
    }
    return count;
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
