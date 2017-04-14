
import java.util.*;
import java.io.*;

public class gift1 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("gift1.in"));
		PrintWriter out = new PrintWriter(new File("gift1.out"));
		
		int NP = in.nextInt();
		in.nextLine();
		
		ArrayList<String> names = new ArrayList<>(NP);
		int[] current = new int[NP];
		
		for(int i = 0; i < NP; i++)
		{
			names.add(in.nextLine());
			current[i] = 0;
		}
		
		
		for(int i = 0; i < NP; i++)
		{
			int index = names.indexOf(in.nextLine());
			String[] s = in.nextLine().split(" ");
			int total = Integer.parseInt(s[0]);
			int numP = Integer.parseInt(s[1]);
			
			if(numP != 0)
			{
				current[index] += -1*total  + total % numP;
			} else
			{
				current[index] += total; 
			}
			
			for(int x = 0; x < numP; x++)
			{
				current[names.indexOf(in.nextLine())] += total/numP;
			}
		}
		
		for(int i = 0; i < NP; i++)
		{
			out.println(names.get(i) + " " + current[i]);
		}
		out.close();

	}

}
