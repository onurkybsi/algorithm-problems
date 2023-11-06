package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class SubstringWithConcatenationOfAllWords {

	private SubstringWithConcatenationOfAllWords() {}

	// TODO: It takes too much time in the edge cases.
	// Check the test data.
	@SuppressWarnings({"java:S135", "java:S3776"})
	static List<Integer> findSubstring(String s, String[] words) {
		HashSet<Integer> result = new HashSet<>();

		int wordLength = words[0].length();
		HashSet<String> checkedWords = new HashSet<>(words.length);
		int i = 0;
		int fromIx = 0;
		while (i < words.length) {
			if (checkedWords.contains(words[i])) {
				i = i + 1;
				fromIx = 0;
				continue;
			}

			int startingIx = s.indexOf(words[i], fromIx);

			if (startingIx == -1 || result.contains(startingIx)) {
				checkedWords.add(words[i]);
				i = i + 1;
				fromIx = 0;
			} else {
				HashSet<Integer> usedIndices = new HashSet<>(words.length);
				usedIndices.add(i);

				fromIx = startingIx + wordLength;
				for (int j = fromIx; j + wordLength <= s.length(); j += wordLength) {
					if (usedIndices.size() == words.length) {
						break;
					}

					String nextPiece = s.substring(j, j + wordLength);

					int existentWordIx = indexOf(words, nextPiece, usedIndices);
					if (existentWordIx != -1) {
						usedIndices.add(existentWordIx);
					} else {
						fromIx = startingIx + 1;
						break;
					}
				}

				if (usedIndices.size() == words.length) {
					result.add(startingIx);
					fromIx = startingIx + 1;
				}
			}
		}

		return new ArrayList<>(result);
	}

	private static int indexOf(String[] arr, String str, HashSet<Integer> exclusions) {
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
