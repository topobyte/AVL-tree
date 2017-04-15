/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix.packages;

import java.util.Comparator;

import de.topobyte.adt.trees.general.prefix.PrefixTree;

public class PackageTree<Data>
		extends PrefixTree<String, Data, PackageNode<Data>>
{

	public PackageTree()
	{
		super(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2)
			{
				return o1.compareTo(o2);
			}

		});
	}

	@Override
	protected PackageNode<Data> createNode(PackageNode<Data> parent,
			String label, Data data)
	{
		return new PackageNode<>(parent, label, data);
	}

}
