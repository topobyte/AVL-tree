package de.topobyte.adt.avltree;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class AvlTreeListAdapter<T> implements List<T>
{

	private AvlTree<T> tree;

	public AvlTreeListAdapter(AvlTree<T> tree)
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
	public boolean addAll(int index, Collection<? extends T> c)
	{
		return tree.addAll(index, c);
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
	public T get(int index)
	{
		return tree.get(index);
	}

	@Override
	public T set(int index, T element)
	{
		return tree.set(index, element);
	}

	@Override
	public void add(int index, T element)
	{
		tree.add(index, element);
	}

	@Override
	public T remove(int index)
	{
		return tree.remove(index);
	}

	@Override
	public int indexOf(Object o)
	{
		return tree.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o)
	{
		return tree.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator()
	{
		return tree.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index)
	{
		return tree.listIterator();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
		return tree.subList(fromIndex, toIndex);
	}

}
