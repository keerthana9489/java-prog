class BinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Delete method to delete a node in the tree
    public Node delete(Node root, int key) {
        // Base case: if the root is null
        if (root == null) {
            return root;
        }

        // If the key to be deleted is smaller than the root's data, go left
        if (key < root.data) {
            root.left = delete(root.left, key);
        }
        // If the key to be deleted is larger than the root's data, go right
        else if (key > root.data) {
            root.right = delete(root.right, key);
        }
        // If the key is the same as root's data, then this is the node to be deleted
        else {
            // Case 1: Node has no children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Node has one child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Node has two children
            else {
                // Get the inorder successor (smallest in the right subtree)
                root.data = minValue(root.right);

                // Delete the inorder successor
                root.right = delete(root.right, root.data);
            }
        }
        return root;
    }

    // Utility function to find the smallest value node in the given tree
    public int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Method to insert a new node with a given key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new node
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Method to print the tree (in-order traversal)
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal before deletion:");
        tree.inorder(tree.root);
        System.out.println();

        int keyToDelete = 50;
        tree.root = tree.delete(tree.root, keyToDelete);

        System.out.println("In-order traversal after deletion of " + keyToDelete + ":");
        tree.inorder(tree.root);
        System.out.println();
    }
}
