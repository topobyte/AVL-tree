/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix;


public class PackageNode<Data> extends DefaultPrefixNode<String, Data>
{

	public PackageNode(DefaultPrefixNode<String, Data> parent, String label,
			Data data)
	{
		super(parent, label, data);
	}

	public Package toPackage()
	{
		return new Package(getPathFromRoot());
	}

}
