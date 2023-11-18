package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

final class SymmetricTree {

  private SymmetricTree() {}

  public static boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left == null && root.right == null) {
      return true;
    }
    if (root.left == null && root.right != null) {
      return false;
    }
    if (root.left != null && root.right == null) {
      return false;
    }
    List<Integer> leftSide = extractLeft(root.left);
    List<Integer> rightSide = extractRight(root.right);
    return leftSide.equals(rightSide);
  }

  private static List<Integer> extractLeft(TreeNode node) {
    List<Integer> result = new ArrayList<>();
    result.add(node.val);

    Queue<TreeNode> q1 = new LinkedList<>();
    q1.add(node);

    while (!q1.isEmpty()) {
      Queue<TreeNode> q2 = new LinkedList<>();

      while (!q1.isEmpty()) {
        TreeNode _node = q1.peek();

        if (_node.left != null) {
          q2.add(_node.left);
          result.add(_node.left.val);
        } else {
          result.add(-101);
        }
        if (_node.right != null) {
          q2.add(_node.right);
          result.add(_node.right.val);
        } else {
          result.add(-101);
        }

        q1.remove();
      }

      q1 = q2;
    }

    return result;
  }

  private static List<Integer> extractRight(TreeNode node) {
    List<Integer> result = new ArrayList<>();
    result.add(node.val);

    Queue<TreeNode> q1 = new LinkedList<>();
    q1.add(node);

    while (!q1.isEmpty()) {
      Queue<TreeNode> q2 = new LinkedList<>();

      while (!q1.isEmpty()) {
        TreeNode _node = q1.peek();

        if (_node.right != null) {
          q2.add(_node.right);
          result.add(_node.right.val);
        } else {
          result.add(-101);
        }
        if (_node.left != null) {
          q2.add(_node.left);
          result.add(_node.left.val);
        } else {
          result.add(-101);
        }

        q1.remove();
      }

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
