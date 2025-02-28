package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //530. Minimum Absolute Difference in BST
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  public TreeNode sortedArrayToBST(int[] nums) {
    return bstToTree(nums, 0, nums.length - 1);
  }
  public TreeNode bstToTree(int[] nums, int start, int end) {
    if (start > end) { return null;}
    int mid = nums.length / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = bstToTree(nums, start, mid-1);
    root.right = bstToTree(nums, mid+1, end);
    return root;
  }


}
