/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree;

public class TreeUtil
{

	public static <T> void traversePreorder(Tree<T> tree,
			Visitor<TreeNode<T>> visitor)
	{
		TreeNode<T> root = tree.getRoot();
		traversePreorder(root, visitor, 0);
	}

	public static <T> void traversePreorder(TreeNode<T> node,
			Visitor<TreeNode<T>> visitor, int depth)
	{
		visitor.visit(node, depth);
		for (int i = 0; i < node.getNumberOfChildren(); i++) {
			TreeNode<T> child = node.getChild(i);
			traversePreorder(child, visitor, depth + 1);
		}
	}

	public static <T> void traversePostorder(Tree<T> tree,
			Visitor<TreeNode<T>> visitor)
	{
		TreeNode<T> root = tree.getRoot();
		traversePostorder(root, visitor, 0);
	}

	public static <T> void traversePostorder(TreeNode<T> node,
			Visitor<TreeNode<T>> visitor, int depth)
	{
		for (int i = 0; i < node.getNumberOfChildren(); i++) {
			TreeNode<T> child = node.getChild(i);
			traversePostorder(child, visitor, depth + 1);
		}
		visitor.visit(node, depth);
	}

	public static <T> void traverse(Tree<T> tree,
			PrePostVisitor<TreeNode<T>> visitor)
	{
		TreeNode<T> root = tree.getRoot();
		traverse(root, visitor, 0);
	}

	public static <T> void traverse(TreeNode<T> node,
			PrePostVisitor<TreeNode<T>> visitor, int depth)
	{
		visitor.visitIn(node, depth);
		for (int i = 0; i < node.getNumberOfChildren(); i++) {
			TreeNode<T> child = node.getChild(i);
			traverse(child, visitor, depth + 1);
		}
		visitor.visitOut(node, depth);
	}

}
