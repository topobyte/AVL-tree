/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

import de.topobyte.adt.tree.TreeNode;
import de.topobyte.adt.tree.TreeNodeVisitor;

public class TreeNodePrintVisitor<T> implements TreeNodeVisitor<T>
{

	@Override
	public void visit(TreeNode<? extends T> node, int depth)
	{
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			buffer.append("  ");
		}
		T element = node.getElement();
		buffer.append(element == null ? "null" : element.toString());
		System.out.println(buffer.toString());
	}

}
