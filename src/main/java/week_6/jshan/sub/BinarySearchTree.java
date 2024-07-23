package week_6.jshan.sub;

public class BinarySearchTree extends BinaryTree{

  // 키를 삽입하는 메소드
  public void insert(int key) {
    root = insertRec(root, key);
  }

  // 재귀적으로 노드를 삽입하는 보조 메소드
  private Node insertRec(Node root, int key) {
    // 트리가 비어있으면 새로운 노드를 반환
    if (root == null) {
      root = new Node(key);
      return root;
    }

    // 키를 삽입할 위치를 찾기 위해 트리를 순회
    if (key < root.item)
      root.left = insertRec(root.left, key);
    else if (key > root.item)
      root.right = insertRec(root.right, key);

    // 변경된 루트를 반환
    return root;
  }

  // 키를 탐색하는 메소드
  public Node search(int key) {
    return searchRec(root, key);
  }

  // 재귀적으로 키를 탐색하는 보조 메소드
  private Node searchRec(Node root, int key) {
    // 트리가 비어있거나 키를 찾으면 true 반환
    if (root == null)
      return null;
    if (root.item == key)
      return root;

    // 키가 현재 노드보다 작으면 왼쪽 서브트리를 탐색
    if (key < root.item)
      return searchRec(root.left, key);

    // 키가 현재 노드보다 크면 오른쪽 서브트리를 탐색
    return searchRec(root.right, key);
  }

  // 키를 삭제하는 메소드
  public void delete(int key) {
    root = deleteRec(root, key);
  }

  // 재귀적으로 노드를 삭제하는 보조 메소드
  private Node deleteRec(Node root, int key) {
    // 트리가 비어있으면 그대로 반환
    if (root == null) return root;

    // 키를 찾기 위해 트리를 순회
    if (key < root.item)
      root.left = deleteRec(root.left, key);
    else if (key > root.item)
      root.right = deleteRec(root.right, key);
    else {
      // 키를 찾은 경우
      // 노드에 하나의 자식만 있는 경우
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;

      // 두 자식이 있는 경우
      root.item = minValue(root.right); // 찾은 노드의 값을 여기서 replcae.
      root.right = deleteRec(root.right, root.item); //우측 노드에서 해당 값을 삭제.
    }

    return root;
  }

  // 오른쪽 서브트리에서 최소값을 찾는 메소드
  public int minValue(Node root) {
    int minValue = root.item;
    while (root.left != null) {
      minValue = root.left.item;
      root = root.left;
    }
    return minValue;
  }
}
