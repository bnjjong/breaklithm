package week_8.keepbang;

import java.util.Arrays;

public class Padovan {

  public static void main(String[] args) {
    Padovan padovan = new Padovan();
    System.out.println("padovan = " + padovan.solution(10));
  }

  public int solution(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return padovan(memo, n);
  }

  public int padovan(int[] memo, int n) {
    System.out.println("padovan("+n+")");
    if (memo[n] != -1) {
      return memo[n];
    }
    if (n <= 3) {
      memo[n] = 1;
    } else {
      memo[n] = padovan(memo, n - 2) + padovan(memo, n - 3);
      System.out.println(memo[n]);
    }
    return memo[n];
  }

}
