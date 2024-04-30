package org.kybprototyping.problems;

import java.util.ArrayList;

final class RotateList {

  private RotateList() {}

  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) {
      return head;
    }

    ArrayList<ListNode> nodesInOrder = new ArrayList<>();
    ListNode cur = head;
    while (cur != null) {
      nodesInOrder.add(cur);
      cur = cur.next;
    }

    int startingIx = nodesInOrder.size() - (k % nodesInOrder.size());
    if (startingIx >= nodesInOrder.size())
      return head;

    int i = startingIx;
    head = nodesInOrder.get(i);
    while (i < nodesInOrder.size()) {
      cur = nodesInOrder.get(i);
      int nextIx = extractNextIx(i, nodesInOrder.size(), startingIx);
      if (nextIx == -1) {
        cur.next = null;
        break;
      }
      cur.next = nodesInOrder.get(nextIx);

      i = nextIx;
    }

    return head;
  }

  private static int extractNextIx(int cur, int listSize, int startingIx) {
    if (cur + 1 == listSize) {
      return 0;
    }
    if (cur == startingIx - 1) {
      return -1;
    }
    return cur + 1;
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
