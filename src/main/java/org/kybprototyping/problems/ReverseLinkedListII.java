package org.kybprototyping.problems;

import java.util.Stack;

@SuppressWarnings({"java:S1149"})
final class ReverseLinkedListII {

  private ReverseLinkedListII() {}

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode beforeBegin = null;
    ListNode beforeEnd = null;
    var reversed = new Stack<ListNode>();
    ListNode after = null;

    ListNode cur = head;
    int curPosition = 1;
    while (cur != null) {
      if (curPosition < left && curPosition == 1) {
        beforeBegin = cur;
        beforeEnd = cur;
      } else if (curPosition < left && curPosition != 1) {
        beforeEnd = cur;
      } else if (curPosition >= left && curPosition <= right) {
        reversed.add(cur);
      } else if (after == null) {
        after = cur;
      } else {
        break;
      }

      cur = cur.next;
      curPosition++;
    }

    if (reversed.isEmpty()) {
      return head;
    } else {
      head = beforeBegin == null ? reversed.pop() : beforeBegin;
      cur = beforeBegin == null ? head : beforeEnd;
      while (!reversed.isEmpty()) {
        var next = reversed.pop();
        cur.next = next;

        cur = next;
      }
    }

    if (cur != null) {
      if (after != null) {
        cur.next = after;
      } else {
        cur.next = null;
      }
    }

    return head;
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
