
import java.util.*;
import java.io.*;

public class transform {

	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("transform.in"));
		PrintWriter out = new PrintWriter(new File("transform.out"));
		
		int dim = in.nextInt();
		in.nextLine();
		
		char[][] first = new char[dim][dim];
		char[][] last = new char[dim][dim];
		
		for(int row = 0; row < dim; row++)
		{
			String s = in.nextLine();
			for(int col = 0; col < dim; col++)
			{
				first[row][col] = s.charAt(col);
			}
		}
		
		for(int row = 0; row < dim; row++)
		{
			String s = in.nextLine();
			for(int col = 0; col < dim; col++)
			{
				last[row][col] = s.charAt(col);
			}
		}
		
		if(match(rot1(first), last))
		{
			out.println(1);
			out.close();
		} else if(match(rot2(first), last))
		{
			out.println(2);
			out.close();
		} else if(match(rot3(first), last))
		{
			out.println(3);
			out.close();
		} else if(match(reflection(first), last))
		{
			out.println(4);
			out.close();
		} else if(match(rot1(reflection(first)), last) || match(rot2(reflection(first)), last) || match(rot3(reflection(first)), last))
		{
			out.println(5);
			out.close();
		} else if(match(first, last))
		{
			out.println(6);
			out.close();
		} else
		{
			out.println(7);
			out.close();
		}
	}
	
	public static char[][] rot1(char[][] a)
	{
		char[][] ans = new char[a.length][a.length];
		for(int row = 0; row < a.length; row++)
		{
			for(int col = 0; col < a.length; col++)
			{
				ans[row][col] = a[a.length-1-col][row];
			}
		}
		return ans;
	}
	
	public static char[][] rot2(char[][] a)
	{
		char[][] ans = new char[a.length][a.length];
		for(int row = 0; row < a.length; row++)
		{
			for(int col = 0; col < a.length; col++)
			{
				ans[row][col] = a[a.length-1-row][a.length-1-col];
			}
		}
		return ans;
	}
	
	public static char[][] rot3(char[][] a)
	{
		char[][] ans = new char[a.length][a.length];
		for(int row = 0; row < a.length; row++)
		{
			for(int col = 0; col < a.length; col++)
			{
				ans[row][col] = a[col][a.length-1-row];
			}
		}
		return ans;
	}
	
	public static char[][] reflection(char[][] a)
	{
		char[][] ans = new char[a.length][a.length];
		for(int row = 0; row < a.length; row++)
		{
			for(int col = 0; col< a.length; col++)
			{
				ans[row][a.length-1-col] = a[row][col];
			}
		}
		return ans;
	}
	
	public static boolean match(char[][] a1, char[][] a2)
	{
		for(int i = 0; i < a1.length; i++)
		{
			for(int x = 0; x < a1.length; x++)
			{
				if(a1[i][x] != a2[i][x])
						return false;
			}
		}
		return true;
	}
	
	public static String printArray(char[][] a)
	{
		String ans = "";
		for(int row = 0; row < a.length; row++)
		{
			for(int col = 0; col < a.length; col++)
			{
				ans += a[row][col];
			}
			ans += "\n";
		}
		ans = ans.substring(0, ans.length()-1);
		return ans;
	}

}
