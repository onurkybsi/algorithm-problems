package org.kybprototyping.problems;

import java.util.ArrayList;

final class PartitionList {

  private PartitionList() {}

  public static ListNode partition(ListNode head, int x) {
    ArrayList<ListNode> lessThanXs = new ArrayList<>();
    ArrayList<ListNode> equalOrGreaterThanXs = new ArrayList<>();

    ListNode cur = head;
    while (cur != null) {
      if (cur.val < x) {
        lessThanXs.add(cur);
      } else {
        equalOrGreaterThanXs.add(cur);
      }

      cur = cur.next;
    }

    ListNode newHead = null;
    ListNode previous = null;
    if (!lessThanXs.isEmpty()) {
      newHead = lessThanXs.get(0);
      previous = newHead;

      for (int i = 1; i < lessThanXs.size(); i++) {
        previous.next = lessThanXs.get(i);
        previous = lessThanXs.get(i);
      }
    }
    if (!equalOrGreaterThanXs.isEmpty()) {
      if (lessThanXs.isEmpty()) {
        newHead = equalOrGreaterThanXs.get(0);
        previous = newHead;
      }

      for (int i = 0; i < equalOrGreaterThanXs.size(); i++) {
        previous.next = equalOrGreaterThanXs.get(i);
        previous = equalOrGreaterThanXs.get(i);
      }
    }
    if (previous != null) {
      previous.next = null;
    }

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
