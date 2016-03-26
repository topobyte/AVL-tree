/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

import java.util.ArrayList;
import java.util.List;

import de.topobyte.adt.tree.TreeNode;
import de.topobyte.adt.tree.TreeNodePrePostVisitor;

public class TreeNodePrePostPrintVisitor<T> implements
		TreeNodePrePostVisitor<T>
{

	private List<T> elements = new ArrayList<>();

	@Override
	public void visitIn(TreeNode<? extends T> node, int depth)
	{
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			buffer.append("  ");
		}
		T element = node.getElement();
		if (depth > 0) {
			elements.add(element);
		}
		buffer.append(element == null ? "null" : element.toString());
		System.out.println(buffer.toString() + ": " + elements);
	}

	@Override
	public void visitOut(TreeNode<? extends T> node, int depth)
	{
		if (depth > 0) {
			elements.remove(elements.size() - 1);
		}
	}

}
