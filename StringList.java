import java.util.ArrayList;

public class StringList
{
	public StringList()
	{
		list = new String[0];
	}

	public void add(String content)
	{
		String[] temp = list;
		list = new String[list.length + 1];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		list[list.length - 1] = content;
	}

	public void add(String[] contents)
	{
		String[] temp = list;
		list = new String[list.length + contents.length];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		for(int i = 0; i < contents.length; i++)
			list[list.length - contents.length + i] = contents[i];
	}

	public void add(ArrayList<String> contents)
	{
		String[] temp = list;
		list = new String[list.length + contents.size()];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		for(int i = 0; i < contents.size(); i++)
			list[list.length - contents.size() + i] = contents.get(i);
	}

	public void remove(int index)
	{
		String[] temp = list;
		int delay = 0;
		list = new String[list.length - 1];

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
		list = new String[0];
	}

	public void removeHead()
	{
		String[] temp = list;
		list = new String[list.length - 1];

		for(int i = 1; i < temp.length; i++)
			list[i - 1] = temp[i];
	}

	public void removeTail()
	{
		String[] temp = list;
		list = new String[list.length - 1];

		for(int i = 0; i < temp.length - 1; i++)
			list[i] = temp[i];
	}

	public void removeRange(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			StringList stringlist = new StringList();
			for(int i = 0; i < list.length; i++)
				if(i < fromIndex || i > toIndex)
					stringlist.add(list[i]);

			list = stringlist.toArray();
		}
	}

	public void insert(int index, String content)
	{
		String[] temp = list;
		int delay = 0;
		list = new String[list.length + 1];

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

	public void change(int index, String newData)
	{
		list[index] = newData;
	}

	public void changeAll(String oldData, String newData)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i].equals(oldData))
				list[i] = newData;
	}

	public void keepAll(String data)
	{
		StringList stringlist = new StringList();
		for(int i = 0; i < list.length; i++)
			if(list[i].equals(data))
				stringlist.add(list[i]);

		list = stringlist.toArray();
	}

	public void keepRange(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			StringList stringlist = new StringList();
			for(int i = 0; i < list.length; i++)
				if(i >= fromIndex && i <= toIndex)
					stringlist.add(list[i]);

			list = stringlist.toArray();
		}
	}

	public void swap(int first, int second)
	{
		String temp = list[first];
		list[first] = list[second];
		list[second] = temp;
	}

	public String get(int index)
	{
		return list[index];
	}

	public int size()
	{
		return list.length;
	}

	public int getIndex(String data)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i].equals(data))
				return i;

		return -1;
	}

	public void reverse()
	{
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = list.length - 1; i >= 0; i--)
			temp.add(list[i]);

		for(int i = 0; i < temp.size(); i++)
			list[i] = temp.get(i);
	}

	public boolean contains(String content)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i].equals(content))
				return true;

		return false;
	}

	public boolean isEmpty()
	{
		if(size() == 0)
			return true;

		return false;
	}

	public String[] toArray()
	{
		return list;
	}

	public StringList subList(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			StringList stringlist = new StringList();
			for(int i = 0; i < list.length; i++)
				if(i >= fromIndex && i <= toIndex)
					stringlist.add(list[i]);

			return stringlist;
		}

		return new StringList();
	}

	public StringList subList(int fromIndex)
	{
		StringList stringlist = new StringList();
		for(int i = fromIndex; i < list.length; i++)
			stringlist.add(list[i]);

		return stringlist;
	}

	private String[] list;
}