package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
		if (s.length() == 0 || words.length == 0) {
			return r;
		}
		if (s.length() == words.length && s.length() == 1 && s.equals(words[0])) {
			r.add(0);
			return r;
		}

		LinkedHashSet<Integer> c = new LinkedHashSet<>(words.length);
		int nextIx = 0;
		int wordLength = words[0].length();

		for (int i = 0; i < words.length;) {
			int startIx = s.indexOf(words[i], nextIx);
			nextIx++;

			if (startIx == -1) {
				nextIx = 0;
				i++; // NOSONAR
				c.clear();
			} else {
				c.add(i);

				for (int j = startIx + wordLength; j + wordLength <= s.length() // NOSONAR
						&& c.size() * wordLength <= words.length * wordLength; j += wordLength) {
					int searchedWordsIx = findIx(words, s.substring(j, j + wordLength), c);
					if (searchedWordsIx < 0 || c.contains(searchedWordsIx)) {
						c.clear();
						break;
					} else if (c.size() == words.length - 1) {
						r.add(startIx);
						c.clear();
						break;
					} else if (j + wordLength > words.length * wordLength) {
						c.clear();
					} else {
						c.add(searchedWordsIx);
					}
				}

			}
		}

		return r.stream().distinct().toList();
	}

	private static int findIx(String[] toSearch, String searched, Set<Integer> excludedOnes) {
		for (int i = 0; i < toSearch.length; i++) {
			if (searched.equals(toSearch[i]) && !excludedOnes.contains(i)) {
				return i;
			}
		}
		return -1;
	}

}
