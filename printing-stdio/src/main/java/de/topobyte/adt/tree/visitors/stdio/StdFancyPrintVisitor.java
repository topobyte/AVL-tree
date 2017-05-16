/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.stdio;

import de.topobyte.adt.tree.visitors.FancyPrintVisitor;
import de.topobyte.lineprinter.SystemOutPrinter;

public class StdFancyPrintVisitor<T> extends FancyPrintVisitor<T>
{

	public StdFancyPrintVisitor(boolean printIndex)
	{
		super(new SystemOutPrinter(), printIndex);
	}

}
