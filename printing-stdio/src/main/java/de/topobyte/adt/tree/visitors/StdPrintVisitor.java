/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors;

public class StdPrintVisitor<T> extends PrintVisitor<T>
{

	public StdPrintVisitor(boolean printIndex)
	{
		super(printIndex);
	}

	@Override
	protected void println(String line)
	{
		System.out.println(line);
	}

}
