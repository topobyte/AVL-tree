/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.tree;

public class TreeUtil
{

	public static <T> void traversePreorder(Tree<T> tree, Visitor<T> visitor)
	{
		TreeNode<T> root = tree.getRoot();
		traversePreorder(root, visitor, 0, 0, 1);
	}

	public static <T> void traversePreorder(TreeNode<T> node,
			Visitor<T> visitor, int depth, int index, int numSiblings)
	{
		visitor.visit(node.getElement(), depth, index, numSiblings);
		int numChildren = node.getNumberOfChildren();
		for (int i = 0; i < numChildren; i++) {
			TreeNode<T> child = node.getChild(i);
			traversePreorder(child, visitor, depth + 1, i, numChildren);
		}
	}

	public static <T> void traversePreorder(Tree<T> tree,
			TreeNodeVisitor<? super T> visitor)
	{
		TreeNode<T> root = tree.getRoot();
		traversePreorder(root, visitor, 0, 0, 1);
	}

	public static <T> void traversePreorder(TreeNode<T> node,
			TreeNodeVisitor<? super T> visitor, int depth, int index,
			int numSiblings)
	{
		visitor.visit(node, depth, index, numSiblings);
		int numChildren = node.getNumberOfChildren();
		for (int i = 0; i < numChildren; i++) {
			TreeNode<T> child = node.getChild(i);
			traversePreorder(child, visitor, depth + 1, i, numChildren);
		}
	}

	public static <T> void traversePostorder(Tree<T> tree, Visitor<T> visitor)
	{
		TreeNode<T> root = tree.getRoot();
		traversePostorder(root, visitor, 0, 0, 1);
	}

	public static <T> void traversePostorder(TreeNode<T> node,
			Visitor<T> visitor, int depth, int index, int numSiblings)
	{
		int numChildren = node.getNumberOfChildren();
		for (int i = 0; i < numChildren; i++) {
			TreeNode<T> child = node.getChild(i);
			traversePostorder(child, visitor, depth + 1, i, numChildren);
		}
		visitor.visit(node.getElement(), depth, index, numSiblings);
	}

	public static <T> void traversePostorder(Tree<T> tree,
			TreeNodeVisitor<? super T> visitor)
	{
		TreeNode<T> root = tree.getRoot();
		traversePostorder(root, visitor, 0, 0, 1);
	}

	public static <T> void traversePostorder(TreeNode<T> node,
			TreeNodeVisitor<? super T> visitor, int depth, int index,
			int numSiblings)
	{
		int numChildren = node.getNumberOfChildren();
		for (int i = 0; i < numChildren; i++) {
			TreeNode<T> child = node.getChild(i);
			traversePostorder(child, visitor, depth + 1, i, numChildren);
		}
		visitor.visit(node, depth, index, numSiblings);
	}

	public static <T> void traverse(Tree<T> tree, PrePostVisitor<T> visitor)
	{
		TreeNode<T> root = tree.getRoot();
		traverse(root, visitor, 0, 0, 1);
	}

	public static <T> void traverse(TreeNode<T> node, PrePostVisitor<T> visitor,
			int depth, int index, int numSiblings)
	{
		T element = node.getElement();
		visitor.visitIn(element, depth, index, numSiblings);
		int numChildren = node.getNumberOfChildren();
		for (int i = 0; i < numChildren; i++) {
			TreeNode<T> child = node.getChild(i);
			traverse(child, visitor, depth + 1, i, numChildren);
		}
		visitor.visitOut(element, depth, index, numSiblings);
	}

	public static <T> void traverse(Tree<T> tree,
			TreeNodePrePostVisitor<? super T> visitor)
	{
		TreeNode<T> root = tree.getRoot();
		traverse(root, visitor, 0, 0, 1);
	}

	public static <T> void traverse(TreeNode<T> node,
			TreeNodePrePostVisitor<? super T> visitor, int depth, int index,
			int numSiblings)
	{
		visitor.visitIn(node, depth, index, numSiblings);
		int numChildren = node.getNumberOfChildren();
		for (int i = 0; i < numChildren; i++) {
			TreeNode<T> child = node.getChild(i);
			traverse(child, visitor, depth + 1, i, numChildren);
		}
		visitor.visitOut(node, depth, index, numSiblings);
	}

}
