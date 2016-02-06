/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.general;

import de.topobyte.adt.avltree.AvlTree;
import de.topobyte.adt.tree.TreeNode;

public class Node<T> implements TreeNode<T>, Comparable<Node<T>>
{

	private SortedTree<T> tree;
	private T element;
	private AvlTree<Node<T>> children;

	public Node(SortedTree<T> tree, T element)
	{
		this.tree = tree;
		this.element = element;
		children = new AvlTree<>();
	}

	@Override
	public T getElement()
	{
		return element;
	}

	public void setElement(T element)
	{
		this.element = element;
	}

	@Override
	public int getNumberOfChildren()
	{
		return children.size();
	}

	@Override
	public TreeNode<T> getChild(int i)
	{
		return children.getElement(i);
	}

	public Node<T> add(T element)
	{
		Node<T> node = new Node<T>(tree, element);
		children.add(node);
		return node;
	}

	@Override
	public int compareTo(Node<T> o)
	{
		return tree.comparator.compare(element, o.element);
	}

	public int getHeight()
	{
		if (children.isEmpty()) {
			return 1;
		}
		int max = 0;
		for (Node<T> child : children) {
			max = Math.max(max, child.getHeight());
		}
		return 1 + max;
	}

	public boolean contains(T s)
	{
		return children.contains(s);
	}

	public Node<T> find(T s)
	{
		Node<T> needle = new Node<T>(tree, s);
		TreeNode<Node<T>> found = children.findNode(needle);
		if (found == null) {
			return null;
		}
		return found.getElement();
	}

}