/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TestIteratorRemoval
{
	public static void main(String[] args)
	{
		int t = 3000; // number of insertions
		int max = 10000; // maximum value for elements

		System.out.println("TEST: Iterator with removal");
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

		Collections.sort(list);

		System.out.println("testing iterator removal");
		checkIdentity(tree, list);
		checkIterator(tree, list);
		checkIdentity(tree, list);

		System.out.println("done");
	}

	private static void checkIdentity(AvlTree<Integer> tree, List<Integer> list)
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
	}

	private static void checkIterator(AvlTree<Integer> tree, List<Integer> list)
	{
		Random random = new Random(2);
		Iterator<Integer> treeIter = tree.iterator();
		Iterator<Integer> listIter = list.iterator();
		while (treeIter.hasNext()) {
			Integer treeVal = treeIter.next();
			Integer listVal = listIter.next();
			if (!treeVal.equals(listVal)) {
				System.out.println("iterator returned wrong value");
				System.exit(1);
			}
			if (random.nextBoolean()) {
				treeIter.remove();
				listIter.remove();
			}
		}
	}

}
