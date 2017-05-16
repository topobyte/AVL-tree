/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

import de.topobyte.adt.misc.Stack;
import de.topobyte.adt.tree.PrePostVisitor;
import de.topobyte.lineprinter.LinePrinter;

public class PrePostPrintVisitor<T> implements PrePostVisitor<T>
{

	private LinePrinter printer;

	private boolean printIndex;

	private Stack<T> elements = new Stack<>();

	public PrePostPrintVisitor(LinePrinter printer, boolean printIndex)
	{
		this.printer = printer;
		this.printIndex = printIndex;
	}

	@Override
	public void visitIn(T element, int depth, int index, int numSiblings)
	{
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			buffer.append("  ");
		}

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
		printer.println(buffer.toString() + ": " + elements.asList());
	}

	@Override
	public void visitOut(T element, int depth, int index, int numSiblings)
	{
		if (depth > 0) {
			elements.pop();
		}
	}

}
