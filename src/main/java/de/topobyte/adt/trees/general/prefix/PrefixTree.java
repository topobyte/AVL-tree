/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix;

import java.util.Comparator;
import java.util.List;

import de.topobyte.adt.tree.TreeUtil;
import de.topobyte.adt.tree.visitors.TreeNodePrintVisitor;
import de.topobyte.adt.trees.general.sorted.Node;
import de.topobyte.adt.trees.general.sorted.SortedTree;

public abstract class PrefixTree<Label, Data, N extends PrefixNode<Label, Data>>
		extends SortedTree<N>
{

	public PrefixTree(final Comparator<Label> comparator)
	{
		super(new Comparator<N>() {

			@Override
			public int compare(N o1, N o2)
			{
				Label n1 = o1.getLabel();
				Label n2 = o2.getLabel();
				return comparator.compare(n1, n2);
			}

		});
	}

	protected abstract N createNode(N parent, Label label, Data data);

	public void insert(List<Label> parts)
	{
		Node<N> iter = getRoot();
		for (Label part : parts) {
			N needle = createNode(null, part, null);
			if (!iter.contains(needle)) {
				N node = createNode(iter.getElement(), part, null);
				iter = iter.add(node);
			} else {
				iter = iter.find(needle);
			}
		}
	}

	public void insert(List<Label> parts, Data data)
	{
		Node<N> iter = getRoot();
		for (Label part : parts) {
			N needle = createNode(null, part, null);
			if (!iter.contains(needle)) {
				N node = createNode(iter.getElement(), part, null);
				iter = iter.add(node);
			} else {
				iter = iter.find(needle);
			}
		}
		PrefixNode<Label, Data> node = iter.getElement();
		node.setData(data);
	}

	public void print()
	{
		TreeNodePrintVisitor<N> printer = new TreeNodePrintVisitor<>();
		TreeUtil.traversePreorder(this, printer);
	}

	public void setData(List<Label> path, Data data)
	{
		setData(getRoot(), path, 0, data);
	}

	private void setData(Node<N> node, List<Label> path, int pos, Data data)
	{
		if (pos == path.size()) {
			node.getElement().setData(data);
		} else {
			Node<N> child = node.find(createNode(null, path.get(pos), null));

			setData(child, path, pos + 1, data);
		}
	}

	public Node<N> find(List<Label> path)
	{
		Node<N> iter = getRoot();
		for (int i = 0; i < path.size(); i++) {
			Label part = path.get(i);
			N needle = createNode(null, part, null);
			iter = iter.find(needle);
			if (iter == null) {
				return null;
			}
		}
		return iter;
	}

}
