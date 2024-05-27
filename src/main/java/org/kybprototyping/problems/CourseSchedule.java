package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings({"java:S3824"})
final class CourseSchedule {

  private CourseSchedule() {}

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    var coursesWithPrerequisites =
        buildCoursesWithPrerequisites(numCourses, prerequisites).entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> entry.getValue().size())).collect(Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    HashSet<Integer> canBeTaken = new HashSet<>();
    for (int i = 0; i < numCourses; i++) {
      for (var course : coursesWithPrerequisites.entrySet()) {
        if (!canBeTaken.contains(course.getKey())
            && course.getValue().stream().allMatch(canBeTaken::contains)) {
          canBeTaken.add(course.getKey());
        }
      }
    }

    return canBeTaken.size() == numCourses;
  }

  private static HashMap<Integer, List<Integer>> buildCoursesWithPrerequisites(int numCourses,
      int[][] prerequisites) {
    var coursesWithPrerequisites = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < prerequisites.length; i++) {
      var course = prerequisites[i][0];
      var prerequisite = prerequisites[i][1];
      var coursePrerequisites = coursesWithPrerequisites.getOrDefault(course, new ArrayList<>());
      coursePrerequisites.add(prerequisite);
      coursesWithPrerequisites.put(course, coursePrerequisites);
    }
    for (int i = 0; i < numCourses; i++) {
      if (!coursesWithPrerequisites.containsKey(i)) {
        coursesWithPrerequisites.put(i, new ArrayList<>());
      }
    }
    return coursesWithPrerequisites;
  }

}
