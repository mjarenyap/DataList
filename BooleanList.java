import java.util.ArrayList;

public class BooleanList
{
	public BooleanList()
	{
		list = new boolean[0];
	}

	public void add(boolean content)
	{
		boolean[] temp = list;
		list = new boolean[list.length + 1];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		list[list.length - 1] = content;
	}

	public void add(boolean[] contents)
	{
		boolean[] temp = list;
		list = new boolean[list.length + contents.length];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		for(int i = 0; i < contents.length; i++)
			list[list.length - contents.length + i] = contents[i];
	}

	public void add(ArrayList<Boolean> contents)
	{
		boolean[] temp = list;
		list = new boolean[list.length + contents.size()];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		for(int i = 0; i < contents.size(); i++)
			list[list.length - contents.size() + i] = contents.get(i);
	}

	public void remove(int index)
	{
		boolean[] temp = list;
		int delay = 0;
		list = new boolean[list.length - 1];

		for(int i = 0; i < list.length; i++)
		{
			if(i != index)
				list[i - delay] = temp[i];

			else delay++;
		}

		if(temp.length - 1 != index)
			list[list.length - 1] = temp[temp.length - 1];
	}

	public void removeAll()
	{
		list = new boolean[0];
	}

	public void removeHead()
	{
		boolean[] temp = list;
		list = new boolean[list.length - 1];

		for(int i = 1; i < temp.length; i++)
			list[i - 1] = temp[i];
	}

	public void removeTail()
	{
		boolean[] temp = list;
		list = new boolean[list.length - 1];

		for(int i = 0; i < temp.length - 1; i++)
			list[i] = temp[i];
	}

	public void removeRange(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			BooleanList booleanlist = new BooleanList();
			for(int i = 0; i < list.length; i++)
				if(i < fromIndex || i > toIndex)
					booleanlist.add(list[i]);

			list = booleanlist.toArray();
		}
	}

	public void insert(int index, boolean content)
	{
		boolean[] temp = list;
		int delay = 0;
		list = new boolean[list.length + 1];

		for(int i = 0; i < temp.length; i++)
		{
			if(i == index)
			{
				list[i] = content;
				delay++;
			}

			else list[i] = temp[i - delay];
		}

		list[list.length - 1] = temp[temp.length - 1];
	}

	public void change(int index, boolean newData)
	{
		list[index] = newData;
	}

	public void changeAll(boolean oldData, boolean newData)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == oldData)
				list[i] = newData;
	}

	public void keepAll(boolean data)
	{
		BooleanList booleanlist = new BooleanList();
		for(int i = 0; i < list.length; i++)
			if(list[i] == data)
				booleanlist.add(list[i]);

		list = booleanlist.toArray();
	}

	public void keepRange(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			BooleanList booleanlist = new BooleanList();
			for(int i = 0; i < list.length; i++)
				if(i >= fromIndex && i <= toIndex)
					booleanlist.add(list[i]);

			list = booleanlist.toArray();
		}
	}

	public void swap(int first, int second)
	{
		boolean temp = list[first];
		list[first] = list[second];
		list[second] = temp;
	}

	public boolean get(int index)
	{
		return list[index];
	}

	public int size()
	{
		return list.length;
	}

	public int getIndex(boolean data)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == data)
				return i;

		return -1;
	}

	public void reverse()
	{
		ArrayList<Boolean> temp = new ArrayList<Boolean>();
		for(int i = list.length - 1; i >= 0; i--)
			temp.add(list[i]);

		for(int i = 0; i < temp.size(); i++)
			list[i] = temp.get(i);
	}

	public boolean contains(boolean content)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == content)
				return true;

		return false;
	}

	public boolean isEmpty()
	{
		if(size() == 0)
			return true;

		return false;
	}

	public boolean[] toArray()
	{
		return list;
	}

	public BooleanList subList(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			BooleanList booleanlist = new BooleanList();
			for(int i = 0; i < list.length; i++)
				if(i >= fromIndex && i <= toIndex)
					booleanlist.add(list[i]);

			return booleanlist;
		}

		return new BooleanList();
	}

	public BooleanList subList(int fromIndex)
	{
		BooleanList booleanlist = new BooleanList();
		for(int i = fromIndex; i < list.length; i++)
			booleanlist.add(list[i]);

		return booleanlist;
	}

	private boolean[] list;
}