public class MyLinkedList {
	private Node head;
    private Node tail;
    private int counter;
    
    public MyLinkedList() {
        head = null;
        tail = null;
        counter = 0;
    }
    
	private class Node{
		private int value;
		private Node next;
		private Node() {
			value = 0;
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

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
}
	
	public void addAtTheBeginning(int value) {
		head = new Node(value,head);
		if(tail == null) {
			tail = head;
		}
		counter++;
	}
	
	public void addAtTheEnd(int value) {
        if (head != null) {
            Node newNode = new Node(value, null);
            tail.next = newNode;
            tail = newNode;
            counter++;
        } else {
            //head = new Node(value, head);
            addAtTheBeginning(value);
        }
    }
	
	public void display() {
		Node temp = head;
		while(temp!= null) {
			System.out.print(temp.value + "=>");
			temp = temp.next;
		}
		System.out.println("END");
	}
	public void addAfterValue(int referenceValue, int value) {
		Node temp = head;
		while(temp!= null && temp.value!= referenceValue) {
			temp = temp.next;
		}
		if(temp == null) {
			System.out.println("The reference value does not exist. No value will be added.");
	        
		}else {
            Node newNode = new Node(value, temp.next);
            temp.next = newNode;
            if (temp == tail) {
                tail = temp.next;
            }
            counter++;
	}
	}
	public void addBeforeValue(int referenceValue, int value) {
        Node pos = head;

        if (head == null) {
            System.out.println("The list is empty. No value will be added");

        } else {

            while ((pos.next != null) && (pos.next.value != referenceValue)) {
                pos = pos.next;
            }
            if (pos.next == null) {
                System.out.println("The reference value does not exist. No value will be added.");
            } else {
                Node newNode = new Node(value, pos.next);
                pos.next = newNode;
            }
            counter++;
        }
    }

    public void deleteFirstElement() {

        if (head != null) {
            head = head.next;

            // Reposition the head if the removed element was the only one
            if (head == null) {
                tail = null;
            }
            counter--;
        } else {
            System.out.println("The list is empty. No value has been removed.");
        }
    }
    
    public void deleteLastElement() {
        Node pos = head;

        if (head == null) {
            System.out.println("The list is empty. No value has been removed.");
        } else if (head.next == null) {
            head = null;
            tail = null;
            counter = 0;
        } else {

            while (pos.next.next != null) {
                pos = pos.next;
            }
            tail = pos;
            pos.next = null;
            counter--;
        }
    }
    
    
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
        // Add at the beginning
        list.addAtTheBeginning(-3);
        // At at the end
        list.addAtTheEnd(0);
        list.display();
	}
}
