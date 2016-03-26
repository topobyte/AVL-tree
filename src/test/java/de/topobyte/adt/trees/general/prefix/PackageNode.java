/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix;

import java.util.LinkedList;

public class PackageNode<Data> extends DefaultPrefixNode<String, Data>
{

	public PackageNode(DefaultPrefixNode<String, Data> parent, String label,
			Data data)
	{
		super(parent, label, data);
	}

	public Package toPackage()
	{
		LinkedList<String> parts = new LinkedList<>();
		PackageNode<Data> iter = this;
		while (iter != null) {
			parts.addFirst(iter.label);
			iter = (PackageNode<Data>) iter.parent;
		}
		return new Package(parts);
	}

}
