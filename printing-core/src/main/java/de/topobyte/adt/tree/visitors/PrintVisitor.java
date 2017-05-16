/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

import de.topobyte.adt.tree.Visitor;
import de.topobyte.lineprinter.LinePrinter;

public class PrintVisitor<T> implements Visitor<T>
{

	private LinePrinter printer;

	private boolean printIndex;

	public PrintVisitor(LinePrinter printer, boolean printIndex)
	{
		this.printer = printer;
		this.printIndex = printIndex;
	}

	@Override
	public void visit(T element, int depth, int index, int numSiblings)
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

		buffer.append(element);
		printer.println(buffer.toString());
	}

}
