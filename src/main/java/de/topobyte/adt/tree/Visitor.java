/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree;

public interface Visitor<T>
{

	public void visit(T element, int depth, int index, int numSiblings);

}
