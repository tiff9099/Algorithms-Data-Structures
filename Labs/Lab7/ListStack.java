//Lab 6: Abstract Lists, Stacks, and Queues
//Tiffany Taghvaiee & Elsa Sveen

import java.util.ArrayList;

public class ListStack<T> implements Stack<T> {

	private ArrayList<T> elements = new ArrayList<T>();
	private int index = 0;

	public void push(T item) {
		this.elements.add(index, item);
		index++;
	}

	public T pop() {
		if (!this.isEmpty()) {
			T result = this.elements.remove(index-1);
			index--;
			return result;
		}
		return null;
	}

	public T peek() {
		if (!this.isEmpty()) {
			return this.elements.get(index-1);
		}
		return null;
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}
}
