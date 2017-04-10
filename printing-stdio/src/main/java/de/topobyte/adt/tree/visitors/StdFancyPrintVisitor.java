/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

public class StdFancyPrintVisitor<T> extends FancyPrintVisitor<T>
{

	public StdFancyPrintVisitor(boolean printIndex)
	{
		super(printIndex);
	}

	@Override
	protected void println(String line)
	{
		System.out.println(line);
	}

}
