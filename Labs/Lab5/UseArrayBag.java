//Lab 5- Tiffany Taghvaiee & Elsa Sveen 100

import java.util.Iterator;

public class UseArrayBag {
	public static void main(String[] args) {
		ArrayBag <String> a = new ArrayBag<String>();
		a.add("Apple");
		a.add("Banana");
		a.add("Cherry");
		a.add("Donut");
		a.add("Eggs");
		
		Iterator<String> i = a.iterator(); 
		
		while (i.hasNext()) {
		System.out.println(i.next());
		}
 	}

}
