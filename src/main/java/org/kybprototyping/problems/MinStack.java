package org.kybprototyping.problems;

final class MinStack {

  private static final int DEFAULT_CAPACITY = 10;
  private static final double GROWTH_RATE = 1.5;

  private int[] ds;
  private int size;

  private int min;

  MinStack() {
    ds = new int[DEFAULT_CAPACITY];
    size = 0;
    min = Integer.MAX_VALUE;
  }

  public void push(int val) {
    if (size == ds.length) {
      int[] _ds = new int[(int) Math.floor((double) size * GROWTH_RATE)];
      for (int i = 0; i < ds.length; i++) {
        _ds[i] = ds[i];
      }

      _ds[size++] = val;

      ds = _ds;
    } else {
      ds[size++] = val;
    }

    if (val < min) {
      min = val;
    }
  }

  public void pop() {
    int popped = ds[size - 1];

    ds[--size] = 0;

    if (min == popped) {
      int _min = Integer.MAX_VALUE;
      for (int i = size - 1; i >= 0; i--) {
        if (ds[i] < _min) {
          _min = ds[i];
        }
      }

      min = _min;
    }

    if (size == 0) {
      min = Integer.MAX_VALUE;
    }
  }

  public int top() {
    return ds[size - 1];
  }

  public int getMin() {
    return min;
  }

}
