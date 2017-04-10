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

public class TestIteratorRemoval
{

	@Test
	public void test()
	{
		int t = 3000; // number of insertions
		int max = 10000; // maximum value for elements

		System.out.println("TEST: Iterator with removal");
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

		Collections.sort(list);

		System.out.println("testing iterator removal");
		checkIdentity(tree, list);
		checkIterator(tree, list);
		checkIdentity(tree, list);

		System.out.println("done");
	}

	private static void checkIdentity(AvlTree<Integer> tree, List<Integer> list)
	{
		TestHelper.assertEqual(list, tree);
	}

	private static void checkIterator(AvlTree<Integer> tree, List<Integer> list)
	{
		Random random = new Random(2);
		Iterator<Integer> treeIter = tree.iterator();
		Iterator<Integer> listIter = list.iterator();
		while (treeIter.hasNext()) {
			Integer treeVal = treeIter.next();
			Integer listVal = listIter.next();
			Assert.assertEquals("iterator returned wrong value", listVal,
					treeVal);
			if (random.nextBoolean()) {
				treeIter.remove();
				listIter.remove();
			}
		}
	}

}
