/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix;

import de.topobyte.adt.tree.TreeNodeVisitor;
import de.topobyte.adt.tree.TreeUtil;
import de.topobyte.adt.tree.visitors.FancyPrintVisitor;
import de.topobyte.adt.tree.visitors.PrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.PrintVisitor;
import de.topobyte.adt.tree.visitors.TreeNodePrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.stdio.StdFancyPrintVisitor;
import de.topobyte.adt.tree.visitors.stdio.StdPrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.stdio.StdPrintVisitor;
import de.topobyte.adt.tree.visitors.stdio.StdTreeNodePrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.stdio.StdTreeNodePrintVisitor;

public class TestTreeVisitorsStd
{

	public static void main(String[] args)
	{
		PackageTree<Boolean> tree = TestData.testTree();

		System.out.println("Traverse using PrintVisitor");
		PrintVisitor<PackageNode<Boolean>> printer1 = new StdPrintVisitor<>(
				true);
		TreeUtil.traversePreorder(tree, printer1);

		System.out.println("Traverse using TreeNodePrintVisitor");
		TreeNodeVisitor<PackageNode<Boolean>> printer2 = new StdTreeNodePrintVisitor<>(
				true);
		TreeUtil.traversePreorder(tree, printer2);

		System.out.println("Traverse using PrePostPrintVisitor");
		PrePostPrintVisitor<PackageNode<Boolean>> printer3 = new StdPrePostPrintVisitor<>(
				true);
		TreeUtil.traverse(tree, printer3);

		System.out.println("Traverse using TreeNodePrePostPrintVisitor");
		TreeNodePrePostPrintVisitor<PackageNode<Boolean>> printer4 = new StdTreeNodePrePostPrintVisitor<>(
				true);
		TreeUtil.traverse(tree, printer4);

		System.out.println("Traverse using FancyPrintVisitor (no indexes)");
		FancyPrintVisitor<PackageNode<Boolean>> printer5 = new StdFancyPrintVisitor<>(
				false);
		TreeUtil.traverse(tree, printer5);

		System.out.println("Traverse using FancyPrintVisitor (with indexes)");
		FancyPrintVisitor<PackageNode<Boolean>> printer6 = new StdFancyPrintVisitor<>(
				true);
		TreeUtil.traverse(tree, printer6);
	}

}
