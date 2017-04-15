/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import de.topobyte.adt.tree.TreeUtil;
import de.topobyte.adt.tree.Visitor;
import de.topobyte.adt.tree.visitors.stdio.StdFancyPrintVisitor;
import de.topobyte.adt.tree.visitors.stdio.StdPrintVisitor;

public class TestPrefixTree
{

	public static void main(String[] args)
	{
		StringPrefixTree<Integer> tree = new StringPrefixTree<>();

		tree.insert(Arrays.asList("a", "b", "c"), 1);
		tree.insert(Arrays.asList("a", "b", "d"), 2);
		tree.insert(Arrays.asList("b", "c"), 3);

		print(tree);

		tree.insert(Collections.<String> emptyList(), 4);

		print(tree);
	}

	private static void print(StringPrefixTree<Integer> tree)
	{
		TreeUtil.traversePreorder(tree, visitor);

		StdPrintVisitor<StringPrefixNode<Integer>> printer = new StdPrintVisitor<>(
				false);
		TreeUtil.traversePreorder(tree, printer);

		StdFancyPrintVisitor<StringPrefixNode<Integer>> fancyPrinter = new StdFancyPrintVisitor<>(
				false);
		TreeUtil.traverse(tree, fancyPrinter);
	}

	static Visitor<StringPrefixNode<Integer>> visitor = new Visitor<StringPrefixNode<Integer>>() {

		@Override
		public void visit(StringPrefixNode<Integer> element, int depth,
				int index, int numSiblings)
		{
			StringBuilder buffer = new StringBuilder();
			for (int i = 0; i < depth; i++) {
				buffer.append("  ");
			}

			if (element.isRootNode()) {
				buffer.append("root");
			} else {
				buffer.append(element.toString());
			}
			if (element != null) {
				Integer number = element.getData();
				buffer.append(" -> " + number);
			}

			List<String> path = element.getPathFromRoot();
			buffer.append(" ");
			buffer.append(path);

			System.out.println(buffer.toString());
		}

	};

}
