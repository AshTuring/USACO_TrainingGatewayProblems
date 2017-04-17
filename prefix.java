/*
ID: -----
LANG: JAVA
TASK: prefix
*/
import java.util.*;
import java.io.*;


public class prefix {
	
	static ArrayList<String> p;
	static int length;
	static String seq = "";
	
	static boolean[] memo;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("prefix.in"));
		PrintWriter out = new PrintWriter("prefix.out");
		
		//fill p array with primitives
		int index = 0;
		p = new ArrayList<>(200);
		
		while(in.hasNextLine())
		{
			String[] line = in.nextLine().split(" ");
			if(line[0].equals("."))
				break;
			for(int i = 0; i < line.length; i++)
			{
				p.add(line[i]);
			}
		}
		
		//read in target sequence
		StringBuilder s = new StringBuilder();
		while(in.hasNextLine())
			s.append(in.nextLine());
		seq = s.toString();
		
		
		//initialize memo table
		memo = new boolean[seq.length()+1];
		Arrays.fill(memo, false);
		memo[0] = true;
		
		//bottom-up dynamic programming
		boolean done = false;
		while(!done)
		{
			done = true;
			for(int i = 0; i < memo.length; i++)
			{
				//if current spot is a viable "starting point"
				if(memo[i])
				{
					for(int x = 0; x < p.size(); x++)
					{
						if(valid(p.get(x), i) && !memo[i+p.get(x).length()])
						{
							done = false;
							memo[i+p.get(x).length()] = true;
						}
							
					}
					
				}
			}
			
		}
		
		for(int i = memo.length-1; i >= 0; i--)
			if(memo[i])
			{
				out.println(i);
				out.close();
				return;
			}
		
		out.println("Bug");
		out.close();
		
		/*
			Executing...
			   Test 1: TEST OK [0.166 secs, -1187312 KB]
			   Test 2: TEST OK [0.166 secs, -1187312 KB]
			   Test 3: TEST OK [0.194 secs, -1187312 KB]
			   Test 4: TEST OK [0.238 secs, -1187312 KB]
			   Test 5: TEST OK [0.202 secs, -1187312 KB]
			   Test 6: TEST OK [0.713 secs, -1187312 KB]
	
			All tests OK.
		*/
	}
	
	public static boolean valid(String prefix, int index)
	{
		if(prefix.length() + index > seq.length())
			return false;
		
		for(int i = 0; i < prefix.length(); i++)
			if(prefix.charAt(i) != seq.charAt(i + index))
				return false;
		return true;
	}
	
}
