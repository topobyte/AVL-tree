/**
 * Copyright (C) 2018 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.sorted;

import java.util.ArrayList;
import java.util.List;

public class SortedTreeUtil
{

	/**
	 * Return whether the specified path {@code values} exists within the tree.
	 */
	public static <T> boolean hasPath(SortedTree<T> tree, List<T> values)
	{
		Node<T> node = tree.getRoot();
		for (T part : values) {
			Node<T> next = node.find(part);
			if (next == null) {
				return false;
			}
			node = next;
		}
		return true;
	}

	/**
	 * Find the node that is pointed to with the specified path {@code values},
	 * starting from the root of the tree.
	 */
	public static <T> Node<T> findNode(SortedTree<T> tree, List<T> values)
	{
		Node<T> node = tree.getRoot();
		return findNode(node, values);
	}

	/**
	 * Find the node that is pointed to with the specified path {@code values}
	 * starting from the specified node.
	 */
	public static <T> Node<T> findNode(Node<T> node, List<T> values)
	{
		for (T part : values) {
			Node<T> next = node.find(part);
			if (next == null) {
				return null;
			}
			node = next;
		}
		return node;
	}

	/**
	 * Find the node that is pointed to with the specified path {@code values},
	 * starting from the root of the tree.
	 * 
	 * @return the list of nodes on the path to the target node, including the
	 *         root node and the target node. Or null if the values don't
	 *         specify a valid path within the tree.
	 */
	public static <T> List<Node<T>> findPath(SortedTree<T> tree, List<T> values)
	{
		Node<T> node = tree.getRoot();
		return findPath(node, values);
	}

	/**
	 * Find the node that is pointed to with the specified path {@code values},
	 * starting from the specified node.
	 * 
	 * @return the list of nodes on the path to the target node, including the
	 *         start node and the target node. Or null if the values don't
	 *         specify a valid path within the tree.
	 */
	public static <T> List<Node<T>> findPath(Node<T> node, List<T> values)
	{
		List<Node<T>> path = new ArrayList<>();
		path.add(node);
		boolean success = true;
		for (T part : values) {
			Node<T> next = node.find(part);
			if (next == null) {
				success = false;
				break;
			}
			path.add(next);
			node = next;
		}

		if (success) {
			return path;
		}
		return null;
	}

}
