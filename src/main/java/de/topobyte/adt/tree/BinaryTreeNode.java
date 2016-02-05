/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.tree;

public interface BinaryTreeNode<T> extends TreeNode<T>
{

	public BinaryTreeNode<T> getLeft();

	public BinaryTreeNode<T> getRight();

}
