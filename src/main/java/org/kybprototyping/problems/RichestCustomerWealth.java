package org.kybprototyping.problems;

final class RichestCustomerWealth {
  private RichestCustomerWealth() {
  }

  public int maximumWealth(int[][] accounts) {
    int answer = Integer.MIN_VALUE;
    for (var customerAccounts : accounts) {
      int customerWealth = 0;
      for (int account : customerAccounts) {
        customerWealth += account;
      }
      answer = Math.max(answer, customerWealth);
    }
    return answer;
  }
}
