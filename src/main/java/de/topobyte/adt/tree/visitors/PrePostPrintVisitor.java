/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

import java.util.ArrayList;
import java.util.List;

import de.topobyte.adt.tree.PrePostVisitor;
import de.topobyte.adt.tree.TreeNode;

public class PrePostPrintVisitor<T> implements PrePostVisitor<TreeNode<T>>
{

	private boolean printIndex;

	private List<T> elements = new ArrayList<>();

	public PrePostPrintVisitor(boolean printIndex)
	{
		this.printIndex = printIndex;
	}

	@Override
	public void visitIn(TreeNode<T> node, int depth, int index, int numSiblings)
	{
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			buffer.append("  ");
		}
		T element = node.getElement();
		if (depth > 0) {
			elements.add(element);
		}

		if (printIndex) {
			buffer.append("[");
			buffer.append(index);
			buffer.append("/");
			buffer.append(numSiblings);
			buffer.append("] ");
		}

		buffer.append(element == null ? "null" : element.toString());
		System.out.println(buffer.toString() + ": " + elements);
	}

	@Override
	public void visitOut(TreeNode<T> element, int depth, int index,
			int numSiblings)
	{
		if (depth > 0) {
			elements.remove(elements.size() - 1);
		}
	}

}
