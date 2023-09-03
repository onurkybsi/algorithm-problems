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
		LinkedHashSet<Integer> c = new LinkedHashSet<>(words.length);
		int c2 = 0;
		int wordLength = words[0].length();

		for (int i = 0; i < words.length;) {
			int startIx = s.indexOf(words[i], c2);
			c2 = startIx + wordLength;

			if (startIx == -1 || startIx == c2) {
				c2 = 0;
				i++; // NOSONAR
			} else {
				c.add(i);

				for (int j = c2; j + wordLength <= s.length() // NOSONAR
						&& c.size() * wordLength < words.length * wordLength; j += wordLength) {
					int searchedWordsIx = Arrays.binarySearch(words, s.substring(j, j + wordLength));
					if (searchedWordsIx < 0 || c.contains(searchedWordsIx)) {
						c.clear();
						break;
					} else if (c.size() == words.length - 1) {
						r.add(startIx);
						c.clear();
						break;
					} else {
						c.add(searchedWordsIx);
					}
				}

			}
		}

		return r;
	}

}
