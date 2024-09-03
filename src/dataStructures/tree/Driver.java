package dataStructures.tree;

/**
 * Create a Tree of integers, and then print the Tree out.
 *
 * @author BCIT
 * @version 2024
 */
public final class Driver {

    private Driver() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Tree tree = new Tree();
        tree.insertNode(2);
        tree.insertNode(4);
        tree.insertNode(-5);
        tree.insertNode(0);
        tree.insertNode(8);
        tree.insertNode(-3);
        System.out.println("\nIn order");
        tree.inorderTraversal();
        System.out.println("\nPost-order");
        tree.postorderTraversal();
        System.out.println("\nPre-order");
        tree.preorderTraversal();
    }
}
