import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    int data;
    BinaryTree left, right;

    BinaryTree(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTreeTraversal {
    //in order-Traversal DFS: left,Root,Right
    public static void inOrderTraversal(BinaryTree node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    //Pre - order : Root , left ,right;
    public static void preOrderTraversal(BinaryTree node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //post-order : left,right,root
    public static void postOrderTraversal(BinaryTree node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    //BFS : Level order Traversal
    public static void BFS(BinaryTree node) {
        if (node == null) return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryTree tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) queue.add(tempNode.left);
            if (tempNode.right != null) queue.add(tempNode.right);
        }
    }
}

class BinaryTreeOperations {
    public static void insert(BinaryTree node, int value) {

    }
}


public class BinaryTreeExample {
    public static void main(String[] args) {

        /*
                            2
                      5         6
                     8  9    2       4

         */
        BinaryTree node = new BinaryTree(2);
        node.left = new BinaryTree(5);
        node.left.left = new BinaryTree(8);
        node.left.right = new BinaryTree(9);
        node.right = new BinaryTree(6);
        node.right.right = new BinaryTree(4);
        node.right.left = new BinaryTree(2);

        System.out.print("In order Traversal : left,Root,Right -> ");
        BinaryTreeTraversal.inOrderTraversal(node);

        System.out.print("\nPre order Traversal : Root, left, Right-> ");
        BinaryTreeTraversal.preOrderTraversal(node);

        System.out.print("\n Post Order Traversal : left Right, Root : -> ");
        BinaryTreeTraversal.postOrderTraversal(node);

        System.out.print("\n Level Order: Root , Left , Right of same level : -> ");
        BinaryTreeTraversal.BFS(node);

    }
}