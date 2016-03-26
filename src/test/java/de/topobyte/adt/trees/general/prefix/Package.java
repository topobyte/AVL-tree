/**
 * Copyright (C) 2016 Sebastian Kürten.
 */
package de.topobyte.adt.trees.general.prefix;

import java.util.Arrays;
import java.util.List;

public class Package
{

	private List<String> parts;

	public Package(String... parts)
	{
		this(Arrays.asList(parts));
	}

	public Package(List<String> parts)
	{
		this.parts = parts;
	}

	public List<String> getParts()
	{
		return parts;
	}

	public String getPart(int i)
	{
		return parts.get(i);
	}

	public String packageName()
	{
		return packageName(parts.size());
	}

	public String packageName(int n)
	{
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			buffer.append(parts.get(i));
			if (i < n - 1) {
				buffer.append(".");
			}
		}
		return buffer.toString();
	}

	@Override
	public String toString()
	{
		return packageName();
	}

}
