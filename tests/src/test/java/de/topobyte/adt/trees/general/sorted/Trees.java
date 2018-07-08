/**
 * Copyright (C) 2018 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.sorted;

public class Trees
{

	static void small(SortedTree<String> tree)
	{
		Node<String> root = tree.getRoot();
		Node<String> foo = root.add("foo");
		Node<String> bar = root.add("bar");
		bar.add("cat");
		bar.add("tomcat");
		foo.add("bar again");
	}

}
