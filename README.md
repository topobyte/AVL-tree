# About

This Java project contains some general purpose tree interfaces and implementations.

## General tree abstraction

There are some interfaces in the package `de.topobyte.adt.tree` that can be
used in various tree related data structures.

## AVL tree

This **AVL tree** implementation aims to provide a **self-balancing tree**
implementation that is useful in practice.
To achieve this it should integrate well with the standard Java interfaces and classes.
It implements the **SortedSet** interface as well as the **List** interface, which is a useful
combination not found on any standard class. For example the default TreeSet implementation
provides a SortedSet but does not expose a **get(index)** method. I think such a function makes
perfect sense for a sorted set, which is why this tree implementation provides it.

# License

This software is released under the terms of the **GNU Lesser General Public License Version 3** **(GNU LGPLv3)**

# Building

## Create JAR distribution files:

`gradle build`

## Build documentation

`gradle javadoc`

# Testing

TODO: this section is outdated

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestInsert`

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestInsertRemove`

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestInsertRemoveIndex`

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestIterator`

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestIteratorRemoval`

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestIndexOf`

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestListIterator`

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestListIteratorWithIndex`

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestTreeInterface`
