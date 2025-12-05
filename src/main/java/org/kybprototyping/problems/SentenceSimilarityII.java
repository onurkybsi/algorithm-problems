package org.kybprototyping.problems;

import java.util.HashMap;
import java.util.List;

final class SentenceSimilarityII {

  private SentenceSimilarityII() {}

  private HashMap<String, Node> members;

  public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2,
      List<List<String>> similarPairs) {
    if (sentence1.length != sentence2.length) {
      return false;
    }
    this.members = new HashMap<>();

    for (var similarPair : similarPairs) {
      String word1 = similarPair.get(0);
      String word2 = similarPair.get(1);

      Node head1 = this.members.getOrDefault(word1, Node.makeSet()).head;
      this.members.put(word1, head1);

      Node head2 = this.members.getOrDefault(word2, Node.makeSet()).head;
      this.members.put(word2, head2);

      union(head1, head2);
    }

    for (int i = 0; i < sentence1.length; i++) {
      String word1 = sentence1[i];
      String word2 = sentence2[i];

      Node head1 = this.members.getOrDefault(word1, Node.makeSet()).head;
      this.members.put(word1, head1);

      Node head2 = this.members.getOrDefault(word2, Node.makeSet()).head;
      this.members.put(word2, head2);


      if (head1 != head2) {
        return false;
      }
    }
    return true;
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
    Node next;
    Node head;
    Node tail; // head only
    int size; // head only

    static Node makeSet() {
      Node member = new Node();
      member.head = member;
      member.tail = member;
      member.size = 1;
      return member;
    }
  }

}
