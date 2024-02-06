package org.kybprototyping.problems;

import java.util.ArrayList;

final class BinarySearchTreeIterator {

  private BinarySearchTreeIterator() {}

  class BSTIterator {

    private final ArrayList<TreeNode> traversal;

    private int pointer = 0;

    public BSTIterator(TreeNode root) {
      this.traversal = extractInTraversalOrder(root);
    }

    public int next() {
      return traversal.get(pointer++).val;
    }

    public boolean hasNext() {
      return pointer < traversal.size();
    }

    private static ArrayList<TreeNode> extractInTraversalOrder(TreeNode root) {
      ArrayList<TreeNode> nodes = new ArrayList<>();
      extractInTraversalOrder(root, nodes);
      return nodes;
    }

    private static void extractInTraversalOrder(TreeNode cur, ArrayList<TreeNode> nodes) {
      if (cur == null) {
        return;
      }
      extractInTraversalOrder(cur.left, nodes);
      nodes.add(cur);
      extractInTraversalOrder(cur.right, nodes);
    }

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
