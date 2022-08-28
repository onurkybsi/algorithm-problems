package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;

import java.util.List;

/**
 * This problems has been taken from <i>LeetCode</i>.
 * You could find the problem description from the <a href=
 * "https://leetcode.com/problems/remove-nth-node-from-end-of-list/">link</a>.
 */
public class RemoveNthNodeFromEndOfList {
	public static List<RemoveNthNodeFromEndOfListArgs> args = BootstrapHelper
			.getProblemArgs("RemoveNthNodeFromEndOfList");

	private RemoveNthNodeFromEndOfList() {
		throw new UnsupportedOperationException("This class is stateless!");
	}

	public class RemoveNthNodeFromEndOfListArgs {
		public Integer[] nodeValues;
		public Integer n;
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
