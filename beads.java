
import java.util.*;
import java.io.*;

public class beads {

	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("beads.in"));
		PrintWriter out = new PrintWriter(new File("beads.out"));
		
		int length = in.nextInt();
		in.nextLine();
		String necklace = in.nextLine();
		int max = -1;
		
		for(int i = 0; i < length-1; i++)
			max = Math.max(max, count(necklace, i));
		
		out.println(max);
		out.close();
		
	}
	
	public static int count(String s, int index)
	{
		int RR = 0;
		int RB = 0;
		String mod = s.substring(index+1) + s;
		int i = s.length() - 1;
		
		while(i >= 0 && (mod.charAt(i) == 'r' || mod.charAt(i) == 'w'))
		{
			RR++;
			i--;
		}
		i = s.length() - 1;
		while(i >= 0 && (mod.charAt(i) == 'b' || mod.charAt(i) == 'w'))
		{
			RB++;
			i--;
		}
		
		int LR = 0;
		int LB = 0;
		i = 0;
		
		while(i <= index && (mod.charAt(i) == 'r' || mod.charAt(i) == 'w'))
		{
			LR++;
			i++;
		}
		i=0;
		while(i <= index && (mod.charAt(i) == 'b' || mod.charAt(i) == 'w'))
		{
			LB++;
			i++;
		}
		
		return Math.min(s.length(), Math.max(RB, RR) + Math.max(LR, LB));
		
	}
	

}
