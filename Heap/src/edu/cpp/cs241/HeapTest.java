package edu.cpp.cs241;

public class HeapTest {

	public static void main(String[] args) {
		Heap h = new Heap();
		h.add(11);
		h.add(5);
		h.add(8);
		h.add(3);
		h.add(4);
		h.add(15);
		System.out.println(h);

		System.out.println(h.getSize());
		System.out.println(h.getMax());

		System.out.println(h.removeMax());
		System.out.println(h);

		System.out.println(h.removeMax());
		System.out.println(h);

		System.out.println(h.removeMax());
		System.out.println(h);

		System.out.println(h.removeMax());
		System.out.println(h);
	}

}
