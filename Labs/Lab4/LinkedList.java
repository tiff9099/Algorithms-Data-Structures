/**
 * Implementation of the List interface.
 * 
 * This program implements several methods for a linked list.
 * @author Tiffany Taghvaiee - 07 Feb 2019
 */
 
public class LinkedList implements List {
	private Node head; // reference to the head of the linked list
	private int numberOfElements; 	// number of elements in the list

	public LinkedList() {
		head = null;
	}

	//private class that represents a node in the linked list
	private class Node
	{
		private Object data;
		private Node next;

		private Node(Object data) {
			this(data,null);
		}

		private Node (Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	@Override
	public void add(Object item) {

		// adds an item to the rear of the list
		Node newNode = new Node(item);
		Node current = head;

		if (isEmpty()) {
			//first element being added to the list
			head = newNode;
		}
		else {
			while (current.next != null) {
				current = current.next;
			}
			// current now references the last item in the list
			current.next = newNode;
		}
		newNode.next = null;
		++numberOfElements;
	}

	@Override
	public boolean add(Object item, int index) {

		Node newNode = new Node(item);
		Node current = head;
		int currentIndex = 0;
		Node rv = null;

		if(isEmpty()) {
			//first element being added to the list
			head = newNode;
		}

		if(index == 0){
			//element is being added to the first position
			head = newNode;
			head.next = current;
		}
		else {
			while(currentIndex < (index - 1)) {
				current = current.next;
				currentIndex++;
			}

			rv = current.next;
			current.next = newNode;
			newNode.next = rv;
		}
		++numberOfElements;
		return false;
	}

	@Override
	public boolean contains(Object item) {
		Node current = head;
		boolean found = false;

		while (current != null && !found) {
			if (current.data.equals(item)) {
				found = true;
			}

			current = current.next;
		}

		return found;

	}

	@Override
	public Object get(int index) {
		int currentIndex = 0;
		Node current = head;
		Object rv = head.data;

		if(index < numberOfElements) {
			while (currentIndex < (index)) {
				current = current.next;
				rv = current.data;
				currentIndex++;
			}
			return rv;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean remove(Object item) {
		boolean removable;

		if(isEmpty() || contains(item) == false) {
			removable = false;
		}
		else {
			Node current = head;
			Node rv = head;	// Saves previous node
			int currentIndex = 0;
			boolean stop = false;

			//element is being removed from the first position
			if(get(0).equals(item)) {
				head = current.next;
				numberOfElements--;
				removable = true;
			}
			else {
				while(stop == false) {
					if(get(currentIndex).equals(item)) {
						stop = true;
					}
					else {
						rv = current;
						current = current.next;
						currentIndex++;
					}
				}
				rv.next = current.next;
				numberOfElements--;			

				removable = true;
			}
		}
		return removable;
	}

	@Override
	public Object remove(int index) {
		Object rv = null;

		if (isEmpty() || index >= numberOfElements) {
			rv = null;
		}
		else if (index == 0) {
			//first element in the list
			rv = head.data;
			head = head.next;
			numberOfElements--;
		}
		else {
			int currentIndex = 0;
			Node current = head;

			while (currentIndex < (index - 1)) {
				current = current.next;
				currentIndex++;
			}
			// current references the node we want to remove
			rv = current.next.data;
			current.next = current.next.next;
			numberOfElements--;
		}
		return rv;
	}

	@Override
	public int getLength() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		if(head == null) {
			return true; //is empty
		}
		else {
			return false; //is not empty
		} 
	}

	@Override
	public int getFrequency(Object item) { 
		int index=0;
		int frequency=0;

		while (index<numberOfElements) {
			if (get(index).equals(item)) {
				frequency++;
			}
			index++;
		}
		return frequency;
	}

	@Override
	public void clear() {
		head= null;
	}
}
