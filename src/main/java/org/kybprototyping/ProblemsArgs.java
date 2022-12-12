package org.kybprototyping;

import org.kybprototyping.problems.GenerateParentheses.GenerateParenthesesArgs;
import org.kybprototyping.problems.MergeTwoSortedLists.MergeTwoSortedListsArgs;
import org.kybprototyping.problems.RemoveNthNodeFromEndOfList.RemoveNthNodeFromEndOfListArgs;
import org.kybprototyping.problems.ValidParentheses.ValidParenthesesArgs;

import java.util.List;

import lombok.Data;

@Data
public class ProblemsArgs {
	private List<RemoveNthNodeFromEndOfListArgs> removeNthNodeFromEndOfListArgs;
	private List<ValidParenthesesArgs> validParenthesesArgs;
	private List<MergeTwoSortedListsArgs> mergeTwoSortedListsArgs;
	private List<GenerateParenthesesArgs> generateParenthesesArgs;
}
