/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.trees.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestInsert
{
	public static void main(String[] args)
	{
		int t = 10000; // number of insertions
		int max = 10000; // maximum value for elements

		System.out.println("TEST: Insertion");
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
			Collections.sort(list);

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
	}

}
