import java.util.*;

public class BinarySearchTree {
  public static class Node{
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

  public static Node add(Node root, Node new) {
    if (root == null) {
      return new;
    }

    Node p = root;

    while (p != null) {
      if (p.value > new.value) {
        if (p.left == null) {
          p.left = new;
          return root
        }
        p = p.left;
      }

      if (p.value < new.value) {
        if (p.right == null) {
          p.right = new;
          return root
        }
        p = p.right;
      }
    }

    return root
  }

  public static void print(Node root) {
    if (root == null) {
      return
    }

    System.out.printf(root.value);
    print(root->left);
    print(root->right);
  }

  public static void main() {
    Node root = null;
    add(root, new Node(5));
    add(root, new Node(3));
    add(root, new Node(2));
    add(root, new Node(8));
    add(root, new Node(7));

    print(root);
  }
}
