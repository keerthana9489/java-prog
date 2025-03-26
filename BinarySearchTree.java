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

    // Recursive method to search for a key in the tree
    public Node search(Node root, int key) {
        // Base case: root is null or key is present at the root
        if (root == null || root.data == key) {
            return root;
        }

        // Key is greater than root's data
        if (key > root.data) {
            return search(root.right, key);
        }

        // Key is smaller than root's data
        return search(root.left, key);
    }

    // Wrapper method to call the recursive search function
    public Node search(int key) {
        return search(root, key);
    }

    // Method to insert a new node with given key
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

        int key = 40;
        Node result = tree.search(key);
        if (result != null) {
            System.out.println("Key " + key + " found in the tree.");
        } else {
            System.out.println("Key " + key + " not found in the tree.");
        }
    }
}
