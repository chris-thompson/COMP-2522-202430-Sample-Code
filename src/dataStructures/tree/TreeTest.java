package dataStructures.tree;

import java.util.Random;

/**
 * TreeTest.
 *
 * @author BCIT
 * @version 2024
 */
public final class TreeTest {

    private TreeTest() {
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        Tree tree = new Tree();
        Random randomNumber = new Random();
        System.out.println("Inserting the following values: ");
        final int size = 10;
        final int upperBound = 100;
        for (int i = 0; i < size; i++) {
            int value = randomNumber.nextInt(upperBound);
            System.out.print(value + " ");
            tree.insertNode(value);
        }

        System.out.println("\n\nPreorder traversal");
        tree.preorderTraversal();

        System.out.println("\n\nInorder traversal");
        tree.inorderTraversal();

        System.out.println("\n\nPostorder traversal");
        tree.postorderTraversal();
    }
}
