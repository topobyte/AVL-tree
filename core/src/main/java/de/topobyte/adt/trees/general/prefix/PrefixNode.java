/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix;

import java.util.List;

public interface PrefixNode<Label, Data>
{

	public PrefixNode<Label, Data> getParent();

	public boolean isRootNode();

	public Label getLabel();

	public Data getData();

	public void setData(Data data);

	public List<Label> getPathFromRoot();

}
