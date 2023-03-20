

class CLL {
	private Node head;
	private Node tail;
	private int size;
	
	public CLL() {
		head = null;
		tail = null;
		size = 0;
	}
	
	// Add to the beginning
    public void addAtTheBeginning(int value) {
    	head = new Node(value,head);
    	if(tail == null) {
    		tail = head;
    	}
    	else {
    		tail.next = head;
    	}
    	size++;
    }
    
    public void addToEnd(int value) {
    	if(head == null) {
    		addAtTheBeginning(value);
    	}
    	else if(head == tail){
    		Node newNode = new Node(value,head);
    		head.next = newNode;
    		tail = newNode;
    		tail.next = head;
    		size++;
    	}
    	else {
    		Node newNode = new Node(value,head);
    		tail = newNode;
    		tail.next = head;
    		size++;
    	}
    }
    
    public void addAfterValue(int referenceValue, int value) {
        if (head == null) {
            //addAtTheBeginning(value);
            System.out.println("The reference value does not exist. No value has been added.");
        } else {
            Node pos = head;
            do {
                pos = pos.next;
            } while ((pos.value != referenceValue) && (pos != head));

            if (pos.value == referenceValue) { // reference value found
                Node newNode = new Node(value, pos.next);
                pos.next = newNode;
                size++;
                if (newNode.next == head) {
                    tail = newNode;
                }
            }
        }
    }
    
    public void removeFirst() {
    	if(head==null) {
    		System.out.println("The list is empty, can't remove");
    	}
    	else if(head == tail) {
    		head = null;
    		tail = null;
    		size --;
    	}else {
            head = head.next;
            tail.next = head;
            size --;
        }
    }
    
    public void removeLast() {
    	if(head==null) {
    		System.out.println("The list is empty, can't remove");
    	}
    	else if(head == tail) {
    		head = null;
    		tail = null;
    		size --;
    	}else {
    		Node temNode = head;
    		while(temNode.next!= tail) {
    			temNode= temNode.next;
    		}
    		temNode.next = head;
    		tail = temNode;
    		size--;
    	}
    }
    
    
    public void display() {
    	if(head==null) {
    		System.out.println("Cll is empty!");
    	}
    	else if (head == tail) { // There is only one element
            System.out.println("The list has one value: " + head.value);
        }
    	else {
    		Node temNode = head;	
        	do {
        		System.out.print(temNode.value + "=>");
        		temNode = temNode.next;
        	}while(temNode!=head);
        	System.out.println("head");
    	}
    }
	
	class Node{
		private int value;
		private Node next;
		
		public Node() {
			value =0;
			next = null;
		}


		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}
	
}

public class CircularLL{
	public static void main(String[] args) {
		CLL cList = new CLL();
		cList.addAtTheBeginning(0);
        cList.addToEnd(5);
        cList.addToEnd(3);
        cList.addAfterValue(3, 8);
        cList.display();
//        cList.removeFirst();
//        cList.removeLast();
        
	}
}
