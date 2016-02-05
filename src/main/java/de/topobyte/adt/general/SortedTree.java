/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.general;

import java.util.Comparator;

import de.topobyte.adt.tree.Tree;

public class SortedTree<T> implements Tree<T>
{

	private Node<T> root = new Node<T>(this, null);

	Comparator<? super T> comparator = null;

	public SortedTree()
	{
		comparator = new Comparator<T>() {

			@Override
			public int compare(T o1, T o2)
			{
				return ((Comparable<? super T>) o1).compareTo(o2);
			}
		};
	}

	public SortedTree(Comparator<? super T> comparator)
	{
		this.comparator = comparator;
	}

	@Override
	public Node<T> getRoot()
	{
		return root;
	}

	@Override
	public int getHeight()
	{
		return root.getHeight();
	}

}
