package org.kybprototyping.problems;

import java.util.HashMap;
import java.util.HashSet;

final class NumberOfProvinces {

  private NumberOfProvinces() {}

  private HashMap<Integer, Node> members;

  public int findCircleNum(int[][] isConnected) {
    this.members = new HashMap<>();

    int n = isConnected.length;
    for (int i = 0; i < n; i++) {
      makeSet(i);
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j && isConnected[i][j] == 1) {
          union(i, j);
        }
      }
    }

    HashSet<Node> representatives = new HashSet<>();
    for (var member : this.members.values()) {
      representatives.add(member.head);
    }
    return representatives.size();
  }

  private void makeSet(int value) {
    Node member = new Node(value);
    member.head = member;
    member.tail = member;
    member.size = 1;
    this.members.put(value, member);
  }

  private void union(int value1, int value2) {
    Node head1 = this.members.get(value1).head;
    Node head2 = this.members.get(value2).head;
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
    int value;
    Node next;
    Node head;
    Node tail; // representative only
    int size; // representative only

    Node(int value) {
      this.value = value;
    }
  }

}
