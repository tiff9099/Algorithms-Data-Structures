/*
 * Tiffany Taghvaiee & Elsa Sveen- Lab 7: Queues & Palindromes
 * 
 * Implementing a Queue interface; Designing an algorithm that detects palindromes
 */

import java.util.ArrayList; //use an arraylist to store the things inside of a queue

public class ListQueue<T> implements Queue<T> {
	private ArrayList<T> elements = new ArrayList<T>();
	
	public void add(T item) {
		elements.add(item);
	}

	public T remove() {
		if (!elements.isEmpty()) {
			return elements.remove(0); 
		}
		return null;
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public int size() {
		return elements.size();
	}

}
