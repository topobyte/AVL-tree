/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

import java.util.Iterator;
import java.util.NoSuchElementException;

class TreeIterator<T extends Comparable<T>> implements Iterator<T>
{

	private boolean initialized = false;

	private Tree<T> tree;

	private TreePath<T> path;

	public TreeIterator(Tree<T> tree)
	{
		this.tree = tree;
	}

	private void ensureInitialized()
	{
		if (initialized) {
			return;
		}
		initialized = true;

		path = tree.findMinPath();
	}

	@Override
	public boolean hasNext()
	{
		ensureInitialized();
		return path.getLength() > 0;
	}

	@Override
	public T next()
	{
		ensureInitialized();
		TreePathNode<T> target = path.getTarget();

		if (target == null) {
			throw new NoSuchElementException();
		}

		T element = target.getNode().getElement();

		tree.findSuccessor(path);

		return element;
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}

}
