/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class TestListIteratorWithIndex
{
	public static void main(String[] args)
	{
		int t = 2000; // number of insertions
		int max = 10000; // maximum value for elements

		System.out.println("TEST: List iterator with index");
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

		System.out.println("testing list iterator");

		Collections.sort(list);

		for (int i = 0; i <= list.size(); i++) {
			check(tree, list, i);
		}

		System.out.println("done");
	}

	private static void check(AvlTree<Integer> tree, List<Integer> list, int index)
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

		Random random = new Random(2);

		ListIterator<Integer> it1 = tree.listIterator(index);
		ListIterator<Integer> it2 = list.listIterator(index);

		int i = 0;
		while (true) {
			i++;
			checkIndex(it1, it2);
			int r = random.nextInt(3);
			boolean b = r < 2;
			if (b) {
				if (it1.hasNext() != it2.hasNext()) {
					System.out.println("hasNext() is wrong");
					System.exit(1);
				}
				if (it1.hasNext()) {
					int n1 = it1.next();
					int n2 = it2.next();
					if (n1 != n2) {
						System.out.println("next(): wrong value");
					}
				} else if (i > 100) {
					break;
				}
			} else {
				if (it1.hasPrevious() != it2.hasPrevious()) {
					System.out.println("hasPrevious() is wrong");
					System.exit(1);
				}
				if (it1.hasPrevious()) {
					int p1 = it1.previous();
					int p2 = it2.previous();
					if (p1 != p2) {
						System.out.println("previous(): wrong value");
					}
				}
			}
		}
	}

	private static void checkIndex(ListIterator<Integer> it1,
			ListIterator<Integer> it2)
	{
		if (it1.nextIndex() != it2.nextIndex())  {
			System.out.println("nextIndex() wrong");
			System.exit(1);
		}
		if (it1.previousIndex() != it2.previousIndex()) {
			System.out.println("previousIndex() wrong");
			System.exit(1);
		}
	}

}
