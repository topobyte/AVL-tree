/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

import de.topobyte.adt.tree.BinaryTreeNode;
import de.topobyte.adt.tree.TreeNode;

public class TreeImplNode<T> implements BinaryTreeNode<T>
{

	private Node<T> node;

	public TreeImplNode(Node<T> node)
	{
		this.node = node;
	}

	@Override
	public int getNumberOfChildren()
	{
		return 2;
	}

	@Override
	public TreeNode<T> getChild(int i)
	{
		if (i == 0) {
			Node<T> left = node.getLeft();
			return child(left);
		} else if (i == 1) {
			Node<T> right = node.getRight();
			return child(right);
		}
		return null;
	}

	@Override
	public BinaryTreeNode<T> getLeft()
	{
		return child(node.getLeft());
	}

	@Override
	public BinaryTreeNode<T> getRight()
	{
		return child(node.getRight());
	}

	private BinaryTreeNode<T> child(Node<T> child)
	{
		if (child == null) {
			return null;
		}
		return new TreeImplNode<T>(child);
	}

	@Override
	public T getElement()
	{
		return node.getElement();
	}

}
