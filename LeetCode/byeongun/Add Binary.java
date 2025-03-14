package org.example;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

class TodayAlgorithm {

  public static void main(String[] args) throws IOException {
    //Add Binary
    String s = addBinary("11", "1");
    System.out.println("s = " + s);
  }
  public static String addBinary(String a, String b) {
    return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
  }



}
