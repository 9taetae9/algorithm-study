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
  Integer minDiff = Integer.MAX_VALUE;
  Integer preValue = null;

  public int getMinimumDifference2(TreeNode root) {
    circulation(root);
    return minDiff;
  }

  public void circulation(TreeNode node) {
    if (node == null) return;
    circulation(node.left);
    if (preValue != null) {
      minDiff = Math.min(minDiff, node.val - preValue);
    }
    preValue = node.val;
    circulation(node.right);
  }

  public static int getMinimumDifference(TreeNode root) {
    //자식이 있을거면 2개 있던가 아니면 없던가
    //뎁스도 맞아야 함
    if(root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int leftDepth = 0;
    int rightDepth = 0;
    while(!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if(node.left != null && node.right == null) { return 0;}
      else if(node.right != null && node.left == null) { return 0;}
      if(node.left != null) {
        queue.add(node.left);
        leftDepth++;
      }
      if(node.right != null){
        queue.add(node.right);
        rightDepth++;
      }
      if(leftDepth - rightDepth > 1) { return 0;}
    }
    return 1;
  }


}
