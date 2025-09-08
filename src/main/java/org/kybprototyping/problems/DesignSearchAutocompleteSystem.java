package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class DesignSearchAutocompleteSystem {

  static class AutocompleteSystem {

    private final ArrayList<Tuple> tuples;
    private StringBuilder typed = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
      ArrayList<Tuple> tuples = new ArrayList<>(sentences.length);
      for (int i = 0; i < sentences.length; i++) {
        tuples.add(new Tuple(sentences[i], times[i]));
      }
      this.tuples = tuples;
      this.sort();
    }

    public List<String> input(char c) {
      if (c == '#') {
        var sentenceTyped = this.typed.toString();
        var existingTuple =
            this.tuples.stream().filter(t -> t.sentence.equals(sentenceTyped)).findFirst();
        if (existingTuple.isPresent()) {
          this.tuples.remove(existingTuple.get());
          this.tuples.add(new Tuple(sentenceTyped, existingTuple.get().times + 1));
        } else {
          this.tuples.add(new Tuple(sentenceTyped, 1));
        }
        this.sort();

        this.typed = new StringBuilder();

        return Collections.emptyList();
      } else {
        this.typed.append(c);
        return findHottestThree(this.typed.toString());
      }
    }

    private void sort() {
      this.tuples.sort((t1, t2) -> {
        if (t1.times > t2.times) {
          return -1;
        } else if (t2.times > t1.times) {
          return 1;
        } else {
          return t1.sentence.compareTo(t2.sentence);
        }
      });
    }

    private List<String> findHottestThree(String prefix) {
      return this.tuples.stream().filter(t -> t.sentence.startsWith(prefix)).limit(3)
          .map(t -> t.sentence()).toList();
    }

    private record Tuple(String sentence, int times) {
    }

  }

}
