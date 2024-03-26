package org.kybprototyping.problems;

import java.util.ArrayList;

final class FlattenBinaryTreeToLinkedList {

  private FlattenBinaryTreeToLinkedList() {}

  public static void flatten(TreeNode root) {
    ArrayList<TreeNode> nodesInPreorder = new ArrayList<>();
    addInPreorder(root, nodesInPreorder);

    for (int i = 1; i < nodesInPreorder.size(); i++) {
      TreeNode prev = nodesInPreorder.get(i - 1);
      TreeNode cur = nodesInPreorder.get(i);
      prev.right = cur;
      prev.left = null;
    }
  }

  private static void addInPreorder(TreeNode cur, ArrayList<TreeNode> nodes) {
    if (cur == null) {
      return;
    }

    nodes.add(cur);
    addInPreorder(cur.left, nodes);
    addInPreorder(cur.right, nodes);
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
