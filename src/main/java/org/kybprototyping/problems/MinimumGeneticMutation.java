package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

final class MinimumGeneticMutation {

  private MinimumGeneticMutation() {}

  public static int minMutation(String startGene, String endGene, String[] bank) {
    return Optional.ofNullable(bfs(buildGraph(startGene, endGene, bank), startGene, endGene))
        .map(path -> path.size() - 1).orElse(-1);
  }

  private static ArrayList<String> bfs(HashMap<String, List<String>> graph, String source,
      String target) {
    var visited = new HashSet<String>();
    var temp = new LinkedList<ArrayList<String>>();
    temp.add(new ArrayList<>(List.of(source)));
    while (!temp.isEmpty()) {
      var curPath = temp.remove();
      var cur = curPath.get(curPath.size() - 1);
      if (cur.equals(target)) {
        return curPath;
      }

      var adjacencies = graph.get(cur);
      for (String adjacency : adjacencies) {
        if (!visited.contains(adjacency)) {
          var anotherPath = new ArrayList<>(curPath);
          anotherPath.add(adjacency);
          temp.add(anotherPath);
        }
      }

      visited.add(cur);
    }
    return null;
  }

  private static HashMap<String, List<String>> buildGraph(String startGene, String endGene,
      String[] bank) {
    var graph = new HashMap<String, List<String>>();
    var startGeneAdjacencies = extractAdjacencies(startGene, bank);
    graph.put(startGene, startGeneAdjacencies);
    graph.put(endGene, Collections.emptyList());
    for (String geneInBank : bank) {
      graph.put(geneInBank, extractAdjacencies(geneInBank, bank));
    }
    return graph;
  }

  private static ArrayList<String> extractAdjacencies(String gene, String[] bank) {
    var adjacencies = new ArrayList<String>();
    for (String geneInBank : bank) {
      if (!isThereOtherThanOneCharDifference(gene, geneInBank)) {
        adjacencies.add(geneInBank);
      }
    }
    return adjacencies;
  }

  private static boolean isThereOtherThanOneCharDifference(String gene, String anotherGene) {
    if (gene.equals(anotherGene)) {
      return true;
    }

    int geneLength = gene.length();
    int differenceCount = 0;
    for (int i = 0; i < geneLength; i++) {
      if (gene.charAt(i) != anotherGene.charAt(i)) {
        differenceCount++;
      }
      if (differenceCount > 1) {
        return true;
      }
    }
    return differenceCount != 1;
  }

}
