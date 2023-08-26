package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;
import lombok.Data;

public class SubstringWithConcatenationOfAllWords implements
		AlgorithmProblem<SubstringWithConcatenationOfAllWords.SubstringWithConcatenationOfAllWordsArgs> {

	private static List<SubstringWithConcatenationOfAllWordsArgs> args =
			BootstrapHelper.getProblemArgs(SubstringWithConcatenationOfAllWordsArgs.class);

	@Data
	public static class SubstringWithConcatenationOfAllWordsArgs {
		private String s;
		private String[] words;
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public String getDescriptionLink() {
		return "https://leetcode.com/problems/substring-with-concatenation-of-all-words/";
	}

	@Override
	public List<SubstringWithConcatenationOfAllWordsArgs> getProblemArgs() {
		return args;
	}

	@Override
	public void runSolution(int argsOrder) {
		var arg = getProblemArgs().get(argsOrder - 1);
		List<Integer> result = findSubstring(arg.getS(), arg.getWords());
		ConsoleUtils.INSTANCE.info(result);
	}

	private static List<Integer> findSubstring(String s, String[] words) {
		HashSet<String> wordsPermutations = buildWordsPermutations(words);
		List<Integer> r = new ArrayList<>();
		for (String wp : wordsPermutations) {
			int i = 0;
			while (s.length() - i >= wp.length()) {
				if (s.substring(i, i + wp.length()).equals(wp)) {
					r.add(i);
					i += wp.length();
				} else {
					i++;
				}
			}
		}
		return r;
	}

	private static HashSet<String> buildWordsPermutations(String[] words) {
		int permutationsCount =
				IntStream.rangeClosed(1, words.length).reduce(1, (int x, int y) -> x * y);

		var wordsCopies = new ArrayList<String[]>();
		for (int i = 0; i < permutationsCount; i++) {
			wordsCopies.add(words.clone());
		}

		var permutations = new HashSet<String>(permutationsCount);
		// Needs to be calculated

		return permutations;
	}

}
