/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix;

public class DefaultPrefixNode<Label, Data> implements PrefixNode<Label, Data>
{

	protected DefaultPrefixNode<Label, Data> parent;
	protected Label label;
	protected Data data;

	public DefaultPrefixNode(DefaultPrefixNode<Label, Data> parent,
			Label label, Data data)
	{
		this.parent = parent;
		this.label = label;
		this.data = data;
	}

	@Override
	public PrefixNode<Label, Data> getParent()
	{
		return parent;
	}

	@Override
	public boolean isRootNode()
	{
		return false;
	}

	@Override
	public Label getLabel()
	{
		return label;
	}

	@Override
	public Data getData()
	{
		return data;
	}

	@Override
	public void setData(Data data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return label.toString();
	}

}
