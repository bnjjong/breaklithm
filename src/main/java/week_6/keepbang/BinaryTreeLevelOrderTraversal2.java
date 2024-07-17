package week_6.keepbang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 */
public class BinaryTreeLevelOrderTraversal2 {

  public static void main(String[] args) {

    BinaryTreeLevelOrderTraversal2 binaryTree = new BinaryTreeLevelOrderTraversal2();
    BinaryTree root = new BinaryTree(3);
    root.left = new BinaryTree(9);
    root.right = new BinaryTree(20, new BinaryTree(15), new BinaryTree(7));
    List<List<Integer>> lists = binaryTree.levelOrderBottom(root);
    System.out.println("lists = " + lists);


  }

  public List<List<Integer>> levelOrderBottom(BinaryTree root) {
    return levelOrderBottomQueue(root);
  }

  private void levelOrder(BinaryTree node, int level, List<List<Integer>> levels) {
    if (node == null) {
      return;
    }

    // 리스트 초기화
    // ex) level = 0, levels size = 0
    // ex) level = 1, levels size = 1 (레벨 0 노드가 포함되어 있음)
    // ex) level = 2, levels size = 2 (레벨 1 노드가 포함되어 있음)
    // bottom up으로 저장하기 위해 0번 인덱스에 저장
    if (levels.size() == level) {
      levels.add(0, new ArrayList<>());
    }

    // 리스트 0번째 인덱스에 추가
    levels.get(level).add(node.val);
    levelOrder(node.left, level + 1, levels);
    levelOrder(node.right, level + 1, levels);
  }

  public List<List<Integer>> levelOrderBottomQueue(BinaryTree root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    Queue<BinaryTree> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        BinaryTree current = queue.poll();
        level.add(current.val);
        if (current.left != null) queue.offer(current.left);
        if (current.right != null) queue.offer(current.right);
      }
      result.add(0, level);
    }
    return result;

  }

}
