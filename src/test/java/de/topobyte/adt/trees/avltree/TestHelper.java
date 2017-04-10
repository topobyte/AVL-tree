/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.trees.avltree;

import java.util.List;

import org.junit.Assert;

public class TestHelper
{

	public static String print(List<Integer> list)
	{
		StringBuffer strb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			strb.append(list.get(i));
			if (i < list.size() - 1) {
				strb.append(", ");
			}
		}
		return strb.toString();
	}

	public static boolean identical(List<Integer> list1, List<Integer> list2)
	{
		if (list1.size() != list2.size()) {
			return false;
		}
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		return true;
	}

	public static void assertEqual(List<Integer> list, AvlTree<Integer> tree)
	{
		Assert.assertEquals("size", list.size(), tree.size());
		boolean equal = TestHelper.identical(tree.elementsAsList(), list);
		if (!equal) {
			System.out.println("equality error");
			System.out.println(TestHelper.print(tree.elementsAsList()));
			System.out.println(TestHelper.print(list));
			Assert.fail("equality");
		}
	}

}
