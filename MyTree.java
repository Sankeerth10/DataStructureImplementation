import java.util.PrimitiveIterator.OfDouble;
import java.util.function.BinaryOperator;

class Tree{
	
	Node root;
	public Tree() {
		root = null;
	}
	
	public void insertNode(int value){
		root= addNodeRec(root, value);
	}
	
	public Node addNodeRec(Node current , int value) {
		if(current==null) {
			return new Node(value);
		}
		else if(value<current.value) {
			current.left = addNodeRec(current.left, value);
		}
		else if (value>current.value) {
			current.right = addNodeRec(current.right, value);
		}
		else {
			return current;
		}
		return current;
	}
	
	public boolean containsNode(int value) {
		return containsNodeRec(root,value);
	}
	 
	public boolean containsNodeRec(Node current, int value) {
		if(current == null){
			return false;
		}
		if (current.value == value) {
			return true;
		}
		return (value<current.value)? containsNodeRec(current.left, value): containsNodeRec(current.right, value);
	}

	public void deleteNode(int value) {
		root=removeNodeRec(root, value);
	}
	
	public Node removeNodeRec(Node current,int value){
		if(current==null) {
			return null;
		}
		if(current.value == value) {
			if (current.left == null && current.right == null) {
			    return null;
			}
			if (current.right == null) {
			    return current.left;
			}

			if (current.left == null) {
			    return current.right;
			}
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = removeNodeRec(current.right, smallestValue);
			return current;
		}
		if (value < current.value) {
	        current.left = removeNodeRec(current.left, value);
	        return current;
	    }
		current.right = removeNodeRec(current.right, value);
	    return current;
	}
	
	private int findSmallestValue(Node root) {
	    if(root.left == null) {
	    	return root.value;
	    }
	    else{
	    	return findSmallestValue(root.left);
	    }
	}
	class Node{
		private int value;
		private Node left;
		private Node right;
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
		
		public Node() {
			value =0;
			left = null;
			right = null;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
		
	}// end of node class
	
	
}
public class MyTree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insertNode(2);
		tree.insertNode(6);
		tree.insertNode(1);
		tree.insertNode(10);
		tree.deleteNode(6);
		System.out.println(tree.containsNode(10));
		System.out.println(tree.containsNode(6));
	}
}
