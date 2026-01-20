import java.util.*;

public class BinarySearchTree {
  public static class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }

    public Node(Node left, Node right) {
      this.left = left;
      this.right = right;
    }

    public Node(int value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }

  public static Node add(Node root, Node n) {
    if (root == null) {
      return n;
    }

    Node p = root;

    while (p != null) {
      if (p.value > n.value) {
        if (p.left == null) {
          p.left = n;
          return root;
        }
        p = p.left;
      }

      if (p.value < n.value) {
        if (p.right == null) {
          p.right = n;
          return root;
        }
        p = p.right;
      }
    }

    return root;
  }

  public static int search(Node root, int value) {
    Node p = root;
    int level = 0;
    while (p != null) {
      // System.out.printf("%d - %d\n", p.value, value);

      if (p.value == value)
        return level;

      if (p.value > value)
        p = p.left;

      if (p.value < value)
        p = p.right;

      level++;
    }

    return -1;
  }

  public static void print(Node root) {
    if (root == null) {
      return;
    }

    System.out.printf("%d ", root.value);
    print(root.left);
    print(root.right);
  }

  public static void main() {
    Node root = null;
    root = add(root, new Node(3));
    root = add(root, new Node(2));
    root = add(root, new Node(5));
    root = add(root, new Node(8));
    root = add(root, new Node(9));
    root = add(root, new Node(7));

    int level = search(root, 8);
    if (level >= 0)
      System.out.printf("Found element at %d\n", level);
    else
      System.out.println("Couldn't find element ");

    print(root);
    System.out.println();
  }
}
