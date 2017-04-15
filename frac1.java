import java.util.*;
import java.io.*;


public class frac1 {
	
	public static class FracSort implements Comparator<String>
	{
		public FracSort()
		{ 
			
		}
		
		public int compare(String s1, String s2)
		{
			Double d1 = new Double(Double.parseDouble(s1.substring(0, s1.indexOf("/")))/Double.parseDouble(s1.substring(s1.indexOf("/")+1)));
			Double d2 = new Double(Double.parseDouble(s2.substring(0, s2.indexOf("/")))/Double.parseDouble(s2.substring(s2.indexOf("/")+1)));
			
			return d1.compareTo(d2);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("frac1.in"));
		PrintWriter out = new PrintWriter("frac1.out");
		
		StringBuilder ans = new StringBuilder("0/1\n");
		Set<Double> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		
		int num = in.nextInt();
		for(int n = 1; n <= num; n++)
			for(int d = n; d <= num; d++)
			{
				if(n % 2 == 0 && d % 2 == 0)
					continue;
				
				double frac = (double)n/d;
				if(set.contains(frac))
					continue;
				
				set.add(frac);
				list.add(n+"/"+d);
				
			}
		
		list.sort(new FracSort());
		for(String s : list)
			ans.append(s+"\n");
		
		out.print(ans);
		out.close();

	}
}
