package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Stack;

final class ReverseNodesInKGroup {

  private ReverseNodesInKGroup() {}

  public static ListNode reverseKGroup(ListNode head, int k) {
    ArrayList<Stack<ListNode>> lifos = new ArrayList<>();
    ListNode nodeToNotBeReversed = null;

    ListNode cur = head;
    while (cur != null) {
      Stack<ListNode> lifo = new Stack<>();
      lifos.add(lifo);

      for (int i = 1; i <= k && cur != null; i++) {
        lifo.add(cur);

        if (cur.next == null && i != k) {
          ListNode latestPopped = lifo.pop();
          while (!lifo.isEmpty()) {
            latestPopped = lifo.pop();
          }

          nodeToNotBeReversed = latestPopped;
          lifos.remove(lifos.size() - 1);
        }

        cur = cur.next;
      }
    }

    ListNode newHead = lifos.get(0).pop();
    cur = newHead;
    for (Stack<ListNode> lifo : lifos) {
      while (!lifo.isEmpty()) {
        ListNode next = lifo.pop();

        cur.next = next;
        cur = next;
      }
    }

    cur.next = nodeToNotBeReversed;

    return newHead;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
