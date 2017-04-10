package de.topobyte.adt.trees.avltree;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

class AvlTreeSetAdapter<T> implements SortedSet<T>
{

	private AvlTree<T> tree;

	public AvlTreeSetAdapter(AvlTree<T> tree)
	{
		this.tree = tree;
	}

	@Override
	public int size()
	{
		return tree.size();
	}

	@Override
	public boolean isEmpty()
	{
		return tree.isEmpty();
	}

	@Override
	public boolean contains(Object o)
	{
		return tree.contains(o);
	}

	@Override
	public Iterator<T> iterator()
	{
		return tree.iterator();
	}

	@Override
	public Object[] toArray()
	{
		return tree.toArray();
	}

	@Override
	public <A> A[] toArray(A[] a)
	{
		return tree.toArray(a);
	}

	@Override
	public boolean add(T e)
	{
		return tree.add(e);
	}

	@Override
	public boolean remove(Object o)
	{
		return tree.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return tree.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		return tree.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		return tree.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		return tree.retainAll(c);
	}

	@Override
	public void clear()
	{
		tree.clear();
	}

	@Override
	public Comparator<? super T> comparator()
	{
		return tree.comparator();
	}

	@Override
	public SortedSet<T> subSet(T fromElement, T toElement)
	{
		return tree.subSet(fromElement, toElement);
	}

	@Override
	public SortedSet<T> headSet(T toElement)
	{
		return tree.headSet(toElement);
	}

	@Override
	public SortedSet<T> tailSet(T fromElement)
	{
		return tree.tailSet(fromElement);
	}

	@Override
	public T first()
	{
		return tree.first();
	}

	@Override
	public T last()
	{
		return tree.last();
	}

}
