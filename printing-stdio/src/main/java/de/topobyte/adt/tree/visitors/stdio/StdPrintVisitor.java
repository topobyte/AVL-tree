/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.stdio;

import de.topobyte.adt.tree.visitors.PrintVisitor;
import de.topobyte.lineprinter.SystemOutPrinter;

public class StdPrintVisitor<T> extends PrintVisitor<T>
{

	public StdPrintVisitor(boolean printIndex)
	{
		super(new SystemOutPrinter(), printIndex);
	}

}
