/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.topobyte.adt.tree.TreeNode;
import de.topobyte.adt.tree.TreeNodeVisitor;
import de.topobyte.adt.tree.TreeUtil;
import de.topobyte.adt.tree.visitors.FancyPrintVisitor;
import de.topobyte.adt.tree.visitors.PrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.PrintVisitor;
import de.topobyte.adt.tree.visitors.TreeNodePrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.TreeNodePrintVisitor;

public class TestTreeVisitors
{

	public static void main(String[] args)
	{
		List<Package> packages = new ArrayList<>();
		packages.add(new Package("de", "topobyte", "test"));
		packages.add(new Package("de", "topobyte", "foo"));
		packages.add(new Package("de", "topobyte", "bar"));
		packages.add(new Package("de", "topobyte", "cat", "shops"));
		packages.add(new Package("de", "topobyte", "cat", "restaurants"));
		packages.add(new Package("de", "topobyte", "cat", "bars"));

		PackageTree<Boolean> tree = new PackageTree<>();
		for (Package p : packages) {
			tree.insert(p.getParts(), true);
		}

		System.out.println("Traverse using PrintVisitor");
		PrintVisitor<PackageNode<Boolean>> printer1 = new PrintVisitor<>(true);
		TreeUtil.traversePreorder(tree, printer1);

		System.out.println("Traverse using TreeNodePrintVisitor");
		TreeNodeVisitor<PackageNode<Boolean>> printer2 = new TreeNodePrintVisitor<>(
				true);
		TreeUtil.traversePreorder(tree, printer2);

		System.out.println("Traverse using PrePostPrintVisitor");
		PrePostPrintVisitor<PackageNode<Boolean>> printer3 = new PrePostPrintVisitor<>(
				true);
		TreeUtil.traverse(tree, printer3);

		System.out.println("Traverse using TreeNodePrePostPrintVisitor");
		TreeNodePrePostPrintVisitor<PackageNode<Boolean>> printer4 = new TreeNodePrePostPrintVisitor<>(
				true);
		TreeUtil.traverse(tree, printer4);

		System.out.println("Traverse using FancyPrintVisitor (no indexes)");
		FancyPrintVisitor<PackageNode<Boolean>> printer5 = new FancyPrintVisitor<>(
				false);
		TreeUtil.traverse(tree, printer5);

		System.out.println("Traverse using FancyPrintVisitor (with indexes)");
		FancyPrintVisitor<PackageNode<Boolean>> printer6 = new FancyPrintVisitor<>(
				true);
		TreeUtil.traverse(tree, printer6);

		System.out.println("tree.print()");
		tree.print();

		PackageTreeVisitor<Boolean> visitor1 = new PackageTreeVisitor<Boolean>() {

			@Override
			public void visit(TreeNode<PackageNode<Boolean>> element,
					int depth, int index, int numSiblings)
			{
				PackageNode<Boolean> node = element.getElement();
				if (node == null) {
					System.out.println("*root*");
				} else {
					System.out.println(node.toPackage());
				}
			}
		};

		System.out.println("Print packages");
		TreeUtil.traversePreorder(tree, visitor1);

		PackageTreeVisitor<Boolean> visitor2 = new PackageTreeVisitor<Boolean>() {

			@Override
			public void visit(TreeNode<PackageNode<Boolean>> element,
					int depth, int index, int numSiblings)
			{
				PackageNode<Boolean> node = element.getElement();
				if (node == null) {
					System.out.println("*root*");
				} else {
					System.out.println(node.toPackage());
					List<String> subs = subPackageNames(element);
					System.out.println("   -> " + subs);
				}
			}
		};

		System.out.println("Print packages with subpackages");
		TreeUtil.traversePreorder(tree, visitor2);
	}

	public static <A> List<String> subPackageNames(
			TreeNode<PackageNode<A>> packageNode)
	{
		List<String> names = new ArrayList<>(packageNode.getNumberOfChildren());
		for (int i = 0; i < packageNode.getNumberOfChildren(); i++) {
			TreeNode<PackageNode<A>> child = packageNode.getChild(i);
			names.add(child.getElement().getLabel());
		}
		Collections.sort(names);
		return names;
	}

}
