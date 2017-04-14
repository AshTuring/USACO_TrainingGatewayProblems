
import java.util.*;
import java.io.*;

public class ride {

	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("ride.in"));
		PrintWriter out = new PrintWriter("ride.out");
		
		char[] comet = in.nextLine().toCharArray();
		char[] name = in.nextLine().toCharArray();
		
		if(score(comet) % 47 == score(name) % 47)
		{
			out.println("GO");
		} else
		{
			out.println("STAY");
		}
		out.close();
	}
	
	public static int score(char[] arr)
	{
		if(arr.length == 0)
			return 0;
		
		int ans = 1;
		for(char c : arr)
		{
			ans *= (c-64);
		}
		return ans;
	}

}
