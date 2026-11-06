package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class PrintBinaryTree {
  private PrintBinaryTree() {
  }

  private int height;
  private List<List<String>> res;

  public List<List<String>> printTree(TreeNode root) {
    this.height = height(root);

    int numOfRows = height + 1;
    int numOfCols = (1 << (height + 1)) - 1;
    List<List<String>> res = new ArrayList<>(numOfRows);
    for (int i = 0; i < numOfRows; i++) {
      var row = new ArrayList<>(Collections.nCopies(numOfCols, ""));
      res.add(row);
    }

    res.get(0).set((numOfCols - 1) / 2, String.valueOf(root.val));
    printTree(root.left, 1, leftChildCol(0, (numOfCols - 1) / 2, height), res);
    printTree(root.right, 1, rightChildCol(0, (numOfCols - 1) / 2, height), res);
    return res;
  }

  private void printTree(TreeNode root, int row, int col, List<List<String>> res) {
    if (root == null) {
      return;
    }

    res.get(row).set(col, String.valueOf(root.val));
    if (root.left != null) {
      printTree(root.left, row + 1, leftChildCol(row, col, height), res);
    }
    if (root.right != null) {
      printTree(root.right, row + 1, rightChildCol(row, col, height), res);
    }
  }

  private static int height(TreeNode root) {
    int height = 0;
    if (root.left != null) {
      height = 1 + height(root.left);
    }
    if (root.right != null) {
      height = Math.max(height, 1 + height(root.right));
    }
    return height;
  }

  private static int leftChildCol(int parentRow, int parentCol, int height) {
    return parentCol - (1 << (height - parentRow - 1));
  }

  private static int rightChildCol(int parentRow, int parentCol, int height) {
    return parentCol + (1 << (height - parentRow - 1));
  }

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

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
