public class Stack 
{
	private Node top ;
	private int size;

	public Stack() 
        {
		top=null;
		size=0;
	}

public boolean isEmpty()
{
	return top==null;
}

public void push(int data) 
{
	Node newNode = new Node(data);
	newNode.next=top;
	top=newNode;
	size++;
}

public int pop() 
{
	if (isEmpty()) 
        {
		System.out.println("Stack is empty");
		return-1;
	}

	int poppedElement= top.data;
	top=top.next;
	size--;
	return poppedElement;
}

public int peek() 
{
	if (isEmpty()) 
        {
		System.out.println("Stack is empty");
		return-1;
	}

	return top.data;
}
public void display()
{
	if (isEmpty())
	{
		System.out.println("Stack is empty");
	}
	else
	{
		Node current=top;
		if (isEmpty()) 
		{
			System.out.println("Stack is empty");
			while(current!=null) 
			{
				System.out.println(current.data+" ");
				current=current.next;
			}	
		System.out.println();
		}
	}
}

private class Node
{
	int data;
	Node next;
	public Node(int data){
		this.data=data;
		next=null;
	}
}

public static void main(String []args) {
	System.out.println("intialize a Stack using Linked List");

	System.out.println("\n input some elementon the Stack;");
	Stack stack=new Stack();
	stack.push(1);
	stack.push(2);
	stack.push(3);
	stack.push(4);
	stack.push(5);
	stack.display();
	System.out.println("\n top element:"+ stack.peek());
	System.out.println("\n Remove two element from the stack:");
	stack.pop();
	stack.peek();
	stack.display();
	System.out.println("\n top element:"+ stack.peek());

	}
}




