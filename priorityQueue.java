package priority_ques;



public class priorityQueue {

	private int size;
	private Node[] heap;
	
	//Default constructor
	priorityQueue(){
		this.size = 0;
		this.heap = new Node[10];
	}
	//Loaded constructor
	priorityQueue(int size,Node[] heap){
		this.size = size;
		this.heap = heap;
		
	}
	//Getter methods for each one in the class
	public int getSize() {
		return size;
	}
	public Node[] getHeap() {
	
		if (heap == null) {
			return null;
		} 
		else { /*this for-loop will return each element in the array..
			i did it in order to encapsulate the data from users trying to edit
			or violate the internal heap*/
			Node[] copy = new Node[size];
			for (int i = 0 ; i < size; i++) {
				copy[i] = heap[i]; 
				}
			return copy;
		}
		
	}
	
	//Setter methods
	public void setSize(int size) {//Setting boundaries for the size
		if (size < 0 || (heap != null && size > heap.length)) {
			throw new IllegalArgumentException("Error: size out of bound");
		}
		this.size = size;
	}
	
	public void setHeap(Node[] heap) {
		if (heap == null) {
			System.err.println("Error: heap cannot be empty");
		}
		this.heap = heap;
	}
	public void clear() {
		this.heap = new Node[10];
		this.size = 0;
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
		
	}
	//Method to insert a node to a heap
	public boolean insert(Node x) {
	    if (size >= heap.length) {
	        Node[] addedHeap = new Node[heap.length * 2];
	        // copying of elements
	        for (int i = 0; i < heap.length; i++) {
	            addedHeap[i] = heap[i];
	        }
	        heap = addedHeap;
	    }

	    // this is where i check the position to insert
	    int i = size; // the new node should go at the end of the array
	    while (i > 0 && x.getPriority() < heap[(i - 1) / 2].getPriority()) { // comparing priorities
	        heap[i] = heap[(i - 1) / 2]; // shift the parent down
	        i = (i - 1) / 2;
	    }
	    heap[i] = x; // insert the node at the correct position
	    size++;
	    return true;
	}


	
	//method to delete a node
	public Node delete() {
		if (size == 0) {
			System.err.println("Heap is empty");
			return null;
		}
		
		 Node removed = heap[0]; //store the root node
		 heap[0] = heap[size -1]; // move the last elemnt to the root
		 heap[size -1] = null; // remove the last element(now there's a hole)
		 size--; // Reduce the size
		 percolateDown(0);
		 return removed;
	}
	private void percolateDown(int hole) {
	    int child;
	    Node tmp = heap[hole];

	    while (hole * 2 + 1 < size) { // left child index exists
	        child = hole * 2 + 1;

	        // If right child exists and has higher priority (smaller number = higher priority)
	        if (child + 1 < size && heap[child + 1].getPriority() < heap[child].getPriority()) {
	            child++;
	        }

	        if (heap[child].getPriority() < tmp.getPriority()) {
	            heap[hole] = heap[child];
	        } else {
	            break;
	        }

	        hole = child;
	    }

	    heap[hole] = tmp;
	}

}
