package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class BinaryTreeZigzagLevelOrderTraversal {

  private BinaryTreeZigzagLevelOrderTraversal() {}

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    result.add(List.of(root.val));

    var temp = new LinkedList<TreeNode>();
    temp.add(root);
    boolean fromRightToLeft = true;
    while (!temp.isEmpty()) {
      var nextLevelNodes = new LinkedList<TreeNode>();
      while (!temp.isEmpty()) {
        var cur = temp.remove();
        if (cur.left != null)
          nextLevelNodes.add(cur.left);
        if (cur.right != null)
          nextLevelNodes.add(cur.right);
      }

      if (!nextLevelNodes.isEmpty()) {
        if (fromRightToLeft) {
          var nextLevelNodesReverseOrder = new ArrayList<Integer>();
          for (int i = nextLevelNodes.size() - 1; i >= 0; i--) {
            nextLevelNodesReverseOrder.add(nextLevelNodes.get(i).val);
          }
          result.add(nextLevelNodesReverseOrder);
        } else {
          result.add(nextLevelNodes.stream().map(n -> n.val).toList());
        }
      }
      temp = nextLevelNodes;
      fromRightToLeft = !fromRightToLeft;
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
