package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;

import java.util.List;

import lombok.Data;

/**
 * This problems has been taken from <i>LeetCode</i>.
 * You could find the problem description from the <a href=
 * "https://leetcode.com/problems/remove-nth-node-from-end-of-list/">link</a>.
 */
public class RemoveNthNodeFromEndOfList
		implements AlgorithmProblem<RemoveNthNodeFromEndOfList.RemoveNthNodeFromEndOfListArgs> {
	private static List<RemoveNthNodeFromEndOfListArgs> args = BootstrapHelper
			.getProblemArgs(RemoveNthNodeFromEndOfListArgs.class);

	@Data
	public static class RemoveNthNodeFromEndOfListArgs {
		private Integer[] nodeValues;
		private Integer n;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	@Override
	public String getName() {
		return "RemoveNthNodeFromEndOfList";
	}

	@Override
	public String getDescriptionLink() {
		return "https://leetcode.com/problems/remove-nth-node-from-end-of-list/";
	}

	@Override
	public List<RemoveNthNodeFromEndOfList.RemoveNthNodeFromEndOfListArgs> getProblemArgs() {
		return args;
	}

	@Override
	public void runSolution(int argsOrder) {
		RemoveNthNodeFromEndOfListArgs arg = args.get(argsOrder - 1);
		ListNode nextNode = null;
		for (int i = arg.nodeValues.length - 1; i >= 0; i--) {
			ListNode node = new ListNode(arg.nodeValues[i], nextNode);
			nextNode = node;
		}
		ListNode result = removeNthFromEnd(nextNode, arg.n);
		ConsoleUtils.INSTANCE.info(result);
	}

	// Runtime: 1 ms, faster than 72.17% of Java online submissions
	// Memory Usage: 42 MB, less than 67.48% of Java online submissions
	private static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}

		// calculate the length of the list
		ListNode tail = head;
		int lengthOfList = 1;
		while (tail.next != null) {
			tail = tail.next;
			lengthOfList++;
		}

		// remove the nth node
		ListNode previousOne = null;
		ListNode toBeRemoved = head;
		for (int i = 0;; i++) {
			if (i == lengthOfList - n) {
				if (i == 0) {
					head = toBeRemoved.next;
					toBeRemoved = null;
				} else {
					previousOne.next = toBeRemoved.next;
					toBeRemoved = null;
				}
				break;
			} else {
				previousOne = toBeRemoved;
				toBeRemoved = toBeRemoved.next;
			}
		}

		return head;
	}
}
