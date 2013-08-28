# License

This software is released under the terms of the **GNU Lesser General Public License Version 3** **(GNU LGPLv3)**

# Building

## Compile:

`ant compile`

## Create JAR distribution files:

`ant dist`

## Build documentation

`ant doc`

# Testing

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestInsert`

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestInsertRemove`

`java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestIterator`
