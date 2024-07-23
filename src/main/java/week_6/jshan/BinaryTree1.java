package week_6.jshan;

import java.util.Arrays;

public class BinaryTree1 {
  private int[] tree;

  public int moveToLeftChild(int idx) {
    return tree[idx * 2];
  }

  public int moveToRightChild(int idx) {
    return tree[idx * 2 + 1];
  }

  public int moveToParent(int idx) {
    return tree[idx / 2];
  }

  public BinaryTree1(int[] tree) {
    this.tree = tree;
  }

  public int getValue(int idx) {
    return this.tree[idx];
  }

  public static void main(String[] args) {
    // 이진 트리에 0번째 배열은 비워둠.
    BinaryTree1 binaryTree61 = new BinaryTree1(new int[] {0, 1, 2, 5, 3, 4, 6, 7});

    System.out.println("binary tree");
    Arrays.stream(binaryTree61.tree).forEach(i -> System.out.print(i + " "));
    System.out.println();

    System.out.printf(
        "current node is %d, move to left child is : %d \n",
        binaryTree61.tree[2], binaryTree61.moveToLeftChild(2));
    System.out.printf(
        "current node is %d, move to right child is : %d \n",
        binaryTree61.tree[2], binaryTree61.moveToRightChild(2));
    System.out.printf(
        "current node is %d, move to left child is : %d \n",
        binaryTree61.tree[3], binaryTree61.moveToLeftChild(3));
    System.out.printf(
        "current node is %d, move to right child is : %d \n",
        binaryTree61.tree[3], binaryTree61.moveToRightChild(3));

    System.out.printf(
        "current node is %d, move to parent is : %d \n",
        binaryTree61.tree[6], binaryTree61.moveToParent(6));
  }
}
