package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

final class EvaluateDivision {

  private EvaluateDivision() {}

  public static double[] calcEquation(List<List<String>> equations, double[] values,
      List<List<String>> queries) {
    var graph = buildGraph(equations, values);

    double[] result = new double[queries.size()];
    for (int i = 0; i < result.length; i++) {
      var query = queries.get(i);
      if (!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1)))
        result[i] = -1;
      else if (query.get(0).equals(query.get(1)))
        result[i] = 1;
      else
        result[i] = calculate(graph, queries.get(i));
    }

    return result;
  }

  private static double calculate(HashMap<String, ArrayList<Target>> graph, List<String> query) {
    var source = query.get(0);
    var target = query.get(1);

    var visited = new HashSet<String>();
    var temp = new LinkedList<ArrayList<Target>>();
    temp.add(new ArrayList<>(List.of(new Target(source, 1))));
    while (!temp.isEmpty()) {
      var curPath = temp.remove();
      var cur = curPath.get(curPath.size() - 1);
      if (cur.variable.equals(target)) {
        return calculate(curPath);
      }
      visited.add(cur.variable);

      var neighbors = graph.get(cur.variable);
      for (Target neighbor : neighbors) {
        if (!visited.contains(neighbor.variable)) {
          var newPath = new ArrayList<>(curPath);
          newPath.add(neighbor);
          temp.add(newPath);
        }
      }
    }

    return -1;
  }

  private static double calculate(ArrayList<Target> curPath) {
    double result = 1;
    for (Target target : curPath) {
      result *= target.value;
    }
    return result;
  }

  private static HashMap<String, ArrayList<Target>> buildGraph(List<List<String>> equations,
      double[] values) {
    var graph = new HashMap<String, ArrayList<Target>>();
    for (int i = 0; i < equations.size(); i++) {
      var equation = equations.get(i);
      addToGraph(graph, equation.get(0), equation.get(1), values[i]);
      addToGraph(graph, equation.get(1), equation.get(0), 1 / values[i]);
    }
    return graph;
  }

  private static void addToGraph(HashMap<String, ArrayList<Target>> graph, String source,
      String target, double value) {
    var targets = graph.getOrDefault(source, new ArrayList<>());
    targets.add(new Target(target, value));
    graph.put(source, targets);
  }

  private static record Target(String variable, double value) {
  }

}
