/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

import de.topobyte.adt.tree.TreeNode;
import de.topobyte.adt.tree.TreeNodeVisitor;
import de.topobyte.lineprinter.LinePrinter;

public class TreeNodePrintVisitor<T> implements TreeNodeVisitor<T>
{

	private LinePrinter printer;

	private boolean printIndex;

	public TreeNodePrintVisitor(LinePrinter printer, boolean printIndex)
	{
		this.printer = printer;
		this.printIndex = printIndex;
	}

	@Override
	public void visit(TreeNode<? extends T> node, int depth, int index,
			int numSiblings)
	{
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			buffer.append("  ");
		}

		if (printIndex) {
			buffer.append("[");
			buffer.append(index);
			buffer.append("/");
			buffer.append(numSiblings);
			buffer.append("] ");
		}

		T element = node.getElement();
		buffer.append(element == null ? "null" : element.toString());
		printer.println(buffer.toString());
	}

}
