package org.kybprototyping.problems;

import java.util.Stack;

final class ReverseLinkedList {
  private ReverseLinkedList() {}

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    Stack<ListNode> stack = new Stack<>();
    ListNode cur = head;
    while (cur != null) {
      stack.add(cur);
      cur = cur.next;
    }

    ListNode newHead = stack.pop();
    ListNode previous = newHead;
    while (!stack.isEmpty()) {
      cur = stack.pop();
      cur.next = null;
      previous.next = cur;
      previous = cur;
    }
    return newHead;
  }

  private final class ListNode {
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
