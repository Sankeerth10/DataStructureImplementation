class PQueue{
	private int capacity;
	private int numberOfElements;
	private int [] arr;
	
	public PQueue(int capacity){
		numberOfElements =0;
		this.capacity = capacity;
		arr = new int[capacity];
		for(int i=0; i<capacity;i++) {
			arr[i] = Integer.MAX_VALUE;
		}
	}
	public void insertSorted(int value) {

		numberOfElements++;
        // This is the check we were missing during the lecture!!!
        // For the first element, since the array is already initialized at 0
        if (numberOfElements == 0) {
            arr[numberOfElements] = value;
            return;
        }

        int j = numberOfElements - 1;

        while (j >= 0 && arr[j] > value) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = value;
    }
	
	public void displayQueue() {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
public class MyPriorityQueue {

	public static void main(String[] args) {
		PQueue queue = new PQueue(10);

	        queue.insertSorted(8);
	        queue.insertSorted(5);
	        queue.insertSorted(10);
	        queue.insertSorted(2);
	        queue.displayQueue();
	}

}
