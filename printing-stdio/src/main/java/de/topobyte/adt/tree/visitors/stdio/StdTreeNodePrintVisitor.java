/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.stdio;

import de.topobyte.adt.tree.visitors.TreeNodePrintVisitor;

public class StdTreeNodePrintVisitor<T> extends TreeNodePrintVisitor<T>
{

	public StdTreeNodePrintVisitor(boolean printIndex)
	{
		super(printIndex);
	}

	@Override
	protected void println(String line)
	{
		System.out.println(line);
	}

}
