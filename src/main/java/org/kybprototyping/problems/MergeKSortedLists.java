package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

final class MergeKSortedLists {

  private MergeKSortedLists() {}

  public static ListNode mergeKLists(ListNode[] lists) {
    var valueNodeMap = new LinkedHashMap<Integer, ArrayList<ListNode>>();
    for (ListNode list : lists) {
      put(valueNodeMap, list);
    }
    valueNodeMap = valueNodeMap.entrySet().stream()
        .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).collect(Collectors
            .toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    return buildMergedList(valueNodeMap);
  }

  private static ListNode buildMergedList(
      LinkedHashMap<Integer, ArrayList<ListNode>> valueNodeMap) {
    if (valueNodeMap.isEmpty()) {
      return null;
    }

    var nodeGroupIt = valueNodeMap.entrySet().iterator();
    ListNode next = null;
    while (nodeGroupIt.hasNext()) {
      var nodeGroup = nodeGroupIt.next().getValue();
      for (ListNode cur : nodeGroup) {
        cur.next = next;
        next = cur;
      }
    }
    return next;
  }

  private static void put(LinkedHashMap<Integer, ArrayList<ListNode>> valueNodeMap,
      ListNode listToAdd) {
    var cur = listToAdd;
    while (cur != null) {
      var value = cur.val;
      var nodesWithValues = valueNodeMap.getOrDefault(value, new ArrayList<>());
      nodesWithValues.add(cur);
      valueNodeMap.put(value, nodesWithValues);

      cur = cur.next;
    }
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
