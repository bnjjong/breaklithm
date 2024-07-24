package week_7.keepbang;

import java.util.Arrays;

public class HeapAlgorithm {

  public static void main(String[] args) {
    int[] arr = {0, 9, 7, 4, 5, 3, 2, 1};
    HeapAlgorithm heapAlgorithm = new HeapAlgorithm();
    heapAlgorithm.build_heap(arr, arr.length);

    print(arr);

    arr = heapAlgorithm.insert(arr, arr.length, 8);
    print(arr);

    arr = heapAlgorithm.remove(arr, arr.length);

    print(arr);

  }

  private static void print(int[] arr) {
    Arrays.stream(arr)
        .forEach(i -> System.out.print(i + " "));
    System.out.println();
  }

  public void build_heap(int[] arr, int n) {
    for (int i = n / 2; i >= 1; i--) {
      heapify(arr, n, i);
    }
  }

  public void heapify(int[] arr, int n, int i) {
    int largest = i;

    int left = i * 2;
    int right = i * 2 + 1;

    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }
    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, n, largest);
    }
  }

  private void swap(int[] arr, int i, int largest) {
    int temp = arr[i];
    arr[i] = arr[largest];
    arr[largest] = temp;
  }

  public int[] insert(int[] arr, int n, int x) {
    // n + 1만큼 배열을 복사함
    int[] result = Arrays.copyOf(arr, n + 1);

    // 가장 마지막 위치에 값 입력
    result[n] = x;

    // 마지막 노드에서 시작함.
    int i = result.length - 1;

    // 부모가 자식보다 작은 경우
    while (i > 1 && result[i / 2] < result[i]) {
      swap(result, i, i / 2);
      i = i / 2;
    }

    return result;
  }

  public int[] remove(int[] arr, int n) {
    arr[1] = arr[n - 1];
    int[] result = Arrays.copyOf(arr, n - 1);
    heapify(result, result.length, 1);
    return result;
  }


}
