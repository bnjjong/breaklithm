package week_6.keepbang;

public class BinarySearchTree {

  public static void main(String[] args) {
    BinaryTree root = new BinaryTree(7);
    root.left = new BinaryTree(5, new BinaryTree(2), new BinaryTree(6));
    root.right = new BinaryTree(12, new BinaryTree(8), new BinaryTree(17));

    root.print();

    BinarySearchTree solution = new BinarySearchTree();

    BinaryTree search = solution.search(root, 2);
    System.out.println("search = " + search.val);

    root = solution.add(root, 3);
    root = solution.add(root, 1);

    root.print();

    root = solution.delete(root, 7);

    root.print();


  }

  public BinaryTree search(BinaryTree t, int x) {
    BinaryTree node = t;

    while (node != null && node.val != x) {
      if (node.val > x) {
        node = node.left;
      } else {
        node = node.right;
      }
    }

    return node;
  }

  public BinaryTree add(BinaryTree t, int x) {
    BinaryTree node = t;
    BinaryTree parent = t;

    while (node != null) {
      parent = node;
      if (node.val > x) {
        node = node.left;
      } else {
        node = node.right;
      }
    }

    // 비어있는 트리일 경우
    if (parent == null) {
      return new BinaryTree(x);
    } else if (parent.val > x) {
      parent.addLeft(x);
    } else {
      parent.addRight(x);
    }
    return t;
  }

  public BinaryTree delete(BinaryTree t, int x) {
    // 삭제해야할 노드를 찾습니다.
    BinaryTree node = this.search(t, x);

    if (node == null) {
      return t; // 삭제할 값을 찾지 못 할 경우.
    }

    // 삭제할 노드 왼쪽 오른쪽 둘 다 비어있을 경우 (리프노드 or 루트 노드이면서 리프노드인 경우)
    if (node.left == null && node.right == null) {
      BinaryTree parent = node.parent;

      // 삭제할 노드가 루트 노드인 경우
      if (parent == null) {
        return null;
      }

      if (parent.right == node) {
        parent.right = null;
      } else {
        parent.left = null;
      }
      return t;
    }

    // 삭제해야할 노드의 왼쪽 자식이 비어있다면
    if (node.left == null) {
      // 오른쪽 자식을 위로 올려줍니다.
      BinaryTree right = node.right;
      node.val = right.val;
      node.left = right.left;
      node.right = right.right;
    } else if (node.right == null) { // 오른쪽 자식이 비어있다면
      // 왼쪽 자식을 위로 올려줍니다.
      BinaryTree left = node.left;
      node.val = left.val;
      node.left = left.left;
      node.right = left.right;
    } else {// 왼쪽 오른쪽 다 채워져 있다면
      // 해당 노드 오른쪽 노드에서 최소값을 구합니다(successor를 구함).
      // successor : 현재 노드 기준으로 더 크면서 가장 작은 값을 갖는 노드
      BinaryTree succ = this.minimun(node.right);
      if (succ == node.right) {
        // 만약 successor가 오른쪽 노드라면 오른쪽 자식을 위로 올리면 됩니다.
        BinaryTree right = node.right;
        node.val = right.val;
        node.right = right.right;
      } else { // 그렇지 않은 경우라면(삭제할 노드보다 크면서 최소값)
        // 노드의 값을 successor의 값으로 대체시켜준 뒤
        // successor의 오른쪽 자식을 위로 올립니다.
        node.val = succ.val;
        // successor의 왼쪽은 null이기때문에 오른쪽 값만 확인 하면됨
        if (succ.right != null) {
          BinaryTree right = succ.right;
          succ.val = right.val;
          succ.right = right.right;
        } else { // 부모노드의 왼쪽을 null로 만들어야함
          succ.parent.left = null;
        }
      }

    }
    return t;
  }

  // node 하위 트리에서 최소값을 구합니다
  private BinaryTree minimun(BinaryTree node) {
    while (node.left != null) {
      node = node.left;
    }

    return node;
  }
}
