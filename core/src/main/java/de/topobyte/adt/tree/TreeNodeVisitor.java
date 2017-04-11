/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree;

public interface TreeNodeVisitor<T>
{

	public void visit(TreeNode<? extends T> node, int depth, int index,
			int numSiblings);

}
