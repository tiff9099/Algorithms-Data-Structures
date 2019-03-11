//Tiffany Taghvaiee & Elsa Sveen

public class ArrayQueue<T> implements Queue<T>{
	private T[] elements; 
	public static final int CAPACITY_MULTIPLIER = 2;
	public static int DEFAULT_CAPACITY = 15;
	private int capacity; // size
	private int numberOfElements = 0; //size?
	private int front = 0; //index of front
	private int rear = 0; //index of rear

	//creates a default-sized array
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	//specifies an initial capacity
	public ArrayQueue(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		this.capacity = capacity;
		elements = (T[])new Object[capacity];
	}

	public void add(T item) {
		ensureCapacity();
		elements[rear] = item;
		rear = (1 + rear) % (capacity); //?
		numberOfElements++;
	}

	public T remove() {
		T output = elements[front];
		if (!this.isEmpty()) {
			elements[front] = null;
			front = (front + 1) % (capacity);
			numberOfElements--;
			return output;
		}
		return null;
	}

	public boolean isEmpty() {
		if (this.numberOfElements == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return numberOfElements;
	}

	private void ensureCapacity() {
		if (elements[front] !=null && (front - rear == 0)) {
			T[] newArray = (T[])new Object[numberOfElements * CAPACITY_MULTIPLIER];
			//System.arraycopy(elements,0,newArray,0,numberOfElements); //
			for (int i = 0; i < numberOfElements; i++) {
				newArray[((i + front) % numberOfElements)] = elements[i];
			}
			front = 0;
			elements = newArray;
			rear = capacity;
			capacity = capacity * CAPACITY_MULTIPLIER; // expands capacity
		}
	}

}
