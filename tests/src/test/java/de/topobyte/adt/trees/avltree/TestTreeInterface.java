/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.trees.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class TestTreeInterface
{

	@Test
	public void test()
	{
		int t = 16; // number of insertions
		int max = 99; // maximum value for elements
		int pad = 2; // number of chars to pad numbers to

		// max = 9; pad = 1; // this also works
		// max = 999; pad = 3; // or this
		// max = 9999; pad = 4; // works, too

		System.out.println("TEST: Tree interface");
		System.out.println("performing " + t + " insertions");

		AvlTree<Integer> tree = new AvlTree<>();
		List<Integer> list = new ArrayList<>();

		Random random = new Random(2);

		for (int i = 0; i < t && i < max + 1; i++) {
			int n = 0;
			while (true) {
				n = random.nextInt(max + 1);
				if (!list.contains(n)) {
					break;
				}
			}
			tree.insertElement(n);
			list.add(n);
			Collections.sort(list);

		}
		check(tree, list, pad);
	}

	private static void check(AvlTree<Integer> tree, List<Integer> list,
			int pad)
	{
		TestHelper.assertEqual(list, tree);

		TreePrinter printer = new TreePrinter(System.out, pad);
		printer.print(tree);
	}

}
