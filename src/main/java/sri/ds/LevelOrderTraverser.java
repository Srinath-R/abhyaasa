package sri.ds;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraverser {
    public static class TreeNode<E> {
        private E element;
        private TreeNode<E> left;
        private TreeNode<E> right;

        public TreeNode(E element) {
            this.element = element;
            this.left = this.right = null;
        }

        public TreeNode<E> withLeftChild(TreeNode<E> leftChild) {
            this.left = leftChild;
            return this;
        }

        public TreeNode<E> withRightChild(TreeNode<E> rightChild) {
            this.right = rightChild;
            return this;
        }

        public E getElement() {
            return element;
        }

        public TreeNode<E> getLeft() {
            return left;
        }

        public TreeNode<E> getRight() {
            return right;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private TreeNode<String> root;

    public TreeNode<String> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<String> root) {
        this.root = root;
    }

    /**
     * builds tree like
     *           one
     *          /   \
     *       two    three
     *       / \      /  \
     *    four five  six seven
     *          /
     *        eight
     */
    public void populateTree() {
        root = new TreeNode<>("One")
                .withLeftChild(new TreeNode<>("two"))
                .withRightChild(new TreeNode<>("three"));
        root.getLeft().withLeftChild(new TreeNode<>("four"))
                .withRightChild(new TreeNode<>("five"));
        root.getRight().withLeftChild(new TreeNode<>("six"))
                .withRightChild(new TreeNode<>("seven"));
        root.getLeft().getRight().withLeftChild(new TreeNode<>("eight"));
    }

    public void traverse() {
        Queue<TreeNode<String>> queue1 = new LinkedList<>();
        Queue<TreeNode<String>> queue2 = new LinkedList<>();
        queue1.offer(root);

        TreeNode<String> current;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                current = queue1.poll();
                System.out.print(current.getElement() + " ");
                if(current.getLeft() != null)
                    queue2.offer(current.getLeft());
                if(current.getRight() != null)
                    queue2.offer(current.getRight());
            }

            System.out.println();

            while (!queue2.isEmpty()) {
                current = queue2.poll();
                System.out.print(current.getElement() + " ");
                if(current.getLeft() != null)
                    queue1.offer(current.getLeft());
                if(current.getRight() != null)
                    queue1.offer(current.getRight());
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        LevelOrderTraverser lot = new LevelOrderTraverser();
        lot.populateTree();
        lot.traverse();
    }
}
