package week_6.jshan;


import week_6.jshan.sub.BinaryTree;
import week_6.jshan.sub.Node;
import week_6.jshan.sub.TreePrinter;

public class BinaryTree3 {
  public static void main(String[] args){
    BinaryTree tree = new BinaryTree();
    tree.setRoot(new Node(1));
    tree.getRoot().setLeft(new Node(2));
    tree.getRoot().setRight(new Node(3));
    tree.getRoot().getLeft().setLeft(new Node(4));
    tree.getRoot().getLeft().setRight(new Node(5));
    tree.getRoot().getRight().setLeft(new Node(6));
    tree.getRoot().getRight().setRight(new Node(7));


    System.out.print("전위 탐색 : ");
    tree.preorder(tree.getRoot());

    System.out.print("\n중위 탐색 : ");
    tree.inorder(tree.getRoot());

    System.out.print("\n후위 탐색 : ");
    tree.postorder(tree.getRoot());

    System.out.println("\n \n트리 모습");
    TreePrinter.printTree(tree.getRoot());


  }

}
