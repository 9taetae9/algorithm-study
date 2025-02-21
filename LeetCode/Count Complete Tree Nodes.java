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

    int count = 0;

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        count++;
        if( root.left != null ){
            countNodes(root.left);
        }
        if( root.right != null ){
            countNodes(root.right);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

    }
}
