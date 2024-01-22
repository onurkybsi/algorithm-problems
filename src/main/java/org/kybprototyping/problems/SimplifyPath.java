package org.kybprototyping.problems;

import java.util.ArrayList;

final class SimplifyPath {

  private static final char SLASH = '/';

  private SimplifyPath() {}

  public static String simplifyPath(String path) {
    ArrayList<String> parts = new ArrayList<>();
    for (int i = 1; i < path.length();) {
      if (path.charAt(i) == SLASH) {
        i++;
        continue;
      }

      StringBuilder partBuilder = new StringBuilder();
      while (i < path.length() && path.charAt(i) != SLASH) {
        partBuilder.append(path.charAt(i));
        i++;
      }
      String part = partBuilder.toString();

      if ("..".equals(part) && !parts.isEmpty()) {
        parts.remove(parts.size() - 1);
      } else if (!".".equals(part) && !"..".equals(part)) {
        parts.add(part);
      }
    }

    if (parts.isEmpty()) {
      return "/";
    } else {
      StringBuilder canonicalPath = new StringBuilder();
      for (String part : parts) {
        canonicalPath.append(SLASH);
        canonicalPath.append(part);
      }
      return canonicalPath.toString();
    }
  }

}
