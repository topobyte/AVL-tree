/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.tree;

public interface TreeNode<T>
{

	public int getNumberOfChildren();

	public TreeNode<T> getChild(int i);

	public T getElement();

}
