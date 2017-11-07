// integerList comment
import java.util.ArrayList;

public class IntegerList
{
	public IntegerList()
	{
		list = new int[0];
	}

	public void add(int data)
	{
		int[] temp = list;
		list = new int[list.length + 1];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		list[list.length - 1] = data;
	}

	public void add(int[] numbers)
	{
		int[] temp = list;
		list = new int[list.length + numbers.length];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		for(int i = 0; i < numbers.length; i++)
			list[list.length - numbers.length + i] = numbers[i];
	}

	public void add(ArrayList<Integer> numbers)
	{
		int[] temp = list;
		list = new int[list.length + numbers.size()];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		for(int i = 0; i < numbers.size(); i++)
			list[list.length - numbers.size() + i] = numbers.get(i);
	}

	public void remove(int index)
	{
		int[] temp = list;
		int delay = 0;
		list = new int[list.length - 1];

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
		list = new int[0];
	}

	public void removeHead()
	{
		int[] temp = list;
		list = new int[list.length - 1];

		for(int i = 1; i < temp.length; i++)
			list[i - 1] = temp[i];
	}

	public void removeTail()
	{
		int[] temp = list;
		list = new int[list.length - 1];

		for(int i = 0; i < temp.length - 1; i++)
			list[i] = temp[i];
	}

	public void removeRange(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			IntegerList intlist = new IntegerList();
			for(int i = 0; i < list.length; i++)
				if(i < fromIndex || i > toIndex)
					intlist.add(list[i]);

			list = intlist.toArray();
		}
	}

	public void insert(int index, int data)
	{
		int[] temp = list;
		int delay = 0;
		list = new int[list.length + 1];

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

	public void change(int index, int newData)
	{
		list[index] = newData;
	}

	public void changeAll(int oldData, int newData)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == oldData)
				list[i] = newData;
	}

	public void keepAll(int data)
	{
		IntegerList intlist = new IntegerList();
		for(int i = 0; i < list.length; i++)
			if(list[i] == data)
				intlist.add(list[i]);

		list = intlist.toArray();
	}

	public void keepRange(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			IntegerList intlist = new IntegerList();
			for(int i = 0; i < list.length; i++)
				if(i >= fromIndex && i <= toIndex)
					intlist.add(list[i]);

			list = intlist.toArray();
		}
	}

	public void swap(int first, int second)
	{
		int temp = list[first];
		list[first] = list[second];
		list[second] = temp;
	}

	public int get(int index)
	{
		return list[index];
	}

	public int size()
	{
		return list.length;
	}

	public int getIndex(int data)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == data)
				return i;

		return -1;
	}

	public void reverse()
	{
		IntegerList intlist = new IntegerList();
		for(int i = list.length - 1; i >= 0; i--)
			intlist.add(list[i]);

		for(int i = 0; i < intlist.size(); i++)
			list[i] = intlist.get(i);
	}

	public boolean contains(int data)
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

	public int[] toArray()
	{
		return list;
	}

	public IntegerList subList(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			IntegerList intlist = new IntegerList();
			for(int i = 0; i < list.length; i++)
				if(i >= fromIndex && i <= toIndex)
					intlist.add(list[i]);

			return intlist;
		}

		return new IntegerList();
	}

	public IntegerList subList(int fromIndex)
	{
		IntegerList intlist = new IntegerList();
		for(int i = fromIndex; i < list.length; i++)
			intlist.add(list[i]);

		return intlist;
	}

	private int[] list;
}