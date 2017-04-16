/*
ID: ------
LANG: JAVA
TASK: subset
*/
import java.util.*;
import java.io.*;


public class subset {
	
	static int[] set;
	static long[][] memo;
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("subset.in"));
		PrintWriter out = new PrintWriter("subset.out");
		
		int n = in.nextInt();
		
		set = new int[n];
		for(int i = 0; i < n; i++)
			set[i] = i+1;
		
		memo = new long[n+1][n*(n+1)/4+1];
		for(int i = 0; i < memo.length; i++)
			Arrays.fill(memo[i], -1);
		
		
		if((n*(n+1)/2) % 2 == 1)
			out.println(0);
		else
			out.println(solve(0, 0, n*(n+1)/4)/2);
		out.close();
	/*
		Executing...
		   Test 1: TEST OK [0.166 secs, -1187312 KB]
		   Test 2: TEST OK [0.173 secs, -1187312 KB]
		   Test 3: TEST OK [0.166 secs, -1187312 KB]
		   Test 4: TEST OK [0.194 secs, -1187312 KB]
		   Test 5: TEST OK [0.194 secs, -1187312 KB]
		   Test 6: TEST OK [0.187 secs, -1187312 KB]
		   Test 7: TEST OK [0.173 secs, -1187312 KB]

		All tests OK.
		Your program ('subset') produced all correct answers!  This is your
		submission #2 for this problem.  Congratulations!
	*/
		
	}
	
	public static long solve(int index, int sum, int goal)
	{
		if(index == set.length)
			return (sum == goal) ? 1 : 0;
		
		if(sum > goal)
			return 0;
		
		if(memo[index][sum] != -1)
			return memo[index][sum];
		
		return memo[index][sum] = solve(index+1, sum, goal) + solve(index+1, sum+set[index], goal);
		
	}
}
