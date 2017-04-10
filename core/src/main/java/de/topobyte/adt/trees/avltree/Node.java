/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.trees.avltree;

class Node<T>
{
	private T element;
	private Node<T> left;
	private Node<T> right;
	private int height;
	private int size;

	public Node(T element)
	{
		this(element, null, null);
	}

	public Node(T element, Node<T> left, Node<T> right)
	{
		this.element = element;
		this.left = left;
		this.right = right;
		this.height = 1;
		calculateSize();
	}

	public T getElement()
	{
		return element;
	}

	public Node<T> getLeft()
	{
		return left;
	}

	public Node<T> getRight()
	{
		return right;
	}

	public int getHeight()
	{
		return height;
	}

	public void setElement(T element)
	{
		this.element = element;
	}

	public void setLeft(Node<T> left)
	{
		this.left = left;
	}

	public void setRight(Node<T> right)
	{
		this.right = right;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getSize()
	{
		return size;
	}

	public void calculateSize()
	{
		this.size = 1;
		if (left != null) {
			size += left.getSize();
		}
		if (right != null) {
			size += right.getSize();
		}
	}

}