/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

public class StdPrePostPrintVisitor<T> extends PrePostPrintVisitor<T>
{

	public StdPrePostPrintVisitor(boolean printIndex)
	{
		super(printIndex);
	}

	@Override
	protected void println(String line)
	{
		System.out.println(line);
	}

}
