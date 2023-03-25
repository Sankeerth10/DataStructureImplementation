import java.util.Scanner;

class Heap1{
	private int [] heapArr;
	int currentSize;
	
	public Heap1() {
		this.heapArr= new int[10000];
		this.currentSize = 0;
	}
	
	public void add(int val) {
		if(currentSize==0) {
			heapArr[currentSize] = val;
			currentSize++;
		}
		else {
			heapArr[currentSize] = val;
			upHeap(currentSize);
			currentSize++;
		}
	}
	
	public void upHeap(int index) {
		int parentIndex = ((index-1)/2);
		if(heapArr[parentIndex]> heapArr[index]) {
			int temp = heapArr[parentIndex];
			heapArr[parentIndex] =heapArr[index];
			heapArr[index] = temp;
			upHeap(parentIndex);
		}
		return;
	}
	
	public int removeMin() {
		int minimumElement = heapArr[0];
		int lastElement = currentSize-1;
		heapArr[0] = heapArr[lastElement];
		System.out.println("last element: " + heapArr[0]);
		heapArr[lastElement] = 0;
		currentSize--;
		downHeap(0);
		return minimumElement;
	}
	
	public void downHeap(int index) {
		int leftChildIndex = (2*index)+1;
		int rightChildIndex = (2*index)+2;
		if(currentSize-1<leftChildIndex) {
			return;
		}
		else if(currentSize-1 == leftChildIndex) {
			if(heapArr[leftChildIndex] < heapArr[index]) {
				int temp = heapArr[leftChildIndex];
				heapArr[leftChildIndex] = heapArr[index];
				heapArr[index] = temp;
				downHeap(leftChildIndex);
			}
	}else {
		int indexToSwap=0;
		System.out.println("lc "+ heapArr[leftChildIndex]);
		System.out.println("rc " + heapArr[rightChildIndex]);
		if(heapArr[leftChildIndex]<heapArr[rightChildIndex]) {
			indexToSwap = leftChildIndex;
		}
		else {
			indexToSwap = rightChildIndex;
		}
		if(heapArr[index]>heapArr[indexToSwap]) {
			int temp = heapArr[index];
			heapArr[index] = heapArr[indexToSwap];
			heapArr[indexToSwap] = temp;
			downHeap(indexToSwap);
		}
				}
	}
	public boolean isHeapEmpty() {
		return currentSize==-1;
	}
	
	public void printHeap() {
		for(int i=0; i<=currentSize-1;i++) {
			System.out.println(heapArr[i]);
		}
	}
}

public class MyMinHeap1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Heap1 heap = new Heap1();
		int valueToAdd = sc.nextInt();
		heap.add(valueToAdd);
		int valueToAdd1 = sc.nextInt();
		heap.add(valueToAdd1);
		int valueToAdd2 = sc.nextInt();
		heap.add(valueToAdd2);
		int valueToAdd3 = sc.nextInt();
		heap.add(valueToAdd3);
		System.out.print("HEAP AFTER ADD: ");
		heap.printHeap();
		
		System.out.println("Min: " + heap.removeMin());
		System.out.print("HEAP AFTER REMOVE: ");
		heap.printHeap();
		System.out.println("Min: " + heap.removeMin());
		System.out.print("HEAP AFTER REMOVE: ");
		heap.printHeap();
		
	}

}
