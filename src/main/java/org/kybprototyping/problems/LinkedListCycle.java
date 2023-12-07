package org.kybprototyping.problems;

import java.util.HashSet;

final class LinkedListCycle {

  private LinkedListCycle() {}

  public static boolean hasCycle(ListNode head) {
    HashSet<ListNode> nodes = new HashSet<>();

    ListNode cur = head;
    while (cur != null) {
      if (nodes.contains(cur)) {
        return true;
      }

      nodes.add(cur);
      cur = cur.next;
    }

    return false;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

}
