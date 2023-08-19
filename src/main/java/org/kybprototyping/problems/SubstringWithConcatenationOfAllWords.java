package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;
import java.util.ArrayList;
import java.util.HashSet;
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
		HashSet<String> wordsPermutations = buildWordsPermutations(words);
		ArrayList<String> sSubStrings = buildSubStrings(s, words[0].length() * words.length);
		List<Integer> r = new ArrayList<>();
		for (int i = 0; i < sSubStrings.size(); i++) {
			if (wordsPermutations.contains(sSubStrings.get(i))) {
				r.add(i);
			}
		}
		return r;
	}

	private static HashSet<String> buildWordsPermutations(String[] words) {
		var permutations = new HashSet<String>(words.length * words.length - 1);

		var a = new ArrayList<String[]>();
		for (int i = 0; i < words.length * (words.length - 1); i++) {
			a.add(words.clone());
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				String temp = a.get(j)[j];
				a.get(j)[j] = a.get(j)[i];
				a.get(j)[i] = temp;
				permutations.add(String.join("", a.get(j)));
			}
		}

		return permutations;
	}

	private static ArrayList<String> buildSubStrings(String s, int maxLength) {
		if (s.length() <= 0) {
			return new ArrayList<>();
		}

		ArrayList<String> result = new ArrayList<>();
		int i = 0;
		while (s.length() - i >= maxLength) {
			result.add(s.substring(i, i + maxLength));
			i++;
		}

		return result;
	}

}
