package org.kybprototyping.problems;

import java.util.ArrayList;

final class SumRootToLeafNumbers {

  private SumRootToLeafNumbers() {}

  public static int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return root.val;
    }

    ArrayList<Integer> numbersInPathBeforeCur = new ArrayList<>();
    ArrayList<Integer> pathNumbers = new ArrayList<>();
    add(root, numbersInPathBeforeCur, pathNumbers);

    int sum = 0;
    for (Integer pathNumber : pathNumbers) {
      sum += pathNumber;
    }
    return sum;
  }

  private static void add(TreeNode cur, ArrayList<Integer> numbersInPathBeforeCur,
      ArrayList<Integer> pathNumbers) {
    if (cur == null) {
      return;
    }
    if (cur.left == null && cur.right == null) {
      int pathNumber = buildPathNumber(numbersInPathBeforeCur, cur.val);
      pathNumbers.add(pathNumber);
      return;
    }

    numbersInPathBeforeCur.add(cur.val);
    add(cur.left, numbersInPathBeforeCur, pathNumbers);
    add(cur.right, numbersInPathBeforeCur, pathNumbers);
    numbersInPathBeforeCur.remove(numbersInPathBeforeCur.size() - 1);
  }

  private static int buildPathNumber(ArrayList<Integer> numbersInPathBeforeCur, int cur) {
    int i = numbersInPathBeforeCur.size() - 1;
    int digit = 1;
    int number = cur;
    while (i >= 0) {
      number += numbersInPathBeforeCur.get(i) * Math.pow(10, digit);
      i--;
      digit++;
    }
    return number;
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
