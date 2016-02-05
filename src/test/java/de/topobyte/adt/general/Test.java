/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.general;

import de.topobyte.adt.tree.TreeNode;
import de.topobyte.adt.tree.TreeUtil;
import de.topobyte.adt.tree.Visitor;

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

		TreeUtil.traversePreorder(tree, new Visitor<TreeNode<String>>() {

			@Override
			public void visit(TreeNode<String> node, int depth)
			{
				StringBuilder buffer = new StringBuilder();
				for (int i = 0; i < depth; i++) {
					buffer.append("  ");
				}
				String element = node.getElement();
				buffer.append(element == null ? "null" : element.toString());
				System.out.println(buffer.toString());
			}
		});
	}

}
