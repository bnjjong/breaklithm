package week_6.jshan.sub;

public class TreePrinter {
  // 트리의 높이를 계산하는 메소드
  private static int getHeight(Node root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }

  // 트리를 그래픽적으로 출력하는 메소드
  public static void printTree(Node root) {
    int height = getHeight(root);
    int width = (int) Math.pow(2, height) - 1;
    String[][] res = new String[height * 2][width];

    // 배열 초기화
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < width; j++) {
        res[i][j] = " ";
      }
    }

    // 노드의 위치를 설정
    fill(res, root, 0, 0, width - 1);

    // 배열을 출력
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(res[i][j]);
      }
      System.out.println();
    }
  }

  // 노드를 배열에 채우는 메소드
  private static void fill(String[][] res, Node root, int level, int left, int right) {
    if (root == null) {
      return;
    }
    int mid = (left + right) / 2;
    res[level][mid] = Integer.toString(root.item);
    if (root.left != null) {
      res[level + 1][(left + mid) / 2] = "/";
    }
    if (root.right != null) {
      res[level + 1][(mid + right + 1) / 2] = "\\";
    }
    fill(res, root.left, level + 2, left, mid - 1);
    fill(res, root.right, level + 2, mid + 1, right);
  }
}
