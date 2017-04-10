/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.trees.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class TestListIterator
{

	@Test
	public void test()
	{
		int t = 3000; // number of insertions
		int max = 10000; // maximum value for elements

		System.out.println("TEST: List iterator");
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

		System.out.println("testing list iterator");

		Collections.sort(list);
		check(tree, list);

		System.out.println("done");
	}

	private static void check(AvlTree<Integer> tree, List<Integer> list)
	{
		TestHelper.assertEqual(list, tree);

		Random random = new Random(2);

		ListIterator<Integer> it1 = tree.listIterator();
		ListIterator<Integer> it2 = list.listIterator();

		int i = 0;
		while (true) {
			i++;
			int r = random.nextInt(3);
			boolean b = r < 2;
			if (b) {
				if (it1.hasNext() != it2.hasNext()) {
					Assert.fail("hasNext() is wrong");
				}
				if (it1.hasNext()) {
					int n1 = it1.next();
					int n2 = it2.next();
					if (n1 != n2) {
						System.out.println("next(): wrong value");
					}
				} else {
					break;
				}
			} else {
				if (it1.hasPrevious() != it2.hasPrevious()) {
					Assert.fail("hasPrevious() is wrong");
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

		System.out.println("iterations: " + i);
	}

}
