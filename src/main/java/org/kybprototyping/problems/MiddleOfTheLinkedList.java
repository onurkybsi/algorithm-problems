package org.kybprototyping.problems;

final class MiddleOfTheLinkedList {

  private MiddleOfTheLinkedList() {}

  public ListNode middleNode(ListNode head) {
    ListNode cur = head;
    int size = 0;
    while (cur != null) {
      size++;
      cur = cur.next;
    }

    cur = head;
    int i = 0;
    while (i < (size / 2)) {
      i++;
      cur = cur.next;
    }
    return cur;
  }

  private class ListNode {
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
