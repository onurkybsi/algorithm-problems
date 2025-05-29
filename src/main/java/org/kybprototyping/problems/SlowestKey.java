package org.kybprototyping.problems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

final class SlowestKey {

  private SlowestKey() {}

  public char slowestKey(int[] releaseTimes, String keysPressed) {
    Queue<Character> temp = new PriorityQueue<>(Collections.reverseOrder());
    temp.add(keysPressed.charAt(0));
    int max = releaseTimes[0];
    for (int i = 1; i < keysPressed.length(); i++) {
      int duration = releaseTimes[i] - releaseTimes[i - 1];

      if (duration > max) {
        temp.clear();
        temp.add(keysPressed.charAt(i));
        max = duration;
      } else if (duration == max) {
        temp.add(keysPressed.charAt(i));
      }
    }

    return temp.peek();
  }

}
