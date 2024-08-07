package week_8.jshan;

import java.util.HashMap;
import java.util.Map;

public class FibboMemoization {
  private Map<Integer, Integer> memo;
  private int n2 = 0;
  private int n5 = 0;

  public FibboMemoization() {
    this.memo = new HashMap<>();
  }

  public int fibo(int n) {
    if (n == 2) {
      n2++;
    }
    if (n == 5) {
      n5++;
    }
    if (memo.containsKey(n)) {
      System.out.println("cache hit! >>>>" + n);
      return memo.get(n);
    }
    if (n <= 2) {
      memo.put(n, 1);
    } else {
      int value = fibo(n-1)+fibo(n-2);
      memo.put(n,value);
    }
    return memo.get(n);
  }

  public static void main(String[] args){
    FibboMemoization fiboMemo = new FibboMemoization();
    System.out.println(fiboMemo.fibo(7));
    System.out.printf("n5 : %d, n2 : %d", fiboMemo.n5, fiboMemo.n2);
  }
}
