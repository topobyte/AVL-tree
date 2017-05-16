/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.slf4j;

import org.slf4j.Logger;

import de.topobyte.adt.tree.visitors.TreeNodePrintVisitor;
import de.topobyte.lineprinter.sfl4j.LogLevel;
import de.topobyte.lineprinter.sfl4j.LoggerPrinter;

public class Slf4jTreeNodePrintVisitor<T> extends TreeNodePrintVisitor<T>
{

	public Slf4jTreeNodePrintVisitor(Logger logger, LogLevel level,
			boolean printIndex)
	{
		super(new LoggerPrinter(logger, level), printIndex);
	}

}
