/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.sorted;

import de.topobyte.adt.tree.TreeUtil;
import de.topobyte.adt.tree.visitors.PrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.TreeNodePrintVisitor;
import de.topobyte.adt.tree.visitors.stdio.StdPrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.stdio.StdTreeNodePrintVisitor;

public class Test
{

	public static void main(String[] args)
	{
		SortedTree<String> tree = new SortedTree<>();

		System.out.println(tree.getHeight());

		Trees.small(tree);

		System.out.println(tree.getHeight());

		TreeNodePrintVisitor<String> printer = new StdTreeNodePrintVisitor<>(
				true);
		TreeUtil.traversePreorder(tree, printer);

		PrePostPrintVisitor<String> printer2 = new StdPrePostPrintVisitor<>(
				true);
		TreeUtil.traverse(tree, printer2);
	}

}
