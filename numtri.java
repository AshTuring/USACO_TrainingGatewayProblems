
import java.util.*;
import java.io.*;


public class numtri {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		
		int n = Integer.parseInt(new StringTokenizer(in.readLine()).nextToken());
		int[][] arr = new int[n][];
		
		for(int i = 1; i <= n; i++)
		{
			StringTokenizer str = new StringTokenizer(in.readLine());
			arr[i-1] = new int[i];
			for(int x = 0; x < i; x++)
				arr[i-1][x] = Integer.parseInt(str.nextToken());
		}
		
		
		for(int i = 1; i < arr.length; i++)
		{
			arr[i][0] += arr[i-1][0];
			arr[i][arr[i].length-1] += arr[i-1][arr[i].length-2];
		}
		
		for(int i = 1; i < arr.length; i++)
		{
			for(int x = 1; x < arr[i].length-1; x++)
			{
				arr[i][x] += Math.max(arr[i-1][x-1], arr[i-1][x]);
			}
		}
		
		
		int max = -1;
		for(int i = 0; i < arr[arr.length-1].length; i++)
			max = Math.max(max, arr[arr.length-1][i]);
		

		
		
		out.println(max);
		out.close();

	}
}
