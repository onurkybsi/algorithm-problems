package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;
import java.util.ArrayList;
import java.util.HashSet;
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

	@SuppressWarnings({"java:S135", "java:S3776"})
	private static List<Integer> findSubstring(String s, String[] words) {
		Set<Integer> result = new HashSet<>();

		int i = 0;
		int fromIndex = 0;
		while (i < words.length) {
			int startingIx = s.indexOf(words[i], fromIndex);
			if (startingIx == -1 || result.contains(startingIx)) {
				i = i + 1;
				fromIndex = 0;
			} else {
				ArrayList<Integer> usedIndices = new ArrayList<>();
				usedIndices.add(i);

				fromIndex = startingIx + words[0].length();
				for (int j = fromIndex; j + words[0].length() <= s.length(); j += words[0].length()) {
					if (usedIndices.size() == words.length) {
						break;
					}

					String nextPiece = s.substring(j, j + words[0].length());
					int existentWordIx = getIxIfExists(words, nextPiece, usedIndices);
					if (existentWordIx != -1) {
						usedIndices.add(existentWordIx);
					} else {
						fromIndex = startingIx + words[0].length();
						break;
					}
				}

				if (usedIndices.size() == words.length) {
					result.add(startingIx);
					fromIndex = startingIx + words[0].length();
				}
			}
		}

		return new ArrayList<>(result);
	}

	private static int getIxIfExists(String[] arr, String str, ArrayList<Integer> exclusions) {
		for (int i = 0; i < arr.length; i++) {
			if (exclusions.contains(i)) {
				continue;
			}
			if (str.equals(arr[i])) {
				return i;
			}
		}
		return -1;
	}

}
