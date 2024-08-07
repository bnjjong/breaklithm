package week_8.jshan;

public class Fibbo {
  private int n2 = 0;
  private int n5 = 0;

  public int fibo(int n) {
    if (n == 2) {
      n2++;
    }
    if (n == 5) {
      n5++;
    }
    if (n <= 2) {
      return 1;
    } else {
      return fibo(n-1) + fibo(n-2);
    }
  }

  public static void main(String[] args){
    Fibbo fibbo = new Fibbo();
    System.out.println(fibbo.fibo(7));
    System.out.printf("n5 : %d, n2 : %d", fibbo.n5, fibbo.n2);
  }
}
