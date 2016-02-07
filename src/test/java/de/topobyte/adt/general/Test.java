/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.general;

import de.topobyte.adt.tree.TreeUtil;
import de.topobyte.adt.tree.visitors.PrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.PrintVisitor;

public class Test
{

	public static void main(String[] args)
	{
		SortedTree<String> tree = new SortedTree<>();
		Node<String> root = tree.getRoot();

		System.out.println(tree.getHeight());

		Node<String> foo = root.add("foo");
		Node<String> bar = root.add("bar");
		bar.add("cat");
		bar.add("tomcat");
		foo.add("bar again");

		System.out.println(tree.getHeight());

		PrintVisitor<String> printer = new PrintVisitor<>();
		TreeUtil.traversePreorder(tree, printer);

		PrePostPrintVisitor<String> printer2 = new PrePostPrintVisitor<>();
		TreeUtil.traverse(tree, printer2);
	}

}
