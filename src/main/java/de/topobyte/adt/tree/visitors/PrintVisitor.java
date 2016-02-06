package de.topobyte.adt.tree.visitors;

import de.topobyte.adt.tree.TreeNode;
import de.topobyte.adt.tree.Visitor;

public class PrintVisitor<T> implements Visitor<TreeNode<T>>
{

	@Override
	public void visit(TreeNode<T> node, int depth)
	{
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			buffer.append("  ");
		}
		T element = node.getElement();
		buffer.append(element == null ? "null" : element.toString());
		System.out.println(buffer.toString());
	}

}
