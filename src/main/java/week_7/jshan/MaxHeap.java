package week_7.jshan;

public class MaxHeap {
  private int[] heap;
  private int size;
  private int capacity;

  public MaxHeap(int[] heap) {
    this.heap = heap;
    this.size = heap.length;
    this.capacity = heap.length;
    init();
  }

  private void init() {
    // 중간 부터 시작하여 root 까지 maxHeapify 한다.
    for (int i= size /2-1; i>=0; i--) {
      maxHeapify(i);
    }
  }

  private void maxHeapify(int i) {
    int largest = i;
    int left = 2 * i + 1; // 좌변 배열 위치
    int right = 2 * i + 2; // 우변 배열 위치

    // 좌측과 비교
    // 사이즈와 비교를 우선 해줘야 outOfIndex를 피할 수 있음.
    if (left < size && heap[left] > heap[largest]) {
      largest = left;
    }

    // 우측과 비교
    if (right < size && heap[right] > heap[largest]) {
      largest = right;
    }

    // 값이 변경 되었다면 swap 한다.
    if (largest != i) {
      swap(i, largest);
      // 값이 변경된 위치에서 다시 maxHeapify 해줌.
      // 6, 12, 8 중에서 maxHeapify 는 12가 됨
//         6
//       /    \
//     12      8
//    /  \    /  \
//   9   10  5    7
// 여기서 12와 6이 swap이 되고 swap된 위치 6(현재)여기서 다시 maxheapify 해줘야 한다.
//         12
//       /    \
//     6       8
//    /  \    /  \
//   9   10  5    7

// 6과 10이 교환이 되면 교환된 위치에 더이상 자식이 없으므로 종료 된다.
//         12
//       /    \
//     10       8
//    /  \    /  \
//   9    6  5    7
      maxHeapify(largest);
    }
  }
  private void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  private void increaseCapacity() {
    this.capacity = this.capacity * 2;
    int[] newHeap = new int[capacity];
    // 배열 복사
    System.arraycopy(heap, 0, newHeap, 0, size);
    heap = newHeap;
  }

  private void heapifyUp(int index) {
    int parentIndex = (index - 1) / 2;
    if (index > 0 && heap[index] > heap[parentIndex]) {
      swap(index, parentIndex);
      heapifyUp(parentIndex);
    }
  }

  public void insert(int n) {
    if (size==capacity) {
      increaseCapacity();
    }
    heap[size] = n;
    size++;
    heapifyUp(size-1);
  }

  public void delete() {
    swap(0, size);
    maxHeapify(0);
    size--;
  }

  public void printHeap() {
    for (int i = 0; i < size; i++) {
      System.out.print(heap[i] + " ");
    }
    System.out.println();
  }





  public static void main(String[] args){
    int[] array = {3, 5, 1, 10, 2, 7, 6};
    MaxHeap maxHeap = new MaxHeap(array);
    maxHeap.printHeap();
    System.out.println("노드 추가");
    maxHeap.insert(9);
    maxHeap.printHeap();
    System.out.println("루트 노드 삭제");
    maxHeap.delete();
    maxHeap.printHeap();

  }
}
