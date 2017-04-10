/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.slf4j;

import org.slf4j.Logger;

import de.topobyte.adt.tree.visitors.TreeNodePrintVisitor;

public class Slf4jTreeNodePrintVisitor<T> extends TreeNodePrintVisitor<T>
{

	private LoggerPrinter printer;

	public Slf4jTreeNodePrintVisitor(Logger logger, LogLevel level,
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
