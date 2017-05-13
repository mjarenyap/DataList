import java.util.ArrayList;

public class CharacterList
{
	public CharacterList()
	{
		list = new char[0];
	}

	public void add(char data)
	{
		char[] temp = list;
		list = new char[list.length + 1];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		list[list.length - 1] = data;
	}

	public void add(char[] characters)
	{
		char[] temp = list;
		list = new char[list.length + characters.length];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		for(int i = 0; i < characters.length; i++)
			list[list.length - characters.length + i] = characters[i];
	}

	public void add(ArrayList<Character> characters)
	{
		char[] temp = list;
		list = new char[list.length + characters.size()];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		for(int i = 0; i < characters.size(); i++)
			list[list.length - characters.size() + i] = characters.get(i);
	}

	public void remove(int index)
	{
		char[] temp = list;
		int delay = 0;
		list = new char[list.length - 1];

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
		list = new char[0];
	}

	public void removeHead()
	{
		char[] temp = list;
		list = new char[list.length - 1];

		for(int i = 1; i < temp.length; i++)
			list[i - 1] = temp[i];
	}

	public void removeTail()
	{
		char[] temp = list;
		list = new char[list.length - 1];

		for(int i = 0; i < temp.length - 1; i++)
			list[i] = temp[i];
	}

	public void removeRange(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			CharacterList charlist = new CharacterList();
			for(int i = 0; i < list.length; i++)
				if(i < fromIndex || i > toIndex)
					charlist.add(list[i]);

			list = charlist.toArray();
		}
	}

	public void insert(int index, char data)
	{
		char[] temp = list;
		int delay = 0;
		list = new char[list.length + 1];

		for(int i = 0; i < temp.length; i++)
		{
			if(i == index)
			{
				list[i] = data;
				delay++;
			}

			else list[i] = temp[i - delay];
		}

		list[list.length - 1] = temp[temp.length - 1];
	}

	public void change(int index, char newData)
	{
		list[index] = newData;
	}

	public void changeAll(char oldData, char newData)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == oldData)
				list[i] = newData;
	}

	public void keepAll(char data)
	{
		CharacterList charlist = new CharacterList();
		for(int i = 0; i < list.length; i++)
			if(list[i] == data)
				charlist.add(list[i]);

		list = charlist.toArray();
	}

	public void keepRange(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			CharacterList charlist = new CharacterList();
			for(int i = 0; i < list.length; i++)
				if(i >= fromIndex && i <= toIndex)
					charlist.add(list[i]);

			list = charlist.toArray();
		}
	}

	public void swap(int first, int second)
	{
		char temp = list[first];
		list[first] = list[second];
		list[second] = temp;
	}

	public char get(int index)
	{
		return list[index];
	}

	public int size()
	{
		return list.length;
	}

	public int getIndex(char data)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == data)
				return i;

		return -1;
	}

	public void reverse()
	{
		CharacterList temp = new CharacterList();
		for(int i = list.length - 1; i >= 0; i--)
			temp.add(list[i]);

		for(int i = 0; i < temp.size(); i++)
			list[i] = temp.get(i);
	}

	public boolean contains(char data)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == data)
				return true;

		return false;
	}

	public boolean isEmpty()
	{
		if(size() == 0)
			return true;

		return false;
	}

	public char[] toArray()
	{
		return list;
	}

	public CharacterList subList(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			CharacterList charlist = new CharacterList();
			for(int i = 0; i < list.length; i++)
				if(i >= fromIndex && i <= toIndex)
					charlist.add(list[i]);

			return charlist;
		}

		return new CharacterList();
	}

	public CharacterList subList(int fromIndex)
	{
		CharacterList charlist = new CharacterList();
		for(int i = fromIndex; i < list.length; i++)
			charlist.add(list[i]);

		return charlist;
	}

	private char[] list;
}