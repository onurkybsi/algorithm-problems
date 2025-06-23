package org.kybprototyping.problems;

import java.util.HashMap;

final class SimilarRGBColor {

  private static HashMap<String, Integer> shorthandNums = new HashMap<>();
  static {
    shorthandNums.put("00", 0x00);
    shorthandNums.put("11", 0x11);
    shorthandNums.put("22", 0x22);
    shorthandNums.put("33", 0x33);
    shorthandNums.put("44", 0x44);
    shorthandNums.put("55", 0x55);
    shorthandNums.put("66", 0x66);
    shorthandNums.put("77", 0x77);
    shorthandNums.put("88", 0x88);
    shorthandNums.put("99", 0x99);
    shorthandNums.put("aa", 0xaa);
    shorthandNums.put("bb", 0xbb);
    shorthandNums.put("cc", 0xcc);
    shorthandNums.put("dd", 0xdd);
    shorthandNums.put("ee", 0xee);
    shorthandNums.put("ff", 0xff);
  }

  private SimilarRGBColor() {}

  public String similarRGB(String color) {
    StringBuilder similarRGB = new StringBuilder("#");
    for (int i = 1; i < color.length() - 1; i += 2) {
      similarRGB.append(nearestOf(color.substring(i, i + 2)));
    }
    return similarRGB.toString();
  }

  private static String nearestOf(String hex) {
    int decimal = Integer.parseInt(hex, 16);
    String nearest = null;
    int min = Integer.MAX_VALUE;
    for (var num : shorthandNums.entrySet()) {
      if (min > Math.abs(decimal - num.getValue())) {
        min = Math.abs(decimal - num.getValue());
        nearest = num.getKey();
      }
    }
    return nearest;
  }

}
