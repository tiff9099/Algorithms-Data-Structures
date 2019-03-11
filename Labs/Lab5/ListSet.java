//Lab 5- Tiffany Taghvaiee & Elsa Sveen 100
import java.util.Iterator;
import java.util.ArrayList;

public class ListSet<T> implements Set<T> {

	private ArrayList<T> elements = new ArrayList<T>();

	public void add(T element) {
		if (elements.contains(element) == false) {
			elements.add(element);
		}
	}

	public void addAll(T[] elements) { //
		for(int i=0; i < elements.length; i++) {
			this.elements.add(elements[i]);
		}
	}

	public boolean contains(T element) {
		return elements.contains(element); 
	}

	public int getSize() {
		return elements.size();
	}

	@Override
	public void remove(T element) {
		if (this.contains(element)) {
			elements.remove(element);
		}
	}

	public Set<T> union(Set<T> anotherSet) {
		Set<T> newSet = this.difference(anotherSet);
		for (int i =0; i < this.getSize(); i++) {
			if (anotherSet.contains(elements.get(i)) == false) {
				anotherSet.add((T) elements.get(i));
			}
		}
		return anotherSet;
	}

	public Set<T> intersection(Set<T> anotherSet) {
		Set newSet = new ListSet(); 
		for (int i=0; i < this.getSize(); i++) {
			if(anotherSet.contains((T) elements.get(i))) {
				newSet.add(elements.get(i));
			}
		}
		return newSet;
	}

	public Set<T> difference(Set<T> anotherSet) { //
		Set<T>newSet = new ListSet<T>();
		for (int i =0; i < this.getSize(); i++) {
			if (anotherSet.contains((T)elements.get(i)) == false) {
				newSet.add((T) elements.get(i));
			}
		}
		return newSet;
	}

	@Override
	public Iterator<T>iterator() {
		return elements.iterator();
	}

}


