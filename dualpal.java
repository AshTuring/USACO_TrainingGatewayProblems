
import java.util.*;
import java.io.*;

public class dualpal {

	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("dualpal.in"));
		PrintWriter out = new PrintWriter(new File("dualpal.out"));
		
		int N = in.nextInt();
		int num = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		int n = num + 1;
		while(arr.size() < N)
		{
			int count = 0;
			for(int i = 2; i <= 10; i++)
			{
				String s = Integer.toString(n, i);
				if(isPalindrome(s))
					count++;
			}
			if(count >= 2)
				arr.add(n);
			n++;
		}
		
		for(int number : arr)
		{
			out.println(number);
		}
		out.close();

	}
	
	public static boolean isPalindrome(String s)
	{
		int i1 = 0;
		int i2 = s.length()-1;
		
		while(i1 < i2)
		{
			if(s.charAt(i1) != s.charAt(i2))
				return false;
			i1++;
			i2--;
		}
		return true;
	}

}
