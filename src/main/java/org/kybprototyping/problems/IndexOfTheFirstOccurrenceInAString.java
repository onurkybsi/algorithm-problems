package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;
import java.util.List;
import lombok.Data;

public class IndexOfTheFirstOccurrenceInAString implements
    AlgorithmProblem<IndexOfTheFirstOccurrenceInAString.IndexOfTheFirstOccurrenceInAStringArgs> {
  private static List<IndexOfTheFirstOccurrenceInAStringArgs> args =
      BootstrapHelper.getProblemArgs(IndexOfTheFirstOccurrenceInAStringArgs.class);

  @Data
  public static class IndexOfTheFirstOccurrenceInAStringArgs {
    private String haystack;
    private String needle;
  }

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }

  @Override
  public String getDescriptionLink() {
    return "https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/";
  }

  @Override
  public List<IndexOfTheFirstOccurrenceInAStringArgs> getProblemArgs() {
    return args;
  }

  @Override
  public void runSolution(int argsOrder) {
    IndexOfTheFirstOccurrenceInAStringArgs arg = args.get(argsOrder - 1);
    ConsoleUtils.INSTANCE.info(strStr(arg.haystack, arg.needle));
  }

  private int strStr(String haystack, String needle) {
    int i = 0;
    int j = i;
    int c = 0;
    while (haystack.length() - i + c >= needle.length()) {
      if (haystack.charAt(i) == needle.charAt(i - j)) {
        c++;
        i++;

        if (c >= needle.length()) {
          return j;
        }
      } else {
        i = j + 1;
        j = i;
        c = 0;
      }
    }
    return -1;
  }

}
