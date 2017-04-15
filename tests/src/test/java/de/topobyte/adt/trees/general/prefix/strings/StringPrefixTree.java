/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix.strings;

import java.util.Comparator;

import de.topobyte.adt.trees.general.prefix.PrefixTree;

public class StringPrefixTree<Data> extends
		PrefixTree<String, Data, StringPrefixNode<Data>>
{

	public StringPrefixTree()
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
	protected StringPrefixNode<Data> createNode(StringPrefixNode<Data> parent,
			String label, Data data)
	{
		return new StringPrefixNode<Data>(parent, label, data);
	}

}
