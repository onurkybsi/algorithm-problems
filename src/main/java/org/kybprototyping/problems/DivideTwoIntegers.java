package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;
import java.util.List;
import lombok.Data;

public class DivideTwoIntegers
    implements AlgorithmProblem<DivideTwoIntegers.DivideTwoIntegersArgs> {

  private static List<DivideTwoIntegersArgs> args =
      BootstrapHelper.getProblemArgs(DivideTwoIntegersArgs.class);

  @Data
  public static class DivideTwoIntegersArgs {
    private Integer dividend;
    private Integer divisor;
  }

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }

  @Override
  public String getDescriptionLink() {
    return "https://leetcode.com/problems/divide-two-integers/";
  }

  @Override
  public List<DivideTwoIntegersArgs> getProblemArgs() {
    return args;
  }

  @Override
  public void runSolution(int argsOrder) {
    DivideTwoIntegersArgs arg = args.get(argsOrder - 1);
    ConsoleUtils.INSTANCE.info(divide(arg.dividend, arg.divisor));
  }

  private int divide(int dividend, int divisor) {
    if (dividend == 0) {
      return 0;
    }

    boolean isDividendNegative = 0 - (long) dividend > 0;
    boolean isDivisorNegative = 0 - (long) divisor > 0;
    long absDividend = isDividendNegative ? 0 - (long) dividend : dividend;
    long absDivisor = isDivisorNegative ? 0 - (long) divisor : divisor;

    if (dividend == Integer.MIN_VALUE && absDivisor == 1) {
      return isDivisorNegative ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    } else if (absDivisor == 1) {
      return isDividendNegative != isDivisorNegative ? 0 - (int) absDividend : (int) absDividend;
    } else if (absDivisor == absDividend) {
      return isDividendNegative != isDivisorNegative ? -1 : 1;
    } else if (absDivisor > absDividend) {
      return 0;
    } else {
      int result = 0;

      while (absDividend > 0 && absDividend >= absDivisor) {
        absDividend -= absDivisor;
        result++;
      }

      return isDividendNegative != isDivisorNegative ? 0 - result : result;
    }
  }

}
