/*
ID: ------
LANG: JAVA
TASK: lamps
*/
import java.util.*;
import java.io.*;


public class lamps {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("lamps.in"));
		PrintWriter out = new PrintWriter("lamps.out");
		
		TreeSet<String> ans = new TreeSet<>();
		String initial = "";
		StringBuilder config;
		
		int len = in.nextInt();
		int c = Math.min(in.nextInt(), 3);
		in.nextLine();
		
		String[] s = in.nextLine().split(" ");
		int[] on = new int[s.length-1];
		for(int i = 0; i < on.length; i++)
			on[i] = Integer.parseInt(s[i]);
		
		s = in.nextLine().split(" ");
		int[] off = new int[s.length-1];
		for(int i = 0; i < off.length; i++)
			off[i] = Integer.parseInt(s[i]);
		
		for(int i = 0; i < len; i++)
			initial += "1";

		for(int s1 = 0; s1 <= 1; s1++)
			for(int s2 = 0; s2 <= 1; s2++)
				for(int s3 = 0; s3 <= 1; s3++)
					for(int s4 = 0; s4 <= 1; s4++)
					{
						
						if(c < 4 && s1+s2+s3+s4 > c)
							continue;
						
						config = new StringBuilder(initial);
						
						if(s1 == 1) //toggle all switches
							for(int i = 0; i < config.length(); i++)
								config.setCharAt(i, (config.charAt(i) == '1') ? '0' : '1');
						
						if(s2 == 1) //toggle all odd switches
							for(int i = 0; i < config.length(); i+=2)
								config.setCharAt(i, (config.charAt(i) == '1') ? '0' : '1');
						
						if(s3 == 1) //toggle all even switches
							for(int i = 1; i < config.length(); i+=2)
								config.setCharAt(i, (config.charAt(i) == '1') ? '0' : '1');
						
						if(s4 ==1) //toggle 1, 4, 7...
							for(int i = 0; i < config.length(); i+=3)
								config.setCharAt(i, (config.charAt(i) == '1') ? '0' : '1');
						
						//check if configuration is valid
						boolean valid = true;
						for(int index : on)
							if(config.length()-1 < index || config.charAt(index-1) != '1')
								valid = false;
						if(valid)
							for(int index : off)
								if(config.length()-1 < index || config.charAt(index-1) != '0')
									valid = false;
						if(valid)
						{
							ans.add(config.toString());
						}
							
					}
		
		ArrayList<String> printout = new ArrayList<>();
		printout.addAll(ans);
		
		if (printout.size() == 0)
			out.println("IMPOSSIBLE");
		else
			for (String bits : printout)
				out.println(bits);
		
		out.close();
	/*
		Executing...
		   Test 1: TEST OK [0.202 secs, -1187312 KB]
		   Test 2: TEST OK [0.209 secs, -1187312 KB]
		   Test 3: TEST OK [0.180 secs, -1187312 KB]
		   Test 4: TEST OK [0.173 secs, -1187312 KB]
		   Test 5: TEST OK [0.187 secs, -1187312 KB]
		   Test 6: TEST OK [0.180 secs, -1187312 KB]
		   Test 7: TEST OK [0.173 secs, -1187312 KB]
		   Test 8: TEST OK [0.173 secs, -1187312 KB]

		All tests OK.
		Your program ('lamps') produced all correct answers!  This is your
		submission #2 for this problem.  Congratulations!
	*/
		
	}
}
