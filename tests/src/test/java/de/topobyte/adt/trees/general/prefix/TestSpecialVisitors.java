/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.topobyte.adt.tree.TreeNode;
import de.topobyte.adt.tree.TreeUtil;

public class TestSpecialVisitors
{

	public static void main(String[] args)
	{
		PackageTree<Boolean> tree = TestData.testTree();

		PackageTreeVisitor<Boolean> visitor1 = new PackageTreeVisitor<Boolean>() {

			@Override
			public void visit(TreeNode<PackageNode<Boolean>> element, int depth,
					int index, int numSiblings)
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
			public void visit(TreeNode<PackageNode<Boolean>> element, int depth,
					int index, int numSiblings)
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
