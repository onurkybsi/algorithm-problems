package org.kybprototyping.problems;

import java.util.ArrayList;

final class SortList {

  private SortList() {}

  public static ListNode sortList(ListNode head) {
    if (head == null)
      return null;

    ArrayList<ListNode> nodesInOrder = new ArrayList<>();
    ListNode cur = head;
    while (cur != null) {
      nodesInOrder.add(cur);
      cur = cur.next;
    }

    nodesInOrder.sort((n1, n2) -> n1.val - n2.val);

    for (int i = 0; i < nodesInOrder.size() - 1; i++) {
      cur = nodesInOrder.get(i);
      ListNode next = nodesInOrder.get(i + 1);
      cur.next = next;
    }
    nodesInOrder.get(nodesInOrder.size() - 1).next = null;

    return nodesInOrder.get(0);
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
