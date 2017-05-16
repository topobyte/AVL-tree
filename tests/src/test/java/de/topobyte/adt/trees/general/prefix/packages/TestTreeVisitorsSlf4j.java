/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix.packages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.topobyte.adt.tree.TreeNodeVisitor;
import de.topobyte.adt.tree.TreeUtil;
import de.topobyte.adt.tree.visitors.FancyPrintVisitor;
import de.topobyte.adt.tree.visitors.PrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.PrintVisitor;
import de.topobyte.adt.tree.visitors.TreeNodePrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.slf4j.Slf4jFancyPrintVisitor;
import de.topobyte.adt.tree.visitors.slf4j.Slf4jPrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.slf4j.Slf4jPrintVisitor;
import de.topobyte.adt.tree.visitors.slf4j.Slf4jTreeNodePrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.slf4j.Slf4jTreeNodePrintVisitor;
import de.topobyte.lineprinter.sfl4j.LogLevel;

public class TestTreeVisitorsSlf4j
{

	final static Logger logger = LoggerFactory.getLogger("Test");

	public static void main(String[] args)
	{
		PackageTree<Boolean> tree = TestData.testTree();

		LogLevel level = LogLevel.INFO;

		logger.info("Traverse using PrintVisitor");
		PrintVisitor<PackageNode<Boolean>> printer1 = new Slf4jPrintVisitor<>(
				logger, level, true);
		TreeUtil.traversePreorder(tree, printer1);

		logger.info("Traverse using TreeNodePrintVisitor");
		TreeNodeVisitor<PackageNode<Boolean>> printer2 = new Slf4jTreeNodePrintVisitor<>(
				logger, level, true);
		TreeUtil.traversePreorder(tree, printer2);

		logger.info("Traverse using PrePostPrintVisitor");
		PrePostPrintVisitor<PackageNode<Boolean>> printer3 = new Slf4jPrePostPrintVisitor<>(
				logger, level, true);
		TreeUtil.traverse(tree, printer3);

		logger.info("Traverse using TreeNodePrePostPrintVisitor");
		TreeNodePrePostPrintVisitor<PackageNode<Boolean>> printer4 = new Slf4jTreeNodePrePostPrintVisitor<>(
				logger, level, true);
		TreeUtil.traverse(tree, printer4);

		logger.info("Traverse using FancyPrintVisitor (no indexes)");
		FancyPrintVisitor<PackageNode<Boolean>> printer5 = new Slf4jFancyPrintVisitor<>(
				logger, level, false);
		TreeUtil.traverse(tree, printer5);

		logger.info("Traverse using FancyPrintVisitor (with indexes)");
		FancyPrintVisitor<PackageNode<Boolean>> printer6 = new Slf4jFancyPrintVisitor<>(
				logger, level, true);
		TreeUtil.traverse(tree, printer6);
	}

}
