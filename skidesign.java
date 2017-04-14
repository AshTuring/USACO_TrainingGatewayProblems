
import java.util.*;
import java.io.*;

public class skidesign {

	public static void main(String[] args) throws IOException {
	
		Scanner in = new Scanner(new File("skidesign.in"));
		PrintWriter out = new PrintWriter(new File("skidesign.out"));
		
		int num = in.nextInt();
		int[] hills = new int[num];
		
		for(int i = 0; i < num; i++)
			hills[i] = in.nextInt();
		
		int min = Integer.MAX_VALUE;
		
		for(int x = 0; x <= 83; x++)
		{
			int sum = 0;
			for(int n : hills)
			{
				if(n < x || n > x+17)
					sum += (int)Math.pow(Math.min(Math.abs(n - x), Math.abs(n - (x+17))),2);
			}
			//System.out.println(sum);
			min = Math.min(min, sum);
		}
		
		out.println(min);
		out.close();
	}
	


}
