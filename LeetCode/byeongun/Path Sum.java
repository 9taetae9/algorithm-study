package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TodayAlgorithm {
    static class TreeNode {
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

    int sum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        sum += root.val;
        if (root.left != null){
            if(hasPathSum(root.left, targetSum)){
                return true;
            }else {
                sum -= root.left.val;
            }
        }
        if (root.right != null){
            if(hasPathSum(root.right, targetSum)){
                return true;
            }else {
                sum -= root.right.val;
            }
        }
        if(root.left == null && root.right == null){
            return sum == targetSum;
        }else {
            return false;
        }

    }

    public static void main(String[] args) throws IOException {

    }
}
