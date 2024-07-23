package week_6.jshan.sub;

public class BinaryTree {
  protected Node root;

  public void setRoot(Node root) {
    this.root = root;
  }

  public Node getRoot() {
    return root;
  }

  // 전위 탐색
  public void preorder(Node node) {
    if (node == null) {
      return;
    }

    // 노드 방문
    visit(node);
    // 왼쪽 서브트리 탐색
    preorder(node.getLeft());
    // 오른쪽 서브트리 탐색
    preorder(node.getRight());
  }

  private void visit(Node node) {
    System.out.print(node.getItem()+" ");
  }

  public void inorder(Node node) {
    if (node == null) {
      return;
    }
    inorder(node.getLeft());
    visit(node);
    inorder(node.getRight());

  }

  public void postorder(Node node) {
    if (node == null) {
      return;
    }
    postorder(node.getLeft());
    postorder(node.getRight());
    visit(node);
  }
}
