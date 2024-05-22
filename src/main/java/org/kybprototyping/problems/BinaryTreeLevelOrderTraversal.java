package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class BinaryTreeLevelOrderTraversal {

  private BinaryTreeLevelOrderTraversal() {}

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    result.add(List.of(root.val));

    var temp = new LinkedList<TreeNode>();
    temp.add(root);
    while (!temp.isEmpty()) {
      var nextLevelNodes = new LinkedList<TreeNode>();
      while (!temp.isEmpty()) {
        var cur = temp.remove();
        if (cur.left != null)
          nextLevelNodes.add(cur.left);
        if (cur.right != null)
          nextLevelNodes.add(cur.right);
      }

      if (!nextLevelNodes.isEmpty())
        result.add(nextLevelNodes.stream().map(n -> n.val).toList());
      temp = nextLevelNodes;
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
