/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.trees.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class TestIterator
{

	@Test
	public void test()
	{
		int t = 3000; // number of insertions
		int max = 10000; // maximum value for elements

		System.out.println("TEST: Iterator");
		System.out.println("performing " + t + " insertions");

		AvlTree<Integer> tree = new AvlTree<>();
		List<Integer> list = new ArrayList<>();

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
		TestHelper.assertEqual(list, tree);

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
			Assert.fail(
					"iterator did not return the expected number of elements");
		}
	}

}
