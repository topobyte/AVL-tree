/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.slf4j;

import org.slf4j.Logger;

import de.topobyte.adt.tree.visitors.TreeNodePrePostPrintVisitor;
import de.topobyte.lineprinter.sfl4j.LogLevel;
import de.topobyte.lineprinter.sfl4j.LoggerPrinter;

public class Slf4jTreeNodePrePostPrintVisitor<T>
		extends TreeNodePrePostPrintVisitor<T>
{

	public Slf4jTreeNodePrePostPrintVisitor(Logger logger, LogLevel level,
			boolean printIndex)
	{
		super(new LoggerPrinter(logger, level), printIndex);
	}

}
