/**
 * Copyright (C) 2013 Sebastian Kürten.
 */
package de.topobyte.adt.avltree;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import de.topobyte.adt.tree.BinaryTreeNode;

public class TreePrinter
{
	private PrintStream stream;

	private int pad;
	private String emptyNode;
	private List<List<Integer>> rows = new ArrayList<List<Integer>>();

	public TreePrinter(PrintStream stream, int pad)
	{
		this.stream = stream;
		this.pad = pad;
		if (pad == 1) {
			emptyNode = "*";
		} else {
			StringBuffer buffer = new StringBuffer();
			buffer.append("[");
			for (int i = 0; i < pad - 2; i++) {
				buffer.append(" ");
			}
			buffer.append("]");
			emptyNode = buffer.toString();
		}
	}

	public void print(AvlTree<Integer> tree)
	{
		BinaryTreeNode<Integer> root = tree.getBinaryRoot();
		int h = tree.getHeight();

		for (int level = 0; level < h; level++) {
			rows.add(new ArrayList<Integer>());
		}

		traverse(root, 0);

		for (int level = 0; level < h; level++) {
			// height of the current level
			int height = h - level - 1;
			// # chars to print before the first node of the level on the line
			int before = spaceBefore(height);
			// # chars between two subsequent nodes on this level
			int inter = spaceInter(height);
			// # chars between two subsequent nodes on the next level
			int interNext = 0;
			// # number of underscore to represent a link from this
			// level to the next
			int link = 0;
			// # number of chars between two nodes on this level minus
			// the underscore to depict the links to the next level
			int space = 0;
			if (height != 0) {
				interNext = spaceInter(height - 1);
				space = interNext + pad * 2;
				link = (inter - space) / 2;
			}

			int startingSpace = before - link;

			print(startingSpace, " ");
			print(link, "_");

			List<Integer> row = rows.get(level);
			for (int i = 0; i < row.size(); i++) {
				Integer value = row.get(i);
				printElement(value);
				if (i == row.size() - 1) {
					break;
				}
				if (height == 0) {
					print(inter, " ");
				} else {
					print(link, "_");
					print(space, " ");
					print(link, "_");
				}
			}
			print(link, "_");

			stream.println();
		}
	}

	private void traverse(BinaryTreeNode<Integer> node, int level)
	{
		if (node == null) {
			if (level < rows.size()) {
				traverse(null, level + 1);
			}
		} else {
			traverse(node.getLeft(), level + 1);
		}
		handle(node, level);
		if (node == null) {
			if (level < rows.size()) {
				traverse(null, level + 1);
			}
		} else {
			traverse(node.getRight(), level + 1);
		}
	}

	private void handle(BinaryTreeNode<Integer> node, int level)
	{
		if (level >= rows.size()) {
			return;
		}
		if (node == null) {
			rows.get(level).add(null);
		} else {
			rows.get(level).add(node.getElement());
		}
	}

	private void print(int n, String c)
	{
		for (int i = 0; i < n; i++) {
			stream.print(c);
		}
	}

	private void printElement(Integer value)
	{
		if (value == null) {
			stream.print(emptyNode);
		} else {
			stream.print(String.format("%" + pad + "d", value));
		}
	}

	private int spaceInter(int height)
	{
		if (height == 0) {
			return pad;
		}
		return spaceInter(height - 1) * 2 + pad;
	}

	private int spaceBefore(int height)
	{
		if (height == 0) {
			return 0;
		}
		return spaceBefore(height - 1) * 2 + pad;
	}
}
