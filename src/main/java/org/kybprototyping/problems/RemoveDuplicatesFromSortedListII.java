package org.kybprototyping.problems;

import java.util.HashMap;

final class RemoveDuplicatesFromSortedListII {

  private RemoveDuplicatesFromSortedListII() {}

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    HashMap<Integer, Integer> repetition = new HashMap<>();
    ListNode cur = head;
    while (cur != null) {
      int count = repetition.getOrDefault(cur.val, 0);
      repetition.put(cur.val, count + 1);

      cur = cur.next;
    }

    ListNode newHead = head;
    while (newHead != null && repetition.getOrDefault(newHead.val, 0) != 1) {
      newHead = newHead.next;
    }
    if (newHead == null) {
      return null;
    }

    ListNode previous = newHead;
    cur = newHead.next;
    previous.next = null;
    while (cur != null) {
      int count = repetition.getOrDefault(cur.val, 0);
      if (count == 1) {
        previous.next = cur;
        previous = cur;
      }

      cur = cur.next;
    }
    previous.next = null;

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
