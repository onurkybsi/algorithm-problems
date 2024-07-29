package org.kybprototyping.problems;

import java.util.ArrayDeque;
import java.util.Queue;

final class PopulatingNextRightPointersInEachNodeII {

  private PopulatingNextRightPointersInEachNodeII() {}

  public static Node connect(Node root) {
    if (root == null) {
      return null;
    }

    Queue<Node> q1 = new ArrayDeque<>();
    q1.add(root);
    while (!q1.isEmpty()) {
      Queue<Node> q2 = new ArrayDeque<>();

      Node last = null;
      var cur = q1.poll();
      while (cur != null) {
        if (last != null) {
          last.next = cur;
        }

        if (cur.left != null) {
          q2.add(cur.left);
        }
        if (cur.right != null) {
          q2.add(cur.right);
        }

        last = cur;
        cur = q1.poll();
      }

      q1 = q2;
    }

    return root;
  }

  private static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

}
