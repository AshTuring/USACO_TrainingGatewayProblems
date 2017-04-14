
import java.util.*;
import java.io.*;

public class friday {

	public static void main(String[] args) throws IOException 
	{
		
		class Calendar
		{
			private int monthIndex;
			private int dayIndex;
			private int year;
			private int[] fCount = {0,0,0,0,0,0,0};
			
			public Calendar()
			{
				year = 1900;
				monthIndex = 0;
				dayIndex = 1; 
			}
			
			public void addMonth()
			{
				dayIndex = (dayIndex + 1) % 7;
				int numDays;
				if(monthIndex == 1)
				{
					if(year % 4 == 0 && year % 100 != 0)
					{
						numDays = 29;
					} else if(year % 400 == 0)
					{
						numDays = 29;
					} else
					{
						numDays = 28;
					}
				} else if(monthIndex == 0 || monthIndex == 2 || monthIndex == 4 || monthIndex == 6 ||monthIndex == 7 || monthIndex == 9 || monthIndex == 11)
				{
					numDays = 31;
				} else
				{
					numDays = 30;
				}
				
				fCount[(dayIndex + 12) % 7] += 1;
				dayIndex = (dayIndex + numDays - 1) % 7;
				monthIndex = (monthIndex + 1) % 12;
				year = (monthIndex == 0) ? year + 1 : year;
			}
			
			public int getYear()
			{
				return year;
			}
			
			
			public String toString()
			{
				String ans = "";
				for(int count: fCount)
					ans += count  + " ";
				ans = ans.trim();
				return ans;
			}
		}
		
		
		Scanner in = new Scanner(new File("friday.in"));
		PrintWriter out = new PrintWriter(new File("friday.out"));
		int N = in.nextInt();
		
		Calendar cal = new Calendar();
		
		while(cal.getYear() < 1900 + N)
		{
			cal.addMonth();
		}
		
		out.println(cal);
		out.close();
	}

}
