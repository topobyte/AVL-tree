/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix;

import de.topobyte.adt.tree.TreeNode;
import de.topobyte.adt.tree.Visitor;

public interface PackageTreeVisitor<A> extends Visitor<TreeNode<PackageNode<A>>>
{

}
