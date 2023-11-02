package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class SubstringWithConcatenationOfAllWords {

	private SubstringWithConcatenationOfAllWords() {}

	@SuppressWarnings({"java:S135", "java:S3776"})
	static List<Integer> findSubstring(String s, String[] words) {
		Set<Integer> result = checkIfAllSame(s, words);

		if (result.size() == s.length() / words.length) {
			return new ArrayList<>(result);
		}

		int wordLength = words[0].length();

		int i = 0;
		int fromIndex = 0;
		HashSet<String> temp = new HashSet<>(wordLength);
		while (i < words.length) {
			int startingIx = s.indexOf(words[i], fromIndex);

			if (startingIx == -1 || result.contains(startingIx)) {
				i = i + 1;
				fromIndex = 0;
			} else if (temp.contains(words[i] + startingIx)) {
				i = i + 1;
				fromIndex = 0;
			} else {
				HashSet<Integer> usedIndices = new HashSet<>(words.length);
				usedIndices.add(i);
				temp.add(words[i] + startingIx);

				fromIndex = startingIx + wordLength;
				for (int j = fromIndex; j + wordLength <= s.length(); j += wordLength) {
					if (usedIndices.size() == words.length) {
						break;
					}

					String nextPiece = s.substring(j, j + wordLength);

					int existentWordIx = indexOf(words, nextPiece, usedIndices);
					if (existentWordIx != -1) {
						usedIndices.add(existentWordIx);
					} else {
						fromIndex = startingIx + 1;
						break;
					}
				}

				if (usedIndices.size() == words.length) {
					result.add(startingIx);
					fromIndex = startingIx + 1;
				}
			}
		}

		return new ArrayList<>(result);
	}

	private static Set<Integer> checkIfAllSame(String s, String[] words) {
		HashSet<Integer> result = new HashSet<>();

		int i = 0;
		String joined = String.join("", words);
		while (s.indexOf(joined, i) != -1) {
			result.add(i);
			i = i + joined.length();
		}

		return result;
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
