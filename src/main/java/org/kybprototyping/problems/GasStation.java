package org.kybprototyping.problems;

final class GasStation {

  private GasStation() {}

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int i = 0;
    while (i >= 0 && i < gas.length) {
      var status = canCompleteCircuit(i, gas, cost);
      if (status.isCircuitCompleted) {
        return status.curStationIx;
      }
      if (status.curStationIx < i) {
        return -1;
      }

      i = status.curStationIx == i ? i + 1 : status.curStationIx;
    }
    return -1;
  }

  private static CarStatus canCompleteCircuit(int curStationIx, int[] gas, int[] cost) {
    int curGas = gas[curStationIx];

    int i = 0;
    while (i < gas.length) {
      int nextStationCost = cost[curStationIx];

      if (curGas < nextStationCost) {
        return new CarStatus(false, curStationIx);
      } else {
        int nextStationIx = curStationIx + 1 == gas.length ? 0 : curStationIx + 1;
        int nextStationGas = gas[nextStationIx];
        curGas = curGas - nextStationCost + nextStationGas;
        curStationIx = nextStationIx;
        i++;
      }
    }

    return new CarStatus(true, curStationIx);
  }

  private record CarStatus(boolean isCircuitCompleted, int curStationIx) {
  }

}
