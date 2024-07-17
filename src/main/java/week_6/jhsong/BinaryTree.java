package week_6.jhsong;

/*
전위: 루 왼 오
중위: 왼 루 오
후위: 왼 오 루

 */
public class BinaryTree {
    Node root;

    public void solution() {
        insert(4);
        insert(2);
        insert(1);
        insert(3);
        insert(8);
        insert(6);
        insert(9);

        // 이진트리 탐색
//        binaryTreeOrder();

        // 이진트리 검색
        binaryTreeSearch();


        // 이진트리 삭제
        delete(6);

        // 삭제 후 조회
        preOrder(root);

    }

    public void binaryTreeOrder() {
        // 전위 탐색
        preOrder(root);
        System.out.println();

        // 중위 탐색
        inOrder(root);
        System.out.println();

        // 후위 탐색
        postOrder(root);
        System.out.println();
    }

    public void binaryTreeSearch() {
        // 이진트리 검색
        Node node = search(8);

        if (node != null) {
            System.out.printf("value: %d, parent: %d, left: %d, right: %d", node.getValue(), node.getParent() != null ? node.getParent().getValue() : 0, node.getLeft() != null ? node.getLeft().getValue() : 0, node.getRight() != null ? node.getRight().getValue() : 0);
        } else {
            System.out.println("값을 찾을 수 없습니다.");
        }
    }

    public void insert(int value) {
        Node node = root;
        Node parent = root;

        while (node != null) {
            parent = node;
            if (node.getValue() > value) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        Node newNode = new Node(parent, value);
        if (parent == null) {
            root = newNode;
        } else if (parent.getValue() > value) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }

    public Node search(int value) {
        Node node = root;
        while (node != null && node.getValue() != value) {
            if (node.getValue() > value) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        return node;
    }

    public Node getMinNode (Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }

    public void delete (int value) {
        Node node = search(value);

        Node parent = node.getParent();
        if (node.getLeft() == null) {
            node.getParent().setRight(node.getRight());
        } else if (node.getRight() == null){
            node.getParent().setRight(node.getLeft());
        } else {
            Node succ = getMinNode(node.getRight());

            if (succ.getValue() == node.getRight().getValue()) {
                node.getParent().setRight(node);
            } else {
                node.getParent().setRight(succ);
            }
        }
    }

    public void moveToParent(Node node) {
        Node parent = node.getParent();


    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        visit(node);
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft());
        visit(node);
        inOrder(node.getRight());
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeft());
        postOrder(node.getRight());
        visit(node);
    }

    public void visit(Node node) {
        System.out.println(node.getValue());
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.solution();
    }
}
