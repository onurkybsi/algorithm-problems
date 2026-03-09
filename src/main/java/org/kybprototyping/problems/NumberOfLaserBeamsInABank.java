package org.kybprototyping.problems;

final class NumberOfLaserBeamsInABank {
  private NumberOfLaserBeamsInABank() {}

  public int numberOfBeams(String[] bank) {
    int answer = 0;
    int i = 0;
    while (i < bank.length) {
      Pair p = nextRowWithDevices(bank, i);
      if (p.first == -1) {
        break;
      }

      int j = 0;
      while (j < bank[0].length()) {
        if (bank[i].charAt(j) == '1') {
          answer += p.second;
        }
        j++;
      }

      i = p.first;
    }
    return answer;
  }

  private static Pair nextRowWithDevices(String[] bank, int fromIx) {
    int nextRowWithDevices = -1;
    int numOfDevicesNextRow = -1;
    for (int i = fromIx + 1; i < bank.length; i++) {
      int _numOfDevicesNextRow = 0;
      for (int j = 0; j < bank[0].length(); j++) {
        if (bank[i].charAt(j) == '1') {
          _numOfDevicesNextRow++;
        }
      }
      if (_numOfDevicesNextRow != 0) {
        nextRowWithDevices = i;
        numOfDevicesNextRow = _numOfDevicesNextRow;
        break;
      }
    }
    return new Pair(nextRowWithDevices, numOfDevicesNextRow);
  }

  private record Pair(int first, int second) {
  }
}
