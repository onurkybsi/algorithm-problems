package org.kybprototyping.problems;

import java.util.Arrays;
import java.util.HashMap;

final class TheEarliestMomentWhenEveryoneBecomeFriends {

  private TheEarliestMomentWhenEveryoneBecomeFriends() {}

  private HashMap<Integer, Node> members;

  public int earliestAcq(int[][] logs, int n) {
    this.members = new HashMap<>();
    for (int i = 0; i < n; i++) {
      this.members.put(i, makeSet(i));
    }

    Arrays.sort(logs, (l1, l2) -> Integer.compare(l1[0], l2[0]));
    for (int i = 0; i < logs.length; i++) {
      int member1Val = logs[i][1];
      int member2Val = logs[i][2];
      Node head = union(member1Val, member2Val);
      if (head.size == n) {
        return logs[i][0];
      }
    }
    return -1;
  }

  private Node union(int member1Val, int member2Val) {
    Node member1 = this.members.get(member1Val);
    Node member2 = this.members.get(member2Val);
    if (member1.head.value == member2.head.value) {
      return member1.head;
    } else if (member1.head.size > member2.head.size) {
      add(member2.head, member1.head);
      return member1.head;
    } else {
      add(member1.head, member2.head);
      return member2.head;
    }
  }

  private static Node makeSet(int value) {
    Node member = new Node(value);
    member.head = member;
    member.tail = member;
    member.size = 1;
    return member;
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

  private static final class Node {
    int value;
    Node next;
    Node head;
    Node tail; // Head only
    int size; // Head only

    Node(int value) {
      this.value = value;
    }
  }

}
