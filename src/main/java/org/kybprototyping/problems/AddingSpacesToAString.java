package org.kybprototyping.problems;

final class AddingSpacesToAString {

  private AddingSpacesToAString() {}

  public String addSpaces(String s, int[] spaces) {
    StringBuilder b = new StringBuilder();
    int i = 0;
    for (int j = 0; j < spaces.length; j++) {
      b.append(s.substring(i, spaces[j]));
      b.append((char) 32);
      i = spaces[j];
    }
    b.append(s.substring(i, s.length()));
    return b.toString();
  }

}
