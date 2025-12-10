package org.kybprototyping.problems;

import java.util.HashMap;
import java.util.List;

final class EmployeeImportance {

  private EmployeeImportance() {}

  public int getImportance(List<Employee> employees, int id) {
    var employeesMap = new HashMap<Integer, Employee>();
    for (var employee : employees) {
      employeesMap.put(employee.id, employee);
    }
    return getImportance(employeesMap, id);
  }

  private static int getImportance(HashMap<Integer, Employee> employeeMap, int id) {
    int importance = employeeMap.get(id).importance;
    for (var subordinate : employeeMap.get(id).subordinates) {
      importance += getImportance(employeeMap, subordinate);
    }
    return importance;
  }

  private static class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
  };
}
