/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.slf4j;

import org.slf4j.Logger;

import de.topobyte.adt.tree.visitors.FancyPrintVisitor;
import de.topobyte.lineprinter.sfl4j.LogLevel;
import de.topobyte.lineprinter.sfl4j.LoggerPrinter;

public class Slf4jFancyPrintVisitor<T> extends FancyPrintVisitor<T>
{

	public Slf4jFancyPrintVisitor(Logger logger, LogLevel level,
			boolean printIndex)
	{
		super(new LoggerPrinter(logger, level), printIndex);
	}

}
