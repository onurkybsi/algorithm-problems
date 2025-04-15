package org.kybprototyping.problems;

final class RootEqualsSumOfChildren {

  private RootEqualsSumOfChildren() {}

  public boolean checkTree(TreeNode root) {
    return root.val == root.left.val + root.right.val;
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
