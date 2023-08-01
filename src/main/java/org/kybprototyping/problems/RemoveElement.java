package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import java.util.List;
import lombok.Data;

public class RemoveElement implements AlgorithmProblem<RemoveElement.RemoveElementArgs> {

  @Data
  public static class RemoveElementArgs {
    int[] nums;
    int val;
  }

  private static List<RemoveElementArgs> args =
      BootstrapHelper.getProblemArgs(RemoveElementArgs.class);

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }

  @Override
  public String getDescriptionLink() {
    return "https://leetcode.com/problems/remove-element/";
  }

  @Override
  public List<RemoveElementArgs> getProblemArgs() {
    return args;
  }

  @Override
  public void runSolution(int argsOrder) {
    RemoveElementArgs arg = args.get(argsOrder - 1);
    removeElement(arg.getNums(), arg.getVal());
  }

  private int removeElement(int[] nums, int val) {
    int i = 0;
    int j = nums.length - 1;
    while (i <= j) {
      if (nums[i] == val) {
        int t = nums[j];
        nums[j] = val;
        nums[i] = t;
        j--;
      } else {
        i++;
      }
    }
    return i;
  }

}
