package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;

import java.util.List;

import lombok.Data;

/**
 * This problems has been taken from <i>LeetCode</i>.
 * You could find the problem description from the <a href=
 * "https://leetcode.com/problems/merge-two-sorted-lists/">link</a>.
 */
public class MergeTwoSortedLists
		implements AlgorithmProblem<MergeTwoSortedLists.MergeTwoSortedListsArgs> {
	private static List<MergeTwoSortedListsArgs> args = BootstrapHelper.getProblemArgs(MergeTwoSortedListsArgs.class);

	@Data
	public static class MergeTwoSortedListsArgs {
		private Integer[] nodeValues1;
		private Integer[] nodeValues2;
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
		return "MergeTwoSortedListsArgs";
	}

	@Override
	public String getDescriptionLink() {
		return "https://leetcode.com/problems/merge-two-sorted-lists/";
	}

	@Override
	public List<MergeTwoSortedListsArgs> getProblemArgs() {
		return args;
	}

	@Override
	public void runSolution(int argsOrder) {
		MergeTwoSortedListsArgs arg = args.get(argsOrder - 1);
		ListNode list1 = buildLinkedListByNodeValues(arg.nodeValues1);
		ListNode list2 = buildLinkedListByNodeValues(arg.nodeValues2);
		ListNode result = mergeTwoLists(list1, list2);
		ConsoleUtils.INSTANCE.info(result);
	}

	private static ListNode buildLinkedListByNodeValues(Integer[] nodeValues) {
		ListNode nextNode = null;
		for (int i = nodeValues.length - 1; i >= 0; i--) {
			ListNode node = new ListNode(nodeValues[i], nextNode);
			nextNode = node;
		}
		return nextNode;
	}

	// Runtime: 1 ms, faster than 79.46% of Java online submissions
	// Memory Usage: 42.7 MB, less than 67.10% of Java online submissions
	private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		ListNode headNode = null;
		ListNode nextNode = null;
		if (list1.val >= list2.val) {
			headNode = new ListNode(list2.val, nextNode);
			list2 = list2.next;
		} else {
			headNode = new ListNode(list1.val, nextNode);
			list1 = list1.next;
		}

		ListNode previousNode = headNode;
		while (list1 != null || list2 != null) {
			if (list1 == null) {
				nextNode = new ListNode(list2.val, null);
				list2 = list2.next;
			} else if (list2 == null) {
				nextNode = new ListNode(list1.val, null);
				list1 = list1.next;
			} else if (list1.val >= list2.val) {
				nextNode = new ListNode(list2.val, null);
				list2 = list2.next;
			} else {
				nextNode = new ListNode(list1.val, null);
				list1 = list1.next;
			}
			previousNode.next = nextNode;
			previousNode = nextNode;
		}
		if (nextNode != null) {
			nextNode.next = list1 != null ? list1 : list2;
		}

		return headNode;
	}
}
