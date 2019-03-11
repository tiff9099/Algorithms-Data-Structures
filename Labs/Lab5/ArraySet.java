//Lab 5- Tiffany Taghvaiee & Elsa Sveen 100

import java.util.Iterator;

public class ArraySet<T> implements Set<T> {

	public static final int DEFAULT_SIZE = 10;
	public static final int CAPACITY_MULTIPLIER = 2;
	private int size = 0;	
	private T[] elements;
	private int numberOfElements = 0;

	//ArraySet constructor created with default size
	public ArraySet() {
		this(DEFAULT_SIZE);
	}

	//ArraySet constructor created with specified size of 0
	public ArraySet(int size) {
		if (size < 0) {
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		this.size = size;
		this.elements = (T[]) new Object[size];
	}


	public void add(T element) {
		if (this.contains(element) == false) {
			ensureCapacity();
			elements[numberOfElements] = element;
			numberOfElements++;
		}

	}

	public void addAll(T[] elements) {
		if (this.contains((T) elements) == false) { 
			ensureCapacity();
			for (int i = 0; i < elements.length; i++) {
				add(elements[i]);	
			}
		}

	}

	public boolean contains(T element) { //?
		if (indexOf(element) > -1) {
			return true;
		}
		else {
			return false;
		}
	}


	public int getSize() {
		return numberOfElements;
	}

	public void remove(T element) {
		if (this.contains(element)) {
			elements[numberOfElements] = element;
			--numberOfElements;
		}
		else {
			return;
		}

	}

	public Set<T> union(Set<T> anotherSet) {
		Set newSet = anotherSet.difference(this);
		for (int i=0; i < numberOfElements; i++) {
			newSet.add(elements[i]);
		}
		return newSet;
	}

	public Set<T> intersection(Set<T> anotherSet) {
		Set newSet = new ArraySet(); 
		for (int i=0; i < elements.length; i++) {
			if(anotherSet.contains(elements[i]) == true) {
				newSet.add(elements[i]);
			}
		}
		return newSet;
	}

	public Set<T> difference(Set<T> anotherSet) {
		Set newSet = new ArraySet();
		for (int i = 0; i < numberOfElements; i++) {
			if (!anotherSet.contains(elements[i])) {
				newSet.add(elements[i]);
			}
		}
		return newSet;
	}

	public Iterator<T> iterator() {
		return new ArraySetIterator();
	}

	private class ArraySetIterator implements Iterator<T> {
		private int index =0;
		public boolean hasNext() {
			if (index < numberOfElements)
				return true;
			else
				return false;
		}

		public T next() {
			if (hasNext()) {
				T nextItem = elements[index];
				index++;

				return nextItem;
			}
			else
				throw new java.util.NoSuchElementException("No items remaining in the iteration.");
		}
	}

	private int indexOf(Object element) {
		int index = -1;
		for (int i = 0; i < numberOfElements; i++) {
			if (elements[i].equals(element)) {
				index = i;
				break;
			}
		}
		return index;
	}

	private void ensureCapacity() {
		if (numberOfElements == size) {
			Object[] newArray = new Object[(numberOfElements+1) * CAPACITY_MULTIPLIER];
			System.arraycopy(elements,0,newArray,0,numberOfElements);
			elements = (T[]) newArray;
		}
	}

}


