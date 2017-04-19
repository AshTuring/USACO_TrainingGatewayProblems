/*
ID: -------
LANG: JAVA
TASK: zerosum
*/
import java.util.*;
import java.io.*;

public class zerosum {
	
	static int lim;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("zerosum.in"));
		out = new PrintWriter("zerosum.out");
		
		lim = in.nextInt();
		solve(1, 0);
		
		out.close();
	}
	
	public static void solve(int current, int mask)
	{
		if(current == lim)
		{
			//parse and evaluate
			parse(mask);
			return;
		}
		
		//for each choice, set bits in a particular fashion to clearly read them while parsing
		//merge
		solve(current+1, mask | (1 << (2*(current-1))));
		//add
		solve(current+1, mask | (1 << (2*(current-1))) | (1 << (2*(current-1)+1)));
		//subtract
		solve(current+1, mask);
		
		
	}
	
	public static void parse(int mask)
	{
		//initial string of digits [1, lim]
		StringBuilder exp = new StringBuilder();
		for(int i = 1; i <= lim; i++)
			exp.append(i);
		
		ArrayList<String> op = new ArrayList<>(lim);
		
		//read bitmask to see the operator used at that index, add spaces wherever there is a + or - 
		//and add corresponding operator to op Arraylist
		int position = 0;
		for(int i = 0; i < exp.length()-1; i++)
		{
			if((mask & (1 << (2*position))) > 0  && (mask & (1 << (2*position+1))) > 0)
			{
				op.add("+");
				exp.insert(i+1," ");
				i++;
			} else if((mask & (1 << (2*position))) == 0  && (mask & (1 << (2*position+1))) == 0)
			{
				op.add("-");
				exp.insert(i+1," ");
				i++;
			}	
			position++;	
		}
		
		//evaluate expression with stored operators
		StringTokenizer nums = new StringTokenizer(exp.toString());
		int sum = Integer.parseInt(nums.nextToken());
		
		for(int i = 0; i < op.size(); i++)
		{
			if(op.get(i).equals("+"))
				sum += Integer.parseInt(nums.nextToken());
			else
				sum -= Integer.parseInt(nums.nextToken());	
		}
		
		//if sum is 0, format output correctly and print out
		if(sum == 0)
		{
			nums = new StringTokenizer(exp.toString());
			StringBuilder ans = new StringBuilder(nums.nextToken());
			while(nums.hasMoreTokens())
				ans.append(op.remove(0)+nums.nextToken());
			
			//add spaces between "fused" numbers
			for(int i = 0; i < ans.length()-1; i++)
				if(Character.isDigit(ans.charAt(i)) && Character.isDigit(ans.charAt(i+1)))
				{
					ans.insert(i+1, " ");
					i++;
				}
			
			out.println(ans);
		}
	}
}
