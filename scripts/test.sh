#!/bin/sh

java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestInsert

java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestInsertRemove

java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestInsertRemoveIndex

java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestIterator

java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestIteratorRemoval

java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestIndexOf

java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestListIterator

java -cp bin/main:bin/test/ de.topobyte.adt.avltree.TestListIteratorWithIndex
