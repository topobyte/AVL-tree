/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.tree;

public interface Tree<T>
{

	public TreeNode<T> getRoot();

	public int getHeight();
}
