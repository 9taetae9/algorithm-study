import java.util.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    int[] solution = solution(
      new String[]{"muzi", "frodo", "apeach", "neo"},
      new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
      2
    );
    for (int i : solution) {
      System.out.println("i = " + i);
    }
  }

  public static int[] solution(String[] id_list, String[] report, int k) {
    Map<String, Set<String>> reportMap = new HashMap<>();
    Map<String, Integer> reportCount = new HashMap<>();

    for (String s : report) {
      String[] parts = s.split(" ");
      String from = parts[0];
      String to = parts[1];

      reportMap.putIfAbsent(from, new HashSet<>());
      if (reportMap.get(from).add(to)) {
        reportCount.put(to, reportCount.getOrDefault(to, 0) + 1);
      }
    }

    Map<String, Integer> resultMap = new HashMap<>();
    for (String user : id_list) resultMap.put(user, 0);

    for (String from : reportMap.keySet()) {
      for (String to : reportMap.get(from)) {
        if (reportCount.getOrDefault(to, 0) >= k) {
          resultMap.put(from, resultMap.get(from) + 1);
        }
      }
    }
    
    int[] answer = new int[id_list.length];
    for (int i = 0; i < id_list.length; i++) {
      answer[i] = resultMap.get(id_list[i]);
    }

    return answer;
  }
}
