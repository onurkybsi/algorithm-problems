package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

final class CloneGraph {

  private CloneGraph() {}

  public static Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }

    HashMap<Integer, Node> allNodes = extractAllNodes(node);
    HashMap<Integer, Node> copies = new HashMap<>(allNodes.size());
    for (var val : allNodes.keySet()) {
      copies.put(val, new Node(val));
    }
    for (var original : allNodes.entrySet()) {
      var originalNeighbors = original.getValue().neighbors;
      var copyNeighbors = new ArrayList<Node>(originalNeighbors.size());
      for (var neighbor : originalNeighbors) {
        copyNeighbors.add(copies.get(neighbor.val));
      }
      copies.get(original.getKey()).neighbors = copyNeighbors;
    }

    return copies.get(node.val);
  }

  private static HashMap<Integer, Node> extractAllNodes(Node source) {
    HashMap<Integer, Node> nodes = new HashMap<>();
    Queue<Node> temp = new LinkedList<>();
    temp.add(source);
    while (!temp.isEmpty()) {
      var cur = temp.remove();
      nodes.put(cur.val, cur);

      for (Node neighbor : cur.neighbors) {
        if (!nodes.containsKey(neighbor.val)) {
          temp.add(neighbor);
        }
      }
    }
    return nodes;
  }

  static class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

}
