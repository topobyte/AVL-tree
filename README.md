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

SortedSet and List views on the tree are provided with the asSet() and asList()
methods.

## Sorted tree

A generic tree with any number of children.

## Prefix tree

A generic prefix tree or trie.

# License

This software is released under the terms of the **GNU Lesser General Public License Version 3** **(GNU LGPLv3)**

# Building

## Create JAR distribution files:

`gradle build`

## Build documentation

`gradle javadoc`

# Testing

`gradle test`
