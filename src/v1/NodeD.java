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

public class NodeD 
{
	private Object item;
	private NodeD next;
	private NodeD back;

	public NodeD(Object newItem) 
	{
		item = newItem;
		next = this;
		back = this;
	} 

	public NodeD(Object newItem, NodeD nextNode) 
	{
		item = newItem;
		next = nextNode;
	} 
	
	public NodeD(Object newItem, NodeD nextNode, NodeD backNode)
	{
		item = newItem;
		next = nextNode;
		back = backNode;
	}

	public void setItem(Object newItem) 
	{
		item = newItem;
	} 

	public Object getItem() 
	{
		return item;
	} 

	public void setNext(NodeD nextNode) 
	{
		next = nextNode;
	} 

	public NodeD getNext() 
	{
		return next;
	} 
	
	public void setBack (NodeD backNode)
	{
		back = backNode;
	}
	
	public NodeD getBack()
	{
		return back;
	}
	
}