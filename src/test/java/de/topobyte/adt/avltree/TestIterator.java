/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TestIterator
{
	public static void main(String[] args)
	{
		int t = 3000; // number of insertions
		int max = 10000; // maximum value for elements

		System.out.println("TEST: Iterator");
		System.out.println("performing " + t + " insertions");

		AvlTree<Integer> tree = new AvlTree<Integer>();
		List<Integer> list = new ArrayList<Integer>();

		Random random = new Random(2);

		for (int i = 0; i < t; i++) {
			int n = 0;
			while (true) {
				n = random.nextInt(max);
				if (!list.contains(n)) {
					break;
				}
			}
			tree.insertElement(n);
			list.add(n);

		}

		System.out.println("testing iterator");
		
		Collections.sort(list);
		check(tree, list);
		
		// now remove all elements
		while (list.size() > 0) {
			// remove
			int index = random.nextInt(list.size());
			int value = list.get(index);
			tree.removeElement(value);
			list.remove(new Integer(value));

			check(tree, list);
		}


		System.out.println("done");
	}

	private static void check(AvlTree<Integer> tree, List<Integer> list)
	{
		if (tree.size() != list.size()) {
			System.out.println("size error");
			System.exit(1);
		}
		if (!TestHelper.identical(tree.elementsAsList(), list)) {
			System.out.println("equality error");
			System.out.println(TestHelper.print(tree.elementsAsList()));
			System.out.println(TestHelper.print(list));
			System.exit(1);
		}

		int n = 0;

		Iterator<Integer> iterator = tree.iterator();
		while (iterator.hasNext()) {
			int next = iterator.next();
			if (list.get(n) != next) {
				System.out.println("wrong value");
			}
			n++;
		}

		if (n != tree.size()) {
			System.out
					.println("iterator did not return the expected number of elements");
			System.exit(1);
		}
	}

}
