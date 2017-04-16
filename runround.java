/*
ID: ------
LANG: JAVA
TASK: runround
*/
import java.util.*;
import java.io.*;


public class runround {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("runround.in"));
		PrintWriter out = new PrintWriter("runround.out");
		
		long num = in.nextLong();
		long n = num+1;
		
		while(n < Long.MAX_VALUE) //basically an infinite loop, solution guaranteed at some point
		{	
			if(isRound(n))
			{
				out.println(n);
				out.close();
				return;
			} else
				n++;
		}
		
	/*
		Executing...
		   Test 1: TEST OK [0.209 secs, -1221112 KB]
		   Test 2: TEST OK [0.310 secs, -1187312 KB]
		   Test 3: TEST OK [0.180 secs, -1187312 KB]
		   Test 4: TEST OK [0.216 secs, -1187312 KB]
		   Test 5: TEST OK [0.569 secs, -1187312 KB]
		   Test 6: TEST OK [0.374 secs, -1187312 KB]
		   Test 7: TEST OK [0.576 secs, -1187312 KB]

		All tests OK.
	*/
		
	}
	
	public static boolean isRound(long num)
	{
		String s = num+"";
		if(s.indexOf("0") > -1 || s.length() <= 1)
			return false;
		
		int[] arr = new int[s.length()];
		for(int i = 0; i < s.length(); i++)
			arr[i] = Character.getNumericValue(s.charAt(i));
		
		//check for uniqueness of digits
		int test = 0;
		for(int i = 0; i < arr.length; i++)
		{
			test ^= (1 << arr[i]);
			if((test & (1 << arr[i])) == 0)
				return false;
		}
		
		int mask = 0;
		int index = arr[0] % arr.length;
		
		//make sure no bit is revisited
		while(true)
		{
			if((mask & (1 << index)) != 0)
				break;
			else
				mask |= (1 << index);
			
			if(mask == (1 << arr.length)-1)
				return true;
			
			index = (index + arr[index]) % arr.length;
		}
		
		return false;
		
	}
}
