//Lab 6: Abstract Lists, Stacks, and Queues
//Tiffany Taghvaiee & Elsa Sveen

public class ArrayStack<T> implements Stack<T> {
	private T[] elements;
	public static final int CAPACITY_MULTIPLIER = 2;
	public static int DEFAULT_CAPACITY = 15;
	private int capacity; //
	private int numberOfElements = 0; //index 

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity must be >= 0");
		}

		this.capacity = capacity;
		elements = (T[])new Object[capacity];
	}

	public void push(T item) {
		ensureCapacity();
		this.elements[this.numberOfElements]= item;
		numberOfElements++;
	}

	public T pop() { //?
		if (!this.isEmpty()) {
			return this.elements[--this.numberOfElements]; 
		}
		return null;
	}

	public T peek() {
		if (!this.isEmpty()) {
			return this.elements[this.numberOfElements-1];
		}
		return null;
	}

	public boolean isEmpty() {
		if (this.numberOfElements == 0) {
			return true;
		}
		return false;
	}

	private void ensureCapacity() {
		if (numberOfElements == capacity) {
			T[] newArray = (T[])new Object[(numberOfElements+1) * CAPACITY_MULTIPLIER];
			System.arraycopy(elements,0,newArray,0,numberOfElements);
			elements = newArray;
			capacity = capacity * CAPACITY_MULTIPLIER; // expands capacity
		}
	}

}
