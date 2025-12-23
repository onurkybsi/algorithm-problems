package org.kybprototyping.problems;

import java.util.ArrayList;

final class ReorderList {

  private ReorderList() {}

  public void reorderList(ListNode head) {
    ArrayList<ListNode> nodes = new ArrayList<>();
    ListNode cur = head;
    while (cur != null) {
      nodes.add(cur);
      var temp = cur;
      cur = cur.next;
      temp.next = null;
    }

    cur = head;
    int i = 1;
    int j = nodes.size() - 1;
    boolean iSTurn = false;
    while (i <= j) {
      if (iSTurn) {
        cur.next = nodes.get(i);
        cur = nodes.get(i);
        i++;
        iSTurn = false;
      } else {
        cur.next = nodes.get(j);
        cur = nodes.get(j);
        j--;
        iSTurn = true;
      }
    }
  }

  private static class ListNode {
    int val;
    ListNode next;
  }
}
