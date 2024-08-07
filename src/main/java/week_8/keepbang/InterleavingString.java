package week_8.keepbang;

/**
 * i/j0	1	2	3	4	5
 * 0	T	F	F	F	F	F
 * 1	T	T	T	T	F	F
 * 2	T	T	T	T	T	T
 * 3	F	T	T	T	T	T
 * 4	F	F	T	T	T	T
 * 5	F	F	F	T	T	T
 */
public class InterleavingString {
  public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length();
    int n = s2.length();

    if (m + n != s3.length()) {
      return false;
    }

    // dp table 초기화
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        System.out.println("i = " + i);
        System.out.println("j = " + j);

        if (i > 0) {
          dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
          System.out.println("s1.charAt(i - 1) = " + s1.charAt(i - 1));
          System.out.println("s3.charAt(i + j - 1) = " + s3.charAt(i + j - 1));
        }
        if (j > 0) {
          dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(j + i - 1));
          System.out.println("s2.charAt(j - 1) = " + s2.charAt(j - 1));
          System.out.println("s3.charAt(j + i - 1) = " + s3.charAt(j + i - 1));
        }

        System.out.println("dp[i][j] = " + dp[i][j]);

        System.out.println("---------------------------------");


      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    InterleavingString solution = new InterleavingString();
    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbcbcac";
    System.out.println("result = " + solution.isInterleave(s1, s2, s3)); // Output: true

    s3 = "aadbbbaccc";
    System.out.println("result = " + solution.isInterleave(s1, s2, s3)); // Output: false
  }
}
