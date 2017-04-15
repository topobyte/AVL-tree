/**
 * Copyright (C) 2017 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix.strings;

import de.topobyte.adt.trees.general.prefix.DefaultPrefixNode;

public class StringPrefixNode<Data> extends DefaultPrefixNode<String, Data>
{

	public StringPrefixNode(DefaultPrefixNode<String, Data> parent,
			String label, Data data)
	{
		super(parent, label, data);
	}

}
