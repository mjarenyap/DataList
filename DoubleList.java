import java.util.ArrayList;

public class DoubleList
{
	public DoubleList()
	{
		list = new double[0];
	}

	public void add(double number)
	{
		double[] temp = list;
		list = new double[list.length + 1];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		list[list.length - 1] = number;
	}

	public void add(double[] numbers)
	{
		double[] temp = list;
		list = new double[list.length + numbers.length];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		for(int i = 0; i < numbers.length; i++)
			list[list.length - numbers.length + i] = numbers[i];
	}

	public void add(ArrayList<Double> numbers)
	{
		double[] temp = list;
		list = new double[list.length + numbers.size()];

		for(int i = 0; i < temp.length; i++)
			list[i] = temp[i];

		for(int i = 0; i < numbers.size(); i++)
			list[list.length - numbers.size() + i] = numbers.get(i);
	}

	public void remove(int index)
	{
		double[] temp = list;
		int delay = 0;
		list = new double[list.length - 1];

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
		list = new double[0];
	}

	public void removeHead()
	{
		double[] temp = list;
		list = new double[list.length - 1];

		for(int i = 1; i < temp.length; i++)
			list[i - 1] = temp[i];
	}

	public void removeTail()
	{
		double[] temp = list;
		list = new double[list.length - 1];

		for(int i = 0; i < temp.length - 1; i++)
			list[i] = temp[i];
	}

	public void removeRange(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			DoubleList doublelist = new DoubleList();
			for(int i = 0; i < list.length; i++)
				if(i < fromIndex || i > toIndex)
					doublelist.add(list[i]);

			list = doublelist.toArray();
		}
	}

	public void insert(int index, double number)
	{
		double[] temp = list;
		int delay = 0;
		list = new double[list.length + 1];

		for(int i = 0; i < temp.length; i++)
		{
			if(i == index)
			{
				list[i] = number;
				delay++;
			}

			else list[i] = temp[i - delay];
		}

		list[list.length - 1] = temp[temp.length - 1];
	}

	public void change(int index, double newData)
	{
		list[index] = newData;
	}

	public void changeAll(double oldData, double newData)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == oldData)
				list[i] = newData;
	}

	public void keepAll(double data)
	{
		DoubleList doublelist = new DoubleList();
		for(int i = 0; i < list.length; i++)
			if(list[i] == data)
				doublelist.add(list[i]);

		list = doublelist.toArray();
	}

	public void keepRange(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			DoubleList doublelist = new DoubleList();
			for(int i = 0; i < list.length; i++)
				if(i >= fromIndex && i <= toIndex)
					doublelist.add(list[i]);

			list = doublelist.toArray();
		}
	}

	public void swap(int first, int second)
	{
		double temp = list[first];
		list[first] = list[second];
		list[second] = temp;
	}

	public double get(int index)
	{
		return list[index];
	}

	public int size()
	{
		return list.length;
	}

	public int getIndex(double data)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == data)
				return i;

		return -1;
	}

	public void reverse()
	{
		ArrayList<Double> temp = new ArrayList<Double>();
		for(int i = list.length - 1; i >= 0; i--)
			temp.add(list[i]);

		for(int i = 0; i < temp.size(); i++)
			list[i] = temp.get(i);
	}

	public boolean contains(double number)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i] == number)
				return true;

		return false;
	}

	public boolean isEmpty()
	{
		if(size() == 0)
			return true;

		return false;
	}

	public double[] toArray()
	{
		return list;
	}

	public DoubleList subList(int fromIndex, int toIndex)
	{
		if(fromIndex <= toIndex)
		{
			DoubleList doublelist = new DoubleList();
			for(int i = 0; i < list.length; i++)
				if(i >= fromIndex && i <= toIndex)
					doublelist.add(list[i]);

			return doublelist;
		}

		return new DoubleList();
	}

	public DoubleList subList(int fromIndex)
	{
		DoubleList doublelist = new DoubleList();
		for(int i = fromIndex; i < list.length; i++)
			doublelist.add(list[i]);

		return doublelist;
	}

	private double[] list;
}