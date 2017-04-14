
import java.util.*;
import java.io.*;
import java.awt.geom.Rectangle2D;

public class milk2 {

	public static void main(String[] args) throws IOException
	{
		
		class Interval implements Comparable<Interval>
		{
			private int head;
			private int tail;

			public Interval(int h, int t)
			{
				head = h;
				tail = t;
			}

			public int getHead()
			{
				return head;
			}

			public int getTail()
			{
				return tail;
			}
			
			public int compareTo(Interval other)
			{
				if(this.getHead() != other.getHead())
				{
					return this.getHead() - other.getHead();
				}
				return this.getTail() - other.getTail();
			}
			
			public String toString()
			{
				return String.format("[%d, %d]", getHead(), getTail());
			}
		}
		
		Scanner in = new Scanner(new File("milk2.in"));
		PrintWriter out = new PrintWriter(new File("milk2.out"));
		
		//Get intervals
		ArrayList<Interval> arr = new ArrayList<>();
		int trials = in.nextInt();
		for(int i = 0; i < trials; i++)
		{
			arr.add(new Interval(in.nextInt(), in.nextInt()));
		}
		Collections.sort(arr);
		
		//Find unions
		ArrayList<Interval> union = new ArrayList<>();
		union.addAll(arr);
		int i = 0;
		while(i < union.size()-1)
		{
			Interval i1 = union.get(i);
			Interval i2 = union.get(i+1);
			if(i1.getTail() >= i2.getHead())
			{
				union.add(i, new Interval(i1.getHead(), Math.max(i2.getTail(), i1.getTail())));
				union.remove(i+1);
				union.remove(i+1);
				
			} else
			{
				i++;
			}
				
		}
		
		int maxYes = 0;
		int maxNo = 0;
		for(i = 0; i < union.size()-1; i++)
		{
			maxNo = Math.max(maxNo, union.get(i+1).getHead()-union.get(i).getTail());
			maxYes = Math.max(maxYes, union.get(i).getTail()-union.get(i).getHead());
		}
		maxYes = Math.max(maxYes, union.get(i).getTail()-union.get(i).getHead());
		
		System.out.println(maxYes  + " " + maxNo);
		out.close();
	}

}
