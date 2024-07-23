package week_6.jshan;


import week_6.jshan.sub.BinarySearchTree;
import week_6.jshan.sub.BinaryTree;
import week_6.jshan.sub.Node;
import week_6.jshan.sub.TreePrinter;

public class BinaryTree3_4 {
  public static void main(String[] args){
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(5); // root
    tree.insert(3);
    tree.insert(4);
    tree.insert(2);
    tree.insert(4);
    tree.insert(1);
    tree.insert(8);
    tree.insert(7);
    tree.insert(6);
    tree.insert(9);
    tree.insert(10);

    System.out.println("트리 모습");
    TreePrinter.printTree(tree.getRoot());
    System.out.println("\n \n 트리 서치 :");
    System.out.println(tree.search(10));

//    System.out.println("\n노드 삭제 :");
//    tree.delete(5);

    System.out.println("\n노드 추가 : 11");
    tree.insert(11);


    System.out.println("\n노드 삭제 : 8");
    tree.delete(8);

    System.out.println("트리 모습");
    TreePrinter.printTree(tree.getRoot());


  }

}
