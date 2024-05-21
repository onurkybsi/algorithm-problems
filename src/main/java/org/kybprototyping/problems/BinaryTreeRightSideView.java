package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class BinaryTreeRightSideView {

  private BinaryTreeRightSideView() {}

  public static List<Integer> rightSideView(TreeNode root) {
    var result = new ArrayList<Integer>();
    if (root == null)
      return result;

    var temp = new LinkedList<TreeNode>();
    temp.add(root);
    while (!temp.isEmpty()) {
      result.add(temp.getLast().val);

      var nextLevelNodes = new LinkedList<TreeNode>();
      while (!temp.isEmpty()) {
        var cur = temp.remove();

        if (cur.left != null) {
          nextLevelNodes.add(cur.left);
        }
        if (cur.right != null) {
          nextLevelNodes.add(cur.right);
        }
      }
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
