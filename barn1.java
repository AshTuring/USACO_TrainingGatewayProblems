import java.util.*;
import java.io.*;

public class barn1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("barn1.in"));
		PrintWriter out = new PrintWriter("barn1.out");
		int max = in.nextInt();
		int len = in.nextInt();
		int numCows = in.nextInt();
		
		int[] stalls = new int[numCows];
		
		for(int i = 0; i < numCows; i++)
		{
			int index = in.nextInt();
			stalls[i] = index;
		}
		
		Arrays.sort(stalls);
		
		ArrayList<Integer> arr = new ArrayList<>();

		for(int i = 0; i < stalls.length-1; i++)
		{
			arr.add(stalls[i+1]-stalls[i]-1);
		}
		arr.sort(null);
		Collections.reverse(arr);
		
		
		if(max > numCows)
		{
			out.println(numCows);
			out.close();
			return;
		}
		
		int ans = stalls[stalls.length-1] - stalls[0] + 1;
		for(int i = 0; i < max-1 && i < arr.size(); i++)
		{
			ans -= arr.remove(0);
		}
		System.out.println(ans);
		out.close();
	}

}
