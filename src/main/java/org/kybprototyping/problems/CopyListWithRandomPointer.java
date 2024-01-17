package org.kybprototyping.problems;

import java.util.HashMap;

final class CopyListWithRandomPointer {

  private CopyListWithRandomPointer() {}

  public static Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    Node newHead = new Node(head.val);

    HashMap<Node, Node> copies = new HashMap<>();
    Node cur = head;
    Node newCur = newHead;
    while (cur.next != null) {
      newCur.next = new Node(cur.next.val);
      copies.put(cur, newCur);
      copies.put(newCur, cur);

      cur = cur.next;
      newCur = newCur.next;
    }
    copies.put(cur, newCur);
    copies.put(newCur, cur);

    cur = newHead;
    while (cur != null) {
      Node curOriginal = copies.get(cur);
      cur.random = curOriginal.random != null ? copies.get(curOriginal.random) : null;

      cur = cur.next;
    }

    return newHead;
  }

  // Definition for a Node.
  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

}
