package org.kybprototyping.problems;

/**
 * This problems has been taken from <i>LeetCode</i>.
 * You could find the problem description from the <a href=
 * "https://leetcode.com/problems/remove-nth-node-from-end-of-list/">link</a>.
 */
public class RemoveNthNodeFromEndOfList {
	private RemoveNthNodeFromEndOfList() {
		throw new UnsupportedOperationException("This class is stateless!");
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		return null;
	}
}
