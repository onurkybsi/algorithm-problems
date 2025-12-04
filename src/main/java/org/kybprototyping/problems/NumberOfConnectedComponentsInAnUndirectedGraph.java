package org.kybprototyping.problems;

import java.util.HashMap;
import java.util.HashSet;

final class NumberOfConnectedComponentsInAnUndirectedGraph {

  private NumberOfConnectedComponentsInAnUndirectedGraph() {}

  private HashMap<Integer, Node> members;

  public int countComponents(int n, int[][] edges) {
    this.members = new HashMap<>();

    for (int i = 0; i < n; i++) { // makeSet()
      Node member = new Node();
      member.head = member;
      member.tail = member;
      member.size = 1;
      members.put(i, member);
    }

    for (int[] edge : edges) { // union()
      Node head1 = this.members.get(edge[0]).head;
      Node head2 = this.members.get(edge[1]).head;
      union(head1, head2);
    }

    HashSet<Node> heads = new HashSet<>();
    for (var member : this.members.values()) { // Count num of disjoint sets
      heads.add(member.head);
    }
    return heads.size();
  }

  private static void union(Node head1, Node head2) {
    if (head1 == head2) {
      return;
    }
    if (head1.size > head2.size) {
      add(head2, head1);
      return;
    }
    add(head1, head2);
  }

  private static void add(Node from, Node to) {
    to.tail.next = from;
    to.tail = from.tail;
    to.size += from.size;
    Node cur = from;
    while (cur != null) {
      cur.head = to;
      cur.tail = null;
      cur.size = 0;
      cur = cur.next;
    }
  }

  private static class Node {
    private Node next;
    private Node head;
    private Node tail;
    private int size;
  }

}
