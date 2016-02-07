/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree;

public interface PrePostVisitor<T>
{

	public void visitIn(T element, int depth);

	public void visitOut(T element, int depth);

}
