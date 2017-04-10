/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.trees.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class TestIndexOf
{

	@Test
	public void test()
	{
		int t = 10000; // number of insertions
		int max = 10000; // maximum value for elements

		System.out.println("TEST: IndexOf");
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

		System.out.println("testing indexOf()");

		Collections.sort(list);
		check(tree, list);

		System.out.println("done");
	}

	private static void check(AvlTree<Integer> tree, List<Integer> list)
	{
		TestHelper.assertEqual(list, tree);

		for (int i = 0; i < tree.size(); i++) {
			int element = tree.get(i);
			int index = tree.indexOf(element);
			if (i != index) {
				System.out.println("indexOf() returned wrong value");
				System.out.println("expected: " + i);
				System.out.println("returned: " + index);
				Assert.fail("indexOf");
			}
		}
	}

}
