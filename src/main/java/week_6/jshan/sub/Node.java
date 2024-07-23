package week_6.jshan.sub;

public class Node {
  int item;
  Node left;
  Node right;

  @Override
  public String toString() {
    return "Node{" +
        "item=" + item +
        '}';
  }

  public Node(int item) {
    this.item = item;
  }


  public int getItem() {
    return item;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public void setItem(int item) {
    this.item = item;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}
