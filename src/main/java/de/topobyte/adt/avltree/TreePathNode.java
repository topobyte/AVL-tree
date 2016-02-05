/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

class TreePathNode<T>
{
	private Node<T> parent;
	private Node<T> node;

	// direction tells whether node is the left or right child of parent
	private Direction direction;

	public TreePathNode(Node<T> parent, Direction direction, Node<T> node)
	{
		this.parent = parent;
		this.node = node;
		this.direction = direction;
	}

	public Node<T> getParent()
	{
		return parent;
	}

	public Node<T> getNode()
	{
		return node;
	}

	public Direction getDirection()
	{
		return direction;
	}
}