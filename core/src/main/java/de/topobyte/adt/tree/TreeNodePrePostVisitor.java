/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree;

public interface TreeNodePrePostVisitor<T>
{

	public void visitIn(TreeNode<? extends T> node, int depth, int index,
			int numSiblings);

	public void visitOut(TreeNode<? extends T> node, int depth, int index,
			int numSiblings);

}
