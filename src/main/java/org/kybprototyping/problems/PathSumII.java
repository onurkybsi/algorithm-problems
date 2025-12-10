package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.List;

final class PathSumII {

  private PathSumII() {}

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> answer = new ArrayList<>();
    pathSum(root, targetSum, new ArrayList<>(), answer);
    return answer;
  }

  private static void pathSum(TreeNode root, int targetSum, List<Integer> curPath,
      List<List<Integer>> answer) {
    if (root == null) {
      return;
    }
    if (isLeafNode(root) && targetSum == root.val) {
      curPath.add(root.val);
      answer.add(curPath);
      return;
    }

    curPath.add(root.val);
    pathSum(root.left, targetSum - root.val, new ArrayList<>(curPath), answer);
    pathSum(root.right, targetSum - root.val, new ArrayList<>(curPath), answer);
  }

  private static boolean isLeafNode(TreeNode node) {
    return node.left == null && node.right == null;
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

}
