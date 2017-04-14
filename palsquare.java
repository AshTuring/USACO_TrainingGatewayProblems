
import java.util.*;
import java.io.*;

public class palsquare {

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("palsquare.in"));
		PrintWriter out = new PrintWriter(new File("palsquare.out"));
		
		int B = in.nextInt();
		for(int i = 1; i <= 300; i++)
		{
			int num = i*i;
			String s = Integer.toString(num, B);
			if(isPalindrome(s))
			{
				out.println(Integer.toString(i, B).toUpperCase() + " " + s.toUpperCase());
			}
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
