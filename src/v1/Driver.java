package v1;
import java.io.*;
/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete and thouroughly tested
 * Last update: 02/16/2017
 * Submitted: 02/16/2017
 * Comment: test suite and sample attatched
 * @author: Thien Do
 * @version:  2017.02.16
 */
public class Driver
{
	static BufferedReader stdin = new BufferedReader ( new  InputStreamReader (System.in));
	
	public static void main(String[] args) throws IOException
	{
		int i;
		ListCDLSBased lb = new ListCDLSBased();
		do
		{
			System.out.println("\n"+"Application's Options: ");
			System.out.println("                       ");
			System.out.println("1. Insert item to list");
			System.out.println("2. Remove item from list");
			System.out.println("3. Get item from list");
			System.out.println("4. Clear list");
			System.out.println("5. Print size and content of list");
			System.out.println("6. Exit Program");
			System.out.println("                       ");
			System.out.println("Choose your option: " + "\n");
			String input = stdin.readLine().trim();
			i = Integer.parseInt(input);
			
			if (i > 0 && i < 7)
			{
				switch(i)
				{
					case 1:
						System.out.println("You are now inserting an item into the list.");
						System.out.println("Enter item:");
						String item = stdin.readLine().trim();
						System.out.println("Enter position to insert item in:");
						String position = stdin.readLine().trim();
						int p = Integer.parseInt(position);
						if (p >= 0 && p <= lb.size())
						{
							lb.add(p, item);
							System.out.println("Item " + item + " inserted in position " + p + " in the list");
						}
						else
						{
							System.out.println("Input of position is out of bound");
						}
					break;
					case 2:
						System.out.println("Select the index of an item you want to remove: ");
						String c2 = stdin.readLine().trim();
						int p2  = Integer.parseInt(c2);
						if (p2 >= 0 && p2 <= lb.size() -1)
						{
							lb.remove(p2);
						}
						else
						{
							System.out.println("Your input is out of bound");
						}
						break;
					case 3:
						System.out.println("Select the index of an item you want to get: ");
						String c3 = stdin.readLine().trim();
						int p3  = Integer.parseInt(c3);
						if (p3 >= 0 && p3 <= lb.size() -1)
						{
							System.out.println( p3 + ". "+lb.get(p3));	
						}
						else
						{
							System.out.println("Your input is out of bound");
						}
						break;
					case 4:
						lb.removeAll();
						System.out.println("List has been cleared");
						break;
					case 5:
						if(lb.isEmpty())
						{	
							System.out.println("List is empty");
						}
						else
						{
							System.out.println("Your list has: " + lb.size() +" item(s)");
							System.out.println(lb.toString());
						}
						break;
					case 6:
						System.out.println("You are now exiting the program.");
				}
			}
		}while(i < 6 || i > 6);
	}
}
