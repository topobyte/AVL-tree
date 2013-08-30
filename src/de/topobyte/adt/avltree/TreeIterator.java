/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

import java.util.Iterator;
import java.util.NoSuchElementException;

class TreeIterator<T> implements Iterator<T>
{

	private AvlTree<T> tree;

	private TreePath<T> last = null;
	private TreePath<T> next = null;

	private boolean removed = false;

	public TreeIterator(AvlTree<T> tree)
	{
		this.tree = tree;

		last = null;
		next = tree.findMinPath();
	}

	@Override
	public boolean hasNext()
	{
		if (next != null) {
			return next.getLength() > 0;
		}
		return false;
	}

	@Override
	public T next()
	{
		last = next;
		next = tree.findSuccessor(last.clone());

		removed = false;

		TreePathNode<T> target = last.getTarget();

		if (target == null) {
			throw new NoSuchElementException();
		}

		T element = target.getNode().getElement();

		return element;
	}

	@Override
	public void remove()
	{
		if (last == null || removed) {
			throw new IllegalStateException();
		}
		TreePathNode<T> nextTarget = next.getTarget();

		tree.remove(last);

		if (nextTarget != null) {
			next = tree.findNodePath(nextTarget.getNode().getElement());
		}
	}

}
