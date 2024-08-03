package week_7.jshan;

public class MaxHeap6_5_5 {
  public static void main(String[] args){
    int[] array = {7};
    MaxHeap heap = new MaxHeap(array, false);
    heap.insert(6);
    heap.printHeap();
    heap.insert(5);
    heap.printHeap();
    heap.insert(4);
    heap.printHeap();
    heap.insert(3);
    heap.printHeap();
    heap.insert(2);
    heap.printHeap();
    heap.insert(1);
    heap.printHeap();
  }
}
