
import java.util.*;
import java.io.*;


public class sprime {
	static StringBuilder ans;
	
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(new File("sprime.in"));
		PrintWriter out = new PrintWriter("sprime.out");
		ans = new StringBuilder();
		//System.out.println(Math.abs(Integer.MIN_VALUE));
		
		int n = in.nextInt();
		int[] firstDigit = {2, 3, 5, 7};
		for(int i = 0; i < firstDigit.length; i++)
			solve(n-1, "" + firstDigit[i]);
		out.print(ans);
		out.close();

	}
	
	
	public static void solve(int n, String s)
	{
		//System.out.println(s+" "+n);
		if(n == 0)
		{
			ans.append(s+"\n");
			return;
		}
			
		
		for(int i = 0; i <= 9; i++)
		{
			int num = Integer.parseInt(s+i);
			if(primalityTest(num))
				solve(n-1, s+i);
		}
	}
	
	public static boolean primalityTest(int n)
	{
		if(n <= 1) return false;
		if(n <= 3) return true;
		
		if(n % 2 == 0 || n%3==0)
			return false;
		
		for(int i = 5; i*i <= n; i+=6)
		{
			if(n%i==0 || n%(i+2) == 0)
				return false;
		}
		return true;
		
	}
}
