/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

import de.topobyte.adt.misc.Stack;
import de.topobyte.adt.tree.PrePostVisitor;
import de.topobyte.lineprinter.LinePrinter;

/**
 * A printer tree visitor that depicts the structure of a tree using ASCII
 * symbols. The output looks like this:
 * 
 * <pre>
 * null: []
 * `-de: [de]
 *   `-topobyte: [de, topobyte]
 *     |-bar: [de, topobyte, bar]
 *     |-cat: [de, topobyte, cat]
 *     | |-bars: [de, topobyte, cat, bars]
 *     | |-restaurants: [de, topobyte, cat, restaurants]
 *     | `-shops: [de, topobyte, cat, shops]
 *     |-foo: [de, topobyte, foo]
 *     `-test: [de, topobyte, test]
 * </pre>
 * 
 * @author Sebastian Kuerten
 */
public class FancyPrintVisitor<T> implements PrePostVisitor<T>
{

	private LinePrinter printer;

	private boolean printIndex;

	// These two fields are stacks that represent the current tree path.

	// This stores the the elements on the path.
	private Stack<T> elements = new Stack<>();
	// And for each node on the path whether it is the the last among its
	// siblings.
	private Stack<Boolean> last = new Stack<>();

	public FancyPrintVisitor(LinePrinter printer, boolean printIndex)
	{
		this.printer = printer;
		this.printIndex = printIndex;
	}

	@Override
	public void visitIn(T element, int depth, int index, int numSiblings)
	{
		boolean isLast = index == numSiblings - 1;

		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < depth - 1; i++) {
			boolean innerIsLast = last.asList().get(i);
			if (innerIsLast) {
				buffer.append("  ");
			} else {
				buffer.append("| ");
			}
		}
		if (depth > 0) {
			if (isLast) {
				buffer.append("`-");
			} else {
				buffer.append("|-");
			}
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

		if (depth > 0) {
			last.push(isLast);
		}

		buffer.append(element == null ? "null" : element.toString());
		printer.println(buffer.toString() + ": " + elements.asList());
	}

	@Override
	public void visitOut(T element, int depth, int index, int numSiblings)
	{
		if (depth > 0) {
			elements.pop();
			last.pop();
		}
	}

}
