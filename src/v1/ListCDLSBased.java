package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete and thouroughly tested
 * Last update: 02/16/2017
 * Submitted: 02/16/2017
 * Comment: test suite and sample attatched
 * @author: Thien Do
 * @version:  2017.02.16
 */
public class ListCDLSBased
{
	private NodeD head;
	private int numItems;
	
	public ListCDLSBased()
	{
		head = null;
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return numItems == 0;
	}
	
	public int size()
	{
		return numItems;
	}
	
	public void add(int index, Object item) throws ListIndexOutOfBoundsException
	{
		if(index >= 0 && index < numItems +1)
		{
			NodeD newNodeD = new NodeD(item);
			
			if (index != 0 && numItems != 0)
			{
				NodeD back = findNew(index - 1);
				newNodeD.setNext(back.getNext());
				back.getNext().setBack(newNodeD);
				back.setNext(newNodeD);
				newNodeD.setBack(back);
			}
			else if (index == 0 && numItems != 0)
			{
				head.getBack().setNext(newNodeD);
				newNodeD.setBack(head.getBack());
				newNodeD.setNext(head);
				head.setBack(newNodeD);
				head = newNodeD;
			}
			else
			{
				head = newNodeD;
			}
			numItems++;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on ADD");
		}
		
	}
	
	public void remove(int index)throws ListIndexOutOfBoundsException
	{
		if(index >= 0 && index < numItems)
		{
			if (index != 0 && numItems != 0)
			{
				NodeD back = findNew(index - 1);
				NodeD curr = back.getNext();
				back.setNext(curr.getNext());
			}
			else if ( index == 0 && numItems >= 2)
			{
				head.getNext().setBack(head.getBack());
				head.getBack().setNext(head.getNext());
				head = head.getNext();
			}
			else if (index == 0 && numItems ==1 )
			{
				head = null;
			}
			numItems --;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on REMOVE");
		}
	}
	
	public void removeAll()
	{
		head = null;
		numItems = 0;
	}
	
	public Object get(int index) throws ListIndexOutOfBoundsException
	{
		Object retrieve = null;
		if(index >=0 && index <= numItems)
		{
			NodeD curr = findNew(index);
			retrieve = curr.getItem();
			return retrieve;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on GET");
		}
	}
	
	public NodeD findOld(int index)
	{
		NodeD curr = head;
		
		for(int i = 0; i < index; i++)
		{
			curr = curr.getNext();
		}
		
		return curr;
	}
	
	public NodeD findNew(int index)
	{
		NodeD curr = head;
		
		if (index >= (numItems/2))
		{
			for(int c = numItems - 1; c >= index; c--)
			{
				curr = curr.getBack();
			}
		}
		else
		{
			for(int c = 0; c < index; c++)
			{
			 	curr = curr.getNext();
			}
		}	
		return curr;
	}
	
	public String toString()
	{
		String s = "";
		int index = 0;
		for(NodeD curr = head; index < numItems; curr = curr.getNext())
		{
			s += curr.getItem() + " ";
			index++;
		}
		
		return s;
	}
	
	
}
