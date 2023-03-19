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
    int removedCount = 0;
    int i = 0;
    int j = nums.length - 1;

    while (i < nums.length - 1) {
      if (nums[i] == Integer.MIN_VALUE) {
        i++;
        if (i >= nums.length - 1) {
          break;
        }
      }

      if (nums[i] == nums[j] && nums[i] != Integer.MIN_VALUE) {
        nums[j] = Integer.MIN_VALUE;
        removedCount++;
      }
      if (j == i + 1) {
        i = nums[i + 1] == Integer.MIN_VALUE ? i + 2 : i + 1;
        j = nums.length - 1;
      } else {
        j--;
      }
    }

    for (int k = 0; k < removedCount; k++) {
      for (int l = 0; l < nums.length; l++) {
        if (nums[l] == Integer.MIN_VALUE && l + 1 != nums.length) {
          nums[l] = nums[l + 1];
          nums[l + 1] = Integer.MIN_VALUE;
        }
      }
    }

    return nums.length - removedCount;
  }

}
