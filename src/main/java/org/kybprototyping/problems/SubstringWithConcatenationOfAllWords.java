package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
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

		List<Integer> r = new ArrayList<>();
		LinkedHashSet<Integer> c = LinkedHashSet.newLinkedHashSet(words.length);
		int c2 = 0;

		for (int i = 0; i < words.length;) {
			int startIx = s.indexOf(words[i], c2);
			if (startIx == -1) {
				c2 = 0;
				i++; // NOSONAR
				continue;
			}
			if (startIx == c2 && startIx != 0) {
				c2 = 0;
				i++; // NOSONAR
			}
			c2 = startIx + words[i].length();
			c.add(i);

			for (int j = startIx + words[i].length(); c.size() * words[i].length() < words[i].length() // NOSONAR
					* words.length; j += words[i].length()) {
				if (Arrays.binarySearch(words, s.substring(j, j + words[i].length())) < 0) {
					c.clear();
					break;
				} else if (c.size() == words.length - 1) {
					r.add(startIx);
					c.clear();
					break;
				} else {
					c.add(j);
				}
			}

		}

		return r;
	}

}
