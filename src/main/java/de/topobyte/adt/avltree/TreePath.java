/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

import java.util.ArrayList;
import java.util.List;

class TreePath<T>
{

	private List<TreePathNode<T>> path = new ArrayList<>();

	public void add(Node<T> parent, Direction direction, Node<T> node)
	{
		path.add(new TreePathNode<>(parent, direction, node));
	}

	public int getLength()
	{
		return path.size();
	}

	public TreePathNode<T> get(int index)
	{
		if (index >= 0 && index < path.size()) {
			return path.get(index);
		}
		return null;
	}

	public TreePathNode<T> getTarget()
	{
		if (path.size() == 0) {
			return null;
		}
		return path.get(path.size() - 1);
	}

	public void removeLastNode()
	{
		if (path.size() > 0) {
			path.remove(path.size() - 1);
		}
	}

	@Override
	public TreePath<T> clone()
	{
		TreePath<T> clone = new TreePath<>();
		for (TreePathNode<T> ref : path) {
			clone.path.add(ref);
		}
		return clone;
	}
}
