package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
        "Enter uid1234 Prodo", "Change uid4567 Ryan"});
  }
  public static String[] solution(String[] record) {
    Map<String, String> id = new HashMap<>();
    List<String> list = new ArrayList<>();
    for (int i = 0; i < record.length; i++) {
      if( record[i].contains("Enter")){
        String[] split = record[i].split(" ");
        id.put(split[1], split[2]);

        list.add(split[1]+"-님이 들어왔습니다.");
      }
      else if(record[i].contains("Leave")){
        String[] split = record[i].split(" ");

        list.add(split[1]+"-님이 나갔습니다.");
      }
      else if(record[i].contains("Change")){
        String[] split = record[i].split(" ");
        id.replace(split[1], split[2]);
      }
    }
    List<String> newList = new ArrayList<>();
    for(int i = 0; i < list.size(); i++){
      String s = list.get(i);
      String[] split = s.split("-");
      newList.add(id.get(split[0])+split[1]);
    }
    return newList.toArray(new String[list.size()]);
  }
}
