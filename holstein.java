/*
ID: ---------
LANG: JAVA
TASK: holstein
*/
import java.util.*;
import java.io.*;


public class holstein {
	
	static int sol = Integer.MAX_VALUE;
	static int bitmask = 0;
	
	static int[][] feed;
	static int[] req;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("holstein.in"));
		PrintWriter out = new PrintWriter("holstein.out");
		
		int numVitamins = in.nextInt();
		req = new int[numVitamins];
		for(int i = 0; i < numVitamins; i++)
			req[i] = in.nextInt();
		
		int numFeed = in.nextInt();
		feed = new int[numFeed][numVitamins];
		for(int r = 0; r < numFeed; r++)
			for(int c = 0; c < numVitamins; c++)
				feed[r][c] = in.nextInt();
		
		int[] state = new int[numVitamins];
		
		String ans = solve(state, 0, 0, 0)+"";
		for(int i = 0; i < numFeed; i++)
		{
			if((bitmask & (1 << i)) > 0)
				ans += " "+(i+1);	
		}
		
		out.println(ans);
		out.close();
		
	/*
		Executing...
		   Test 1: TEST OK [0.166 secs, -1187312 KB]
		   Test 2: TEST OK [0.166 secs, -1187312 KB]
		   Test 3: TEST OK [0.166 secs, -1187312 KB]
		   Test 4: TEST OK [0.166 secs, -1187312 KB]
		   Test 5: TEST OK [0.173 secs, -1187312 KB]
		   Test 6: TEST OK [0.194 secs, -1187312 KB]
		   Test 7: TEST OK [0.223 secs, -1187312 KB]
		   Test 8: TEST OK [0.202 secs, -1187312 KB]
		   Test 9: TEST OK [0.223 secs, -1187312 KB]
		   Test 10: TEST OK [0.324 secs, -1187312 KB]

		All tests OK.
		YOUR PROGRAM ('holstein') WORKED FIRST TIME!  That's fantastic
		-- and a rare thing.  Please accept these special automated
		congratulations.
 	*/
	
		
	}
	
	public static int solve(int[] state, int index, int count, int mask)
	{
		//check if requirements are met
		boolean done = true;
		for(int i = 0; i < state.length; i++)
			if(state[i] < req[i])
				done = false;
		
		//if so, compare to best solution found so far
		if(done)
		{
			if(count < sol)
			{
				sol = count;
				bitmask  = mask; 
			}
			return count;
		}
		
		//if all feed options have been used/exhausted, return infinity (worst solution)
		if(index == feed.length && !done)
			return Integer.MAX_VALUE;
		
		
		int[] temp = new int[state.length];
		for(int i = 0; i < feed[index].length; i++)
			temp[i] = state[i] + feed[index][i];
		
		return Math.min(solve(temp, index+1, count+1, mask | (1 << index)), solve(state, index+1, count, mask));
		
			
	}
}
