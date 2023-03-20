import java.util.NoSuchElementException;

class LL {

	private Node head;
	private Node tail;
	int size;
	//ll constructor
	public LL() {
		head= null;
		tail=null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// A method that returns the value at a given index 
	public int getItemAt(int index) {
			if(index > size-1) {
				System.out.println("Index out of range");
				throw new NoSuchElementException();
			}
			int i =0;
			Node tem = head;
			while(i!= index) {
				tem = tem.next;
				i++;
			}
			//item found
			return tem.value;
	}
	
	// A method that replaces the value at a given index 
	public void replaceItemAt(int index, int val) {
		if(index > size-1) {
			System.out.println("Index out of range");
			throw new NoSuchElementException();
		}
		int i =0;
		Node tem = head;
		while(i!= index) {
			tem = tem.next;
			i++;
		}
		//item found. Replace value
		tem.value = val;
	}
	
	// A method that inserts a node at a given index. The old node pointed by index is shifted forward (right) 
	public void insertItemAt(int index, int val) {
		if(index > size-1) {
			System.out.println("Index out of range");
			throw new NoSuchElementException();
		}
		if (index == 0)
		{
			Node newNode = new Node(val, head, tail);
			head = newNode;
			newNode = null;
		}
		else {
			int i=0;
			Node tem = head;
			while (i != index -1)	// Stop at the node that precedes index
			{
				tem = tem.next;
				i++;
			}
			// Now we are pointing at the node preceding index
			Node newNode = new Node(val, tem.next, tem);	// next will point to temp.next and 
// previous will point to temp	
			tem.next.previous = newNode;
			tem.next = newNode;
			newNode = null;
		}
		size++;
	}
	
	// A method that deletes a node at a given index
	public void deleteItemAt(int index) {
		if(index>size-1) {
			System.out.println("Index out of range");
			throw new NoSuchElementException();
		}
		if (size == 1)
		{
			System.out.println("\nDeleting the only node of the list at index # " + 0 + ".");

			head = tail = null;
			size--;
			return;
		}

		if(index==0) {
			head = head.next;
			head.previous=tail;
			tail.next = head;
		}
		else {
			int i=0;
			Node tem = head;
			while (i != index -1)	// Stop at the node that precedes index
			{
				tem = tem.next;
				i++;
			}
			tem.next=tem.next.next;
			tem.next.previous = tem;
		}
		size--;
	}
	
	public void showListContents()
	{
		if (size == 0)
		{
			System.out.println("There is nothing to display; list is empty." );
			return;
		}
		
		
		System.out.println("List size is: " + size + ". Here are the contents of the list." );
		Node temp = head;
		
		while(temp != tail)
		{
			System.out.print("" + temp.value  + " <===> ");
			temp = temp.next;		
		}
		// Display that last node
		System.out.println("" + temp.value  + " <===> (Back to First Node)");
	}

	public void append(int v)
	{
		
		if (head == null)	// List is empty
		{
			Node temp = new Node(v, null, null);
			head = temp;
			head.next = head;
			head.previous = head;
			tail = head;
		}
		else
		{
			Node temp = new Node(v, head, tail);	
			head.previous = temp;
			tail.next = temp;
			tail = temp;
			temp = null;
		}
		size++;
	}


	private class Node{
		private int value;
		private Node next;
		private Node previous;
		//Node constructor
		public Node() {
			value=0;
			next=null;
			previous = null;
		}
		
		//Node parameterized constructor
		public Node(int value, Node next, Node previous) {
			this.value = value;
			this.next = next;
			this.previous = previous;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}	
	}// end of node class
	
}

public class DoubleyLL{
	public static void main(String[] args) {
		LL lst2 = new LL();
		lst2.append(10);
		lst2.deleteItemAt(0);
		System.out.println("The list current size is: " + lst2.getSize());	
		lst2.showListContents();
	
		lst2.append(1000);
		lst2.append(2000);
		lst2.deleteItemAt(1);
		lst2.showListContents();		
		
		lst2.insertItemAt(0, 5000);
		lst2.showListContents();	
	}
}
