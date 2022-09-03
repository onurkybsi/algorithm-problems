package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;

import java.util.List;

import lombok.Data;
import lombok.Getter;

/**
 * This problems has been taken from <i>LeetCode</i>.
 * You could find the problem description from the <a href=
 * "https://leetcode.com/problems/remove-nth-node-from-end-of-list/">link</a>.
 */
public class RemoveNthNodeFromEndOfList {
	public static List<RemoveNthNodeFromEndOfListArgs> args = BootstrapHelper
			.getProblemArgs(RemoveNthNodeFromEndOfListArgs.class);

	private RemoveNthNodeFromEndOfList() {
		throw new UnsupportedOperationException("This class is stateless!");
	}

	@Data
	public static class RemoveNthNodeFromEndOfListArgs {
		private Integer[] nodeValues;
		private Integer n;
	}

	@Getter
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	private static ListNode removeNthFromEnd(ListNode head, int n) {
		return null;
	}

	public static void runSolution(int argumentIx) {
		RemoveNthNodeFromEndOfListArgs arg = args.get(argumentIx);
		ListNode nextNode = null;
		for (int i = arg.nodeValues.length - 1; i >= 0; i--) {
			ListNode node = new ListNode(arg.nodeValues[i], nextNode);
			nextNode = node;
		}
		ListNode result = removeNthFromEnd(nextNode, arg.n);
		System.out.println(result);
	}
}
