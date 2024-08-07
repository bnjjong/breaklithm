package week_8.keepbang;

import java.util.Arrays;

public class Fibbo {
  public static int[] memo;

  public static void main(String[] args) {

    int n = 7;

//    System.out.println("fibbo1(7) = " + fibbo1(n));

    memo = new int[n + 1];
    Arrays.fill(memo, -1);

    System.out.println("fibbo2(7) = " + fibbo2(n));

    System.out.println("fibbo3(n) = " + fibbo3(n));
  }

  public static int fibbo1(int n) {
    System.out.println("call fibbo1("+n+")");
    if (n <= 2) {
      return 1;
    } else  {
      return fibbo1(n - 1) + fibbo1(n - 2);
    }
  }


  public static int fibbo2(int n) {
    System.out.println("fibbo2("+n+")");
    if (memo[n] != -1) {
      return memo[n];
    }
    if (n <= 2) {
      memo[n] = 1;
    } else {
      memo[n] = fibbo2(n - 1) + fibbo2(n - 2);
    }

    return memo[n];
  }

  public static int fibbo3(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

}
