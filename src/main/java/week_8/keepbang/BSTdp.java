package week_8.keepbang;

public class BSTdp {

  public static void main(String[] args) {
    BSTdp dp = new BSTdp();
    System.out.println(dp.solution(10));

  }

  public int solution(int n) {
    int[] dp = new int[n + 1];

    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }

    for (int i : dp) {
      System.out.print(i + " ");
    }

    return dp[n];
  }

}
