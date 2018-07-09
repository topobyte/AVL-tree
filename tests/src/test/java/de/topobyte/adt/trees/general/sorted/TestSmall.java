/**
 * Copyright (C) 2018 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.sorted;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.topobyte.adt.tree.TreeUtil;
import de.topobyte.adt.tree.visitors.PrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.TreeNodePrintVisitor;
import de.topobyte.adt.tree.visitors.stdio.StdPrePostPrintVisitor;
import de.topobyte.adt.tree.visitors.stdio.StdTreeNodePrintVisitor;

public class TestSmall
{

	@Test
	public void test()
	{
		SortedTree<String> tree = new SortedTree<>();

		Assert.assertEquals(1, tree.getHeight());

		Trees.small(tree);

		Assert.assertEquals(3, tree.getHeight());

		TreeNodePrintVisitor<String> printer = new StdTreeNodePrintVisitor<>(
				true);
		TreeUtil.traversePreorder(tree, printer);

		PrePostPrintVisitor<String> printer2 = new StdPrePostPrintVisitor<>(
				true);
		TreeUtil.traverse(tree, printer2);

		assertContainsPath(tree, new String[0]);
		assertContainsPath(tree, "bar");
		assertContainsPath(tree, "bar", "cat");
		assertContainsPath(tree, "bar", "tomcat");
		assertContainsPath(tree, "foo");
		assertContainsPath(tree, "foo", "bar again");
		assertDoesntContainPath(tree, "else");
		assertDoesntContainPath(tree, "foo", "else");
		assertDoesntContainPath(tree, "else", "more");

		testFindNode(tree, new String[0]);
		testFindNode(tree, "bar");
		testFindNode(tree, "bar", "cat");
		testFindNode(tree, "bar", "tomcat");
		testFindNode(tree, "foo");
		testFindNode(tree, "foo", "bar again");
		testDontFindNode(tree, "else");
		testDontFindNode(tree, "foo", "else");
		testDontFindNode(tree, "else", "more");

		testValidPath(tree, new String[0]);
		testValidPath(tree, "bar");
		testValidPath(tree, "bar", "cat");
		testValidPath(tree, "bar", "tomcat");
		testValidPath(tree, "foo");
		testValidPath(tree, "foo", "bar again");
		testInvalidPath(tree, "else");
		testInvalidPath(tree, "foo", "else");
		testInvalidPath(tree, "else", "more");
	}

	private void assertContainsPath(SortedTree<String> tree, String... values)
	{
		Assert.assertTrue(SortedTreeUtil.hasPath(tree, Arrays.asList(values)));
	}

	private void assertDoesntContainPath(SortedTree<String> tree,
			String... values)
	{
		Assert.assertFalse(SortedTreeUtil.hasPath(tree, Arrays.asList(values)));
	}

	private void testFindNode(SortedTree<String> tree, String... values)
	{
		Node<String> node = SortedTreeUtil.findNode(tree,
				Arrays.asList(values));
		Assert.assertNotNull(node);
		if (values.length == 0) {
			Assert.assertNull(node.getElement());
		} else {
			values[values.length - 1].equals(node.getElement());
		}
	}

	private void testDontFindNode(SortedTree<String> tree, String... values)
	{
		Node<String> node = SortedTreeUtil.findNode(tree,
				Arrays.asList(values));
		Assert.assertNull(node);
	}

	private void testValidPath(SortedTree<String> tree, String... values)
	{
		List<Node<String>> path = SortedTreeUtil.findPath(tree,
				Arrays.asList(values));
		Assert.assertEquals(values.length + 1, path.size());

		Assert.assertEquals(tree.getRoot(), path.get(0));
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			Node<String> node = path.get(i + 1);
			Assert.assertEquals(value, node.getElement());
		}
	}

	private void testInvalidPath(SortedTree<String> tree, String... values)
	{
		List<Node<String>> path = SortedTreeUtil.findPath(tree,
				Arrays.asList(values));
		Assert.assertNull(path);
	}

}
