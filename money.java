/*
ID: -------
LANG: JAVA
TASK: money
*/
import java.util.*;
import java.io.*;


public class money {
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("money.in"));
		PrintWriter out = new PrintWriter("money.out");
		
		int numCoins = in.nextInt();
		int total = in.nextInt();
		
		int[] coins = new int[numCoins];
		long[] memo = new long[total+1];
		memo[0] = 1;
		
		for(int i = 0;i < numCoins; i++)
			coins[i] = in.nextInt();
		
		for(int i = 0; i < numCoins; i++)
			for(int x = coins[i]; x < memo.length; x++)
				memo[x] += memo[x - coins[i]];
		
		out.println(memo[memo.length-1]);
		out.close();
		
		/*	
			Executing...
			   Test 1: TEST OK [0.173 secs, -1187312 KB]
			   Test 2: TEST OK [0.173 secs, -1187312 KB]
			   Test 3: TEST OK [0.166 secs, -1187312 KB]
			   Test 4: TEST OK [0.180 secs, -1187312 KB]
			   Test 5: TEST OK [0.180 secs, -1187312 KB]
			   Test 6: TEST OK [0.180 secs, -1187312 KB]
			   Test 7: TEST OK [0.173 secs, -1187312 KB]
			   Test 8: TEST OK [0.173 secs, -1187312 KB]
			   Test 9: TEST OK [0.223 secs, -1187312 KB]
			   Test 10: TEST OK [0.173 secs, -1187312 KB]
			   Test 11: TEST OK [0.173 secs, -1187312 KB]
			   Test 12: TEST OK [0.216 secs, -1187312 KB]
			   Test 13: TEST OK [0.216 secs, -1187312 KB]
	
			All tests OK.
		*/

	}
}
