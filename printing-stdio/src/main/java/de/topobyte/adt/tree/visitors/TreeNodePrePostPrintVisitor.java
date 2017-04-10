/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

import de.topobyte.adt.misc.Stack;
import de.topobyte.adt.tree.TreeNode;
import de.topobyte.adt.tree.TreeNodePrePostVisitor;

public class TreeNodePrePostPrintVisitor<T> implements TreeNodePrePostVisitor<T>
{

	private boolean printIndex;

	private Stack<T> elements = new Stack<>();

	public TreeNodePrePostPrintVisitor(boolean printIndex)
	{
		this.printIndex = printIndex;
	}

	@Override
	public void visitIn(TreeNode<? extends T> node, int depth, int index,
			int numSiblings)
	{
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			buffer.append("  ");
		}
		T element = node.getElement();
		if (depth > 0) {
			elements.push(element);
		}

		if (printIndex) {
			buffer.append("[");
			buffer.append(index);
			buffer.append("/");
			buffer.append(numSiblings);
			buffer.append("] ");
		}

		buffer.append(element == null ? "null" : element.toString());
		System.out.println(buffer.toString() + ": " + elements.asList());
	}

	@Override
	public void visitOut(TreeNode<? extends T> node, int depth, int index,
			int numSiblings)
	{
		if (depth > 0) {
			elements.pop();
		}
	}

}
