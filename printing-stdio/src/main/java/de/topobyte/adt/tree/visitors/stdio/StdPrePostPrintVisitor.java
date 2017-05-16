/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.stdio;

import de.topobyte.adt.tree.visitors.PrePostPrintVisitor;
import de.topobyte.lineprinter.SystemOutPrinter;

public class StdPrePostPrintVisitor<T> extends PrePostPrintVisitor<T>
{

	public StdPrePostPrintVisitor(boolean printIndex)
	{
		super(new SystemOutPrinter(), printIndex);
	}

}
