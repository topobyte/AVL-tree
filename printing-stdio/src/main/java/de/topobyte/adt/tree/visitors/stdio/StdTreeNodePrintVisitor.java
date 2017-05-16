/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.stdio;

import de.topobyte.adt.tree.visitors.TreeNodePrintVisitor;
import de.topobyte.lineprinter.SystemOutPrinter;

public class StdTreeNodePrintVisitor<T> extends TreeNodePrintVisitor<T>
{

	public StdTreeNodePrintVisitor(boolean printIndex)
	{
		super(new SystemOutPrinter(), printIndex);
	}

}
