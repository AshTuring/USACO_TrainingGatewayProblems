
import java.util.*;
import java.io.*;

public class crypt1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("crypt1.in"));
		PrintWriter out = new PrintWriter("crypt1.out");

		int n = in.nextInt();
		ArrayList<Integer> nums = new ArrayList<>(n);
		boolean[] present = new boolean[10];
		for(int i = 0; i < n; i++)
		{
			int index = in.nextInt();
			present[index]= true;
			nums.add(index);
		}
			
		nums.sort(null);
		
		int count = 0;
		
		for(int d1 = 0; d1 < nums.size(); d1++)
			for(int d2 = 0; d2 < nums.size() && present[nums.get(d1)]; d2++)
				for(int d3 = 0; d3 < nums.size() && present[nums.get(d2)]; d3++)
					for(int d4 = 0; d4 < nums.size() && present[nums.get(d3)]; d4++)
						run:
						for(int d5 = 0; d5 < nums.size() && present[nums.get(d4)]; d5++)
						{
							
							int p1 = Integer.parseInt(""+nums.get(d1)+nums.get(d2)+nums.get(d3)) * nums.get(d5);
							int p2 = Integer.parseInt(""+nums.get(d1)+nums.get(d2)+nums.get(d3)) * nums.get(d4);
							
							String P1 = p1+""; String P2 = p2+"";
							
							if(P1.length() != 3)
								continue run;
								
							for(int i = 0; i < P1.length(); i++)
								if(!present[Integer.parseInt(P1.charAt(i)+"")])
									continue run;


							if(P2.length() != 3)
								continue run;
							
							for(int i = 0; i < P2.length(); i++)
								if(!present[Integer.parseInt(P2.charAt(i)+"")])
									continue run;

							int p3 = p1 + 10*p2;
							String P3 = p3+"";
							if(P3.length() != 4)
								continue run;
							
							for(int i = 0; i < P3.length(); i++)
								if(!present[Integer.parseInt(P3.charAt(i)+"")])
									continue run;
									
							count++;
									
						}
										
		
		out.println(count);
		out.close();
		
	}

}
