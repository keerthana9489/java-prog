public class BinarySearchTree {
class Node {
int Key;
Node left,right;
public Node (int item) {
Key=item;
Left=right=null;
}
}
Node root;
BinarySearchTree() {
root=null;
}
voidinsert(int key){
root=insertRec(root,key);
}
Node insertRec(Node,root,intkey)
if(root=null) {
root=newNode(key);
returnroot;
}
if(key<root.key)
root.left=insertRec(root.left,key);
else if(key>root.key)
root.right=insertRec(root.right,key);
return root;
}
void printTree(){
PrintTree(root);
}
void printTree(Node node)
{
if(node 1=null){
PrintTree(node.left);
System.out.print(node.key+" ");
PrintTree(node.right);
}
}
public static void main(String{}args){
BinarySearchTree tree=new BinarySearchTree();
tree.insert(50);
tree.insert(30);
tree.insert(20);
tree.insert(40);
tree.insert(70);
tree.insert(60);
tree.insert(80);
System.out.println("BinarySearchTree:");
tree.printTree();
}
}