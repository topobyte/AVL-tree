package de.topobyte.adt.trees.general.prefix;

import java.util.ArrayList;
import java.util.List;

public class TestData
{

	public static PackageTree<Boolean> testTree()
	{
		List<Package> packages = new ArrayList<>();
		packages.add(new Package("de", "topobyte", "test"));
		packages.add(new Package("de", "topobyte", "foo"));
		packages.add(new Package("de", "topobyte", "bar"));
		packages.add(new Package("de", "topobyte", "cat", "shops"));
		packages.add(new Package("de", "topobyte", "cat", "restaurants"));
		packages.add(new Package("de", "topobyte", "cat", "bars"));

		PackageTree<Boolean> tree = new PackageTree<>();
		for (Package p : packages) {
			tree.insert(p.getParts(), true);
		}

		tree.insert(new ArrayList<String>(), true);
		return tree;
	}

}
