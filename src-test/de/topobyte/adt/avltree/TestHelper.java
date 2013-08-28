/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

import java.util.List;

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
}
