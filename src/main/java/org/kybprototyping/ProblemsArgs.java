package org.kybprototyping;

import java.util.List;
import org.kybprototyping.problems.DivideTwoIntegers.DivideTwoIntegersArgs;
import org.kybprototyping.problems.GenerateParentheses.GenerateParenthesesArgs;
import org.kybprototyping.problems.IndexOfTheFirstOccurrenceInAString.IndexOfTheFirstOccurrenceInAStringArgs;
import org.kybprototyping.problems.MergeTwoSortedLists.MergeTwoSortedListsArgs;
import org.kybprototyping.problems.RemoveDuplicatesFromSortedArray.RemoveDuplicatesFromSortedArrayArgs;
import org.kybprototyping.problems.RemoveElement.RemoveElementArgs;
import org.kybprototyping.problems.RemoveNthNodeFromEndOfList.RemoveNthNodeFromEndOfListArgs;
import org.kybprototyping.problems.SwapNodesInPairs.SwapNodesInPairsArgs;
import lombok.Data;

@Data
public class ProblemsArgs {
	private List<RemoveNthNodeFromEndOfListArgs> removeNthNodeFromEndOfListArgs;
	private List<MergeTwoSortedListsArgs> mergeTwoSortedListsArgs;
	private List<GenerateParenthesesArgs> generateParenthesesArgs;
	private List<SwapNodesInPairsArgs> swapNodesInPairsArgs;
	private List<RemoveDuplicatesFromSortedArrayArgs> removeDuplicatesFromSortedArrayArgs;
	private List<RemoveElementArgs> removeElementArgs;
	private List<IndexOfTheFirstOccurrenceInAStringArgs> indexOfTheFirstOccurrenceInAStringArgs;
	private List<DivideTwoIntegersArgs> divideTwoIntegersArgs;
}
