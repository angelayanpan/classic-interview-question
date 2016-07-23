
/*
 * check if a binary tree is a binary search tree where the left sub-tree is
 * less or Equal to the root and the right sub-tree is greater
 */

public class checkBST {
  
  public static Boolean IsBinarySearchTreeHelper(Node node){
    return IsBinarySearchTree(node,Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static Boolean IsBinarySearchTree(Node node, int min, int max){
    if(node==null){
      return true;
    }
    if(node.key>min && node.key<= max 
        && IsBinarySearchTree(node.left,min,node.key)
        && IsBinarySearchTree(node.right,node.key,max)){
      return true;
    }
    return false;
  }
  public static void main(String[] args) throws Exception{
    Node test1 = new Node(2);
    test1.left = new Node(2);
    test1.right = new Node(3);
    System.out.println("test1 is a BST? " + IsBinarySearchTreeHelper(test1));
    
    Node test2 = new Node(2);
    test2.left = new Node(2);
    test2.right = new Node(2);
    System.out.println("test2 is a BST? " + IsBinarySearchTreeHelper(test2));
    
    Node test3 = new Node(7);
    test3.left = new Node(3);
    test3.right = new Node(10);
    test3.right.left= new Node(10);
    System.out.println("test3 is a BST? " + IsBinarySearchTreeHelper(test3));
    
  }
}

class Node{
  int key;
  Node left, right;
  public Node(int num){
    key = num;
    left= right= null;
  }
}
