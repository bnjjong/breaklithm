package week_7.jshan;

public class MaxHeap6_5_2 {
  public static void main(String[] args){
    int[] array = {1,2,5,4,3,6,8,7,9};
    MaxHeap heap = new MaxHeap(array, false);
    System.out.println("================init heap================");
    heap.printHeap();
    heap.delete();
    heap.delete();
    heap.delete();
    heap.printHeap();
  }
}
