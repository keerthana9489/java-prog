class Node {
	int data;
	Node left;
	Node right;

        Node(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

public class BinarySearchTree {
		Node root;
	void deleteNode(int data) {
		root=deleteNode(root,data) ;
	}
	Node deleteNode(Node currentNode,int data) {
		if(currentNode == null) {
			return currentNode;
		}
		if(data<currentNode.data) {
			currentNode.left=deleteNode(currentNode.left,data);
		} else if(data> currentNode.data) {
			currentNode.right=deleteNode(currentNode.right,data);
		} else {
			if(currentNode.left==null) {
				return currentNode.right;
			} else if(currentNode.right==null) {
				return currentNode.left;
			}
		}
return currentNode;
}
void printTree() {
	printTree(root);
}
void printTree(Node node) {
	if(node!=null) {
		printTree(node.left);
		System.out.print(node.data+" ");
		printTree(node.right);
	}
}
public static void main(String[]args) {
	BinarySearchTreeDelete bst=new BinarySearchTreeDelete();
	bst.root=new Node(50);
	bst.root.left=new Node(30);
	bst.root.right=new Node(70);
	bst.root.right.left=new Node(20);
	bst.root.left.right=new Node(40);
	System.out.println("before deletion:");
	bst.printTree();
	bst.delete(70);
	System.out.println("Aftre deletion:");
	bst.printTree();
	}
}