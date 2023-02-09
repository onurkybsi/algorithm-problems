package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;
import java.util.List;
import lombok.Data;

public class SwapNodesInPairs implements AlgorithmProblem<SwapNodesInPairs.SwapNodesInPairsArgs> {

	private static List<SwapNodesInPairsArgs> args =
			BootstrapHelper.getProblemArgs(SwapNodesInPairsArgs.class);

	@Data
	public static class SwapNodesInPairsArgs {
		private Integer[] nodeValues;
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
		return this.getClass().getSimpleName();
	}

	@Override
	public String getDescriptionLink() {
		return "https://leetcode.com/problems/swap-nodes-in-pairs/";
	}

	@Override
	public List<SwapNodesInPairsArgs> getProblemArgs() {
		return args;
	}

	@Override
	public void runSolution(int argsOrder) {
		ListNode result = swapPairs(buildLinkedListByNodeValues(args.get(argsOrder - 1).nodeValues));
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

	private static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode newHead = cur.next;

		ListNode next = null;
		ListNode third = null;
		while (cur != null && cur.next != null) {
			next = cur.next;
			third = next.next;

			ListNode temp = cur;
			cur = next;
			cur.next = temp;
			temp.next = third != null ? third.next : null;

			cur = third;
		}

		return newHead;
	}

}
