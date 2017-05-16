/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.stdio;

import de.topobyte.adt.tree.visitors.TreeNodePrePostPrintVisitor;
import de.topobyte.lineprinter.SystemOutPrinter;

public class StdTreeNodePrePostPrintVisitor<T>
		extends TreeNodePrePostPrintVisitor<T>
{

	public StdTreeNodePrePostPrintVisitor(boolean printIndex)
	{
		super(new SystemOutPrinter(), printIndex);
	}

}
