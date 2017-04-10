/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.tree.visitors.slf4j;

import org.slf4j.Logger;

public class LoggerPrinter
{

	private Logger logger;
	private LogLevel level;

	public LoggerPrinter(Logger logger, LogLevel level)
	{
		this.logger = logger;
		this.level = level;
	}

	public void println(String line)
	{
		switch (level) {
		default:
		case TRACE:
			logger.trace(line);
			break;
		case DEBUG:
			logger.debug(line);
			break;
		case INFO:
			logger.info(line);
			break;
		case WARN:
			logger.warn(line);
			break;
		case ERROR:
			logger.error(line);
			break;
		}
	}

}
