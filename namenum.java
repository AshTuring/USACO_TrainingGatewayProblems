
import java.util.*;
import java.io.*;

public class namenum {

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("namenum.in"));
		Scanner in2 = new Scanner(new File("dict.txt"));
		PrintWriter out = new PrintWriter(new File("namenum.out"));
		
		String[]choices = {"", "", "ABC", "DEF","GHI", "JKL", "MNO", "PRS", "TUV", "WXY"};
		
		ArrayList<String> d = new ArrayList<>();
		while(in2.hasNextLine())
		{
			d.add(in2.nextLine());
		}
		in2.close();
		
		String[] ID = in.nextLine().split("");
		int[] digits = new int[ID.length];
		for(int i = 0; i < digits.length; i++)
		{
			digits[i] = Integer.parseInt(ID[i]);
		}
		
		ArrayList<String> names = new ArrayList<String>();
		
		for(int i = 0; i < d.size(); i++)
		{
			String name = d.get(i);
			if(name.length() != digits.length)
				continue;
			
			boolean works = true;
			for(int x = 0; x < digits.length; x++)
			{
				if(choices[digits[x]].indexOf(name.substring(x, x+1)) == -1)
					works = false;
			}
			if(works)
				names.add(name);
		}
		
		for(String n : names)
		{
			out.println(n);
		}
		
		if(names.size() == 0)
			out.println("NONE");
		
		out.close();

	}

}
