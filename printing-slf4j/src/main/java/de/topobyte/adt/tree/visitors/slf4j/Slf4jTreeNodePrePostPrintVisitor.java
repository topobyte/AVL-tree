/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.slf4j;

import org.slf4j.Logger;

import de.topobyte.adt.tree.visitors.TreeNodePrePostPrintVisitor;

public class Slf4jTreeNodePrePostPrintVisitor<T>
		extends TreeNodePrePostPrintVisitor<T>
{

	private LoggerPrinter printer;

	public Slf4jTreeNodePrePostPrintVisitor(Logger logger, LogLevel level,
			boolean printIndex)
	{
		super(printIndex);
		printer = new LoggerPrinter(logger, level);
	}

	@Override
	protected void println(String line)
	{
		printer.println(line);
	}

}
