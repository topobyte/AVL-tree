/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

import java.util.ListIterator;
import java.util.NoSuchElementException;

class TreeListIterator<T extends Comparable<T>> implements ListIterator<T>
{

	private Tree<T> tree;

	private TreePath<T> prev = null;
	private TreePath<T> last = null;
	private TreePath<T> next = null;

	public TreeListIterator(Tree<T> tree)
	{
		this.tree = tree;

		prev = null;
		next = tree.findMinPath();
		last = null;
	}

	public TreeListIterator(Tree<T> tree, int index)
	{
		if (index < 0 || index > tree.size()) {
			throw new IndexOutOfBoundsException();
		}

		this.tree = tree;

		prev = index == 0 ? null : tree.findIndexPath(index - 1);
		next = index == tree.size() ? null : tree.findIndexPath(index);
		last = null;
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
	public boolean hasPrevious()
	{
		if (prev != null) {
			return prev.getLength() > 0;
		}
		return false;
	}

	@Override
	public T next()
	{
		prev = next;
		last = next;
		next = tree.findSuccessor(last.clone());

		TreePathNode<T> target = last.getTarget();

		if (target == null) {
			throw new NoSuchElementException();
		}

		T element = target.getNode().getElement();

		return element;
	}

	public T previous()
	{
		next = prev;
		last = prev;
		prev = tree.findPredecessor(last.clone());

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
		if (last == null) {
			throw new IllegalStateException();
		}
		TreePathNode<T> nextTarget = next.getTarget();
		TreePathNode<T> prevTarget = prev.getTarget();

		tree.remove(last);
		last = null;

		if (prevTarget != null) {
			prev = tree.findNodePath(prevTarget.getNode().getElement());
		}
		if (nextTarget != null) {
			next = tree.findNodePath(nextTarget.getNode().getElement());
		}
	}

	@Override
	public int nextIndex()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int previousIndex()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(T e)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(T e)
	{
		throw new UnsupportedOperationException();
	}

}
