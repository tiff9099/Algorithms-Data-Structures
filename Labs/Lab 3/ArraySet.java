/* 
 * Tiffany Taghvaiee- Lab 3: Java Interfaces and ADTs; Lab Partner: Elsa Sveen
 */
 
public class ArraySet implements Set {

	public static final int DEFAULT_SIZE = 10;
	public static final int CAPACITY_MULTIPLIER = 2;
	private int size = 0;	
	private Object[] elements;
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
		this.elements = new Object[size];
	}

	@Override //Adds item to ArraySet
	public void add(Object element) {
		if (this.contains(element) == false) {
			ensureCapacity();
			elements[numberOfElements] = element;
			numberOfElements++;
		}
		else {
			return;
		}
	}

	@Override //Adds entire array to ArraySet
	public void addAll(Object[] elements) {
		if (this.contains(elements) == false) { 
			ensureCapacity();
			for (int i = 0; i < elements.length; i++) {
				add(elements[i]);	
			}
		}
		else {
			return;
		}
	}

	//Searches ArraySet for certain element
	@Override
	public boolean contains(Object element) {
		if (indexOf(element) > -1) 
			return true;

		else
			return false;
	}

	@Override //Retrieves size of ArraySet
	public int getSize() { 
		return numberOfElements;
	}

	@Override //Removes certain element from ArraySet
	public void remove(Object element) {
		if (this.contains(element)) {
			elements[numberOfElements] = element;
			--numberOfElements;
		}
		else {
			return;
		}
	}

	@Override 
	public Set union(Set anotherSet) { //
		Set newSet = anotherSet.difference(this);
		for (int i=0; i < numberOfElements; i++) {
			newSet.add(elements[i]);
		}
		return newSet;
	}

	@Override
	public Set intersection (Set anotherSet) { //?
		Set newSet = new ArraySet(); 
			for (int i=0; i < elements.length; i++) {
				if(anotherSet.contains(elements[i]) == true) {
					newSet.add(elements[i]);
				}
			}
			return newSet;
	}

	@Override
	public Set difference(Set anotherSet) { //
		Set newSet = new ArraySet();
		 for (int i = 0; i < numberOfElements; i++) {
	        	if (!anotherSet.contains(elements[i])) {
	        		newSet.add(elements[i]);
	        }
		}
		return newSet;
	}

	//Returns index of an element
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
			elements = newArray;
		}
	}

}
