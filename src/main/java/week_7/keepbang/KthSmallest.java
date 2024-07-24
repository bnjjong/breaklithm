package week_7.keepbang;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description
 */
public class KthSmallest {

  public static void main(String[] args) {
    KthSmallest solution = new KthSmallest();
    int[][] matrix1 = {
        {1, 5, 9},
        {10, 11, 13},
        {12, 13, 15}
    };
    int k1 = 8;
    System.out.println(solution.kthSmallest(matrix1, k1));  // Output: 13
  }

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    // 최소 힙 (value를 기준으로 최소힙을 만들어야함)
    PriorityQueue<Element> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

    // Add the first element of each row to the heap
    for (int i = 0; i < n; i++) {
      queue.offer(new Element(matrix[i][0], i, 0));
    }

    // Extract-min k-1 times
    for (int i = 0; i < k - 1; i++) {
      Element current = queue.poll();
      if (current.col < n - 1) {
        queue.offer(new Element(
            matrix[current.row][current.col + 1],
            current.row,
            current.col + 1));
      }
    }

    // The k-th smallest element
    return queue.poll().value;

  }

  static class Element {
    int value; // 값
    int row; // 행
    int col; // 열

    Element(int value, int row, int col) {
      this.value = value;
      this.row = row;
      this.col = col;
    }
  }

}
