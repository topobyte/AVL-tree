/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.stdio;

import de.topobyte.adt.tree.visitors.TreeNodePrePostPrintVisitor;

public class StdTreeNodePrePostPrintVisitor<T>
		extends TreeNodePrePostPrintVisitor<T>
{

	public StdTreeNodePrePostPrintVisitor(boolean printIndex)
	{
		super(printIndex);
	}

	@Override
	protected void println(String line)
	{
		System.out.println(line);
	}

}
