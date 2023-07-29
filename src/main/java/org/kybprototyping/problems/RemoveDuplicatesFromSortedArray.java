package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import java.util.List;
import lombok.Data;

public class RemoveDuplicatesFromSortedArray implements
    AlgorithmProblem<RemoveDuplicatesFromSortedArray.RemoveDuplicatesFromSortedArrayArgs> {

  @Data
  public static class RemoveDuplicatesFromSortedArrayArgs {
    private int[] nums;
  }

  private static List<RemoveDuplicatesFromSortedArrayArgs> args =
      BootstrapHelper.getProblemArgs(RemoveDuplicatesFromSortedArrayArgs.class);

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }

  @Override
  public String getDescriptionLink() {
    return "https://leetcode.com/problems/remove-duplicates-from-sorted-array/";
  }

  @Override
  public List<RemoveDuplicatesFromSortedArrayArgs> getProblemArgs() {
    return args;
  }

  @Override
  public void runSolution(int argsOrder) {
    RemoveDuplicatesFromSortedArrayArgs arg = args.get(argsOrder - 1);
    removeDuplicates(arg.getNums());
  }

  private int removeDuplicates(int[] nums) {
    int i = 0;
    int j = i + 1;

    while (j < nums.length) {
      if (nums[j] > nums[i]) {
        int t = nums[i + 1];
        nums[i + 1] = nums[j];
        nums[j] = t;

        i++;
        j = i + 1;
      } else {
        j++;
      }
    }

    return i + 1;
  }
}
