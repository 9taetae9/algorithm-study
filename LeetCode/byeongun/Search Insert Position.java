package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    int i = searchInsert(new int[]{1,3,5,6}, 7);
    System.out.println("i = " + i);
  }

  public static int searchInsert(int[] nums, int target) {
    //아 찾는게 아니라 들어가야할 곳을 찾는 거구나
    int start = 0;
    int end = nums.length-1;
    int mid = 0;
    while(start <= end) {
      mid = start + (end - start)/2;
      if(nums[mid] < target) {
        start = mid + 1;
      }else {
        end = mid - 1;
      }
    }
    if( nums[mid] < target){
      return mid+1;
    }else {
      return mid;
    }
  }
}
