package org.kybprototyping.problems;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class MinimumCostForTickets {

  private int[] days;
  private int[] costs;
  private int[][] memo;

  public int mincostTickets(int[] days, int[] costs) {
    this.days = days;
    this.costs = costs;
    this.memo = new int[days.length][394];
    return mincostTickets(0, 0);
  }

  private int mincostTickets(int dayIx, int lastTicketLastAvailableDay) {
    if (dayIx >= this.days.length) {
      return 0;
    }
    if (this.memo[dayIx][lastTicketLastAvailableDay] != 0) {
      return this.memo[dayIx][lastTicketLastAvailableDay];
    }

    int mincostTickets = 0;
    if (this.days[dayIx] <= lastTicketLastAvailableDay) {
      mincostTickets = mincostTickets(dayIx + 1, lastTicketLastAvailableDay);
    } else {
      // One-day
      mincostTickets = this.costs[0] + mincostTickets(dayIx + 1, this.days[dayIx]);
      // Seven-days
      if (this.costs[1] < mincostTickets) {
        mincostTickets = Math.min(mincostTickets,
            this.costs[1] + mincostTickets(dayIx + 1, this.days[dayIx] + 6));
      }
      // Thirty-days
      if (this.costs[2] < mincostTickets) {
        mincostTickets = Math.min(mincostTickets,
            this.costs[2] + mincostTickets(dayIx + 1, this.days[dayIx] + 29));
      }
    }

    this.memo[dayIx][lastTicketLastAvailableDay] = mincostTickets;
    return mincostTickets;
  }

}
