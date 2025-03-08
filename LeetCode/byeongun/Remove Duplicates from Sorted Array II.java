package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //Remove Duplicates from Sorted Array II
    removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
  }

  public static int removeDuplicates(int[] nums) {
    //정렬된 배열에서 중복 제거 2번까지는 혀용 // 2번 이상 중복된 원소라도 한 번만 제거함 // 새로운 배열 생성 X
    //2개 이상 중복된 수는 뒤로 보내고 뒤에 수가 작은 수가 발견되면 뒤는 _ 로 출력?
    int result = nums.length;
    boolean duplicate = false;
    int afternum = 1;
    //이게 3개 변수가 필요한 듯한데 이전 수, 다음 수 (매번 불러오자)
    for (int i = 0; i < nums.length - 2; i++) {
      if (afternum >= nums.length) {
        return result;
      }
      if (nums[i] == nums[i + 1] && !duplicate) { //처음 발견
        duplicate = true;
      } else if (nums[i + 1] == nums[i] && duplicate) { //두번 쨰 이상 발견
        result--;
        afternum++;
      } else { //처음 발견
        duplicate = false;
      }
      afternum++;

    }
    return result;
  }


  public static int removeDuplicatesSolution(int[] nums) {
    if (nums.length <= 2) {
      return nums.length; // 배열 길이가 2 이하이면 그대로 반환
    }

    int slow = 1; // 두 번째 요소부터 시작
    int count = 1; // 현재 숫자의 등장 횟수 카운트

    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[fast] == nums[fast - 1]) {
        count++; // 중복 발견
      } else {
        count = 1; // 새로운 숫자 등장 시 초기화
      }

      if (count <= 2) {
        nums[slow] = nums[fast]; // 현재 숫자를 저장
        slow++;
      }
    }

    return slow; // 중복을 제거한 후의 길이 반환
  }


}
