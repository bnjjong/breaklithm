package week_8.keepbang;

import java.util.Arrays;

public class TileDP {

  public static void main(String[] args) {
    TileDP dp = new TileDP();
    dp.solution2(7);
  }

  public int solution(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    Arrays.stream(dp)
        .forEach(i -> System.out.print(i + " "));

    return dp[n];
  }

  public int solution2(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + 2 * dp[i - 2];
    }

    Arrays.stream(dp)
        .forEach(i -> System.out.print(i + " "));

    return dp[n];
  }

}
