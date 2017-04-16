/*
ID: -------
LANG: JAVA
TASK: hamming
*/
import java.util.*;
import java.io.*;



public class hamming {
	
	static String sol = "";

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("hamming.in"));
		PrintWriter out = new PrintWriter("hamming.out");
		
		int num = in.nextInt();
		int len = in.nextInt();
		int dist = in.nextInt();
		
		int[] nums = new int[num];
		
		solve(0, 1, len, dist, nums);
		
		String[] s = sol.trim().split(" ");
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < s.length;i++)
		{
			if((i+1) % 10 == 0 || i == s.length-1)
			{
				ans.append(s[i]+"\n");
			} else
				ans.append(s[i]+" ");
		}
		
		out.print(ans);
		out.close();
		
	/*
		Executing...
		   Test 1: TEST OK [0.173 secs, -1187312 KB]
		   Test 2: TEST OK [0.173 secs, -1187312 KB]
		   Test 3: TEST OK [0.166 secs, -1187312 KB]
		   Test 4: TEST OK [0.166 secs, -1187312 KB]
		   Test 5: TEST OK [0.187 secs, -1187312 KB]
		   Test 6: TEST OK [0.173 secs, -1187312 KB]
		   Test 7: TEST OK [0.173 secs, -1187312 KB]
		   Test 8: TEST OK [0.194 secs, -1187312 KB]
		   Test 9: TEST OK [0.180 secs, -1187312 KB]
		   Test 10: TEST OK [0.187 secs, -1187312 KB]
		   Test 11: TEST OK [0.209 secs, -1187312 KB]
		
		All tests OK.
		YOUR PROGRAM ('hamming') WORKED FIRST TIME!  That's fantastic
		-- and a rare thing.  Please accept these special automated
		congratulations.
	 */
		

	}
	
	public static boolean solve(int current, int index, int len, int ham, int[] nums)
	{
		
		if(index == nums.length)
		{
			String ans= "";
			for(int bit : nums)
				ans += " "+bit;
			
			sol = ans;
			return true;
		}
		
		for(int i = current+1; i <= (1 << len); i++)
		{
			boolean works = true;
			for(int x = 0; x < index; x++)
				if(distance(nums[x], i) < ham)
				{
					works = false; break;
				}
			
			if(works)
			{
				nums[index] = i;
				if(solve(i, index+1, len, ham, nums))
					return true;
				
				nums[index] = 0;
				continue;
			}
		}
		
		return false;
	}
	
	public static int distance(int i1, int i2)
	{
		String s = Integer.toString(i1^i2, 2);
		
		int count = 0;
		for(int i = 0; i < s.length(); i++)
			if(s.charAt(i) == '1')
				count++;
		return count;
	}
}
