
import java.util.*;
import java.io.*;

public class wormhole {
	static int count = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("wormhole.in"));
		PrintWriter out = new PrintWriter("wormhole.out");
		int num = in.nextInt();
		int[] row = new int[num];
		int[] col = new int[num];
		
		for(int i = 0; i < num; i++)
		{
			col[i] = in.nextInt();
			row[i] = in.nextInt();
		}
		
		int[] pair = new int[num];
		Arrays.fill(pair, -1);
		int[] to_right = new int[num];
		Arrays.fill(to_right, Integer.MAX_VALUE);
		
		boolean[] visited = new boolean[num];
		
		//generate to right
		for(int i = 0; i < num; i++)
			for(int x = 0; x < num; x++)
			{
				if(row[i] == row[x] && col[i] < col[x])
				{
					//if current node is closer right than existing to_right
					if(to_right[i] == Integer.MAX_VALUE || col[x]-col[i] < col[to_right[i]]-col[i])
						to_right[i] = x;
				}
			}

		pair(pair, to_right, visited);
		
		out.println(count);
		out.close();
	}
	
	//utility method that checks if given pairing scheme has cycles
	public static boolean cycle(int[] pair, int[] to_right, boolean[] visited)
	{
		run:
		for(int i = 0; i < pair.length; i++)
		{
			Arrays.fill(visited, false);
			int pos = i;
			visited[pos] = true;
			for(int count = 0; count <= pair.length; count++)
			{
				pos = to_right[pair[pos]];
				if(pos == Integer.MAX_VALUE)
					continue run;
				else if(visited[pos])
					return false;
				visited[pos] = true;
			}
		}
		
		return true;
	}
	
	//recursively generated all possible pairings, then tests each ones
	public static void pair(int[] pair, int[] to_right, boolean[] visited)
	{
		int i;
		for(i = 0; i < pair.length; i++)
		{
			if(pair[i] == -1)
				break;
		}
		
		if(i == pair.length)
		{
			if(!cycle(pair, to_right, visited))
			{
				count++;
			}
				
		}
		
		for(int x = 0; x < pair.length; x++)
		{
			if(x != i && pair[x] == -1)
			{
				pair[i] = x;
				pair[x] = i;
				
				pair(pair, to_right, visited);
				pair[i] = -1;
				pair[x] = -1;
			}
		}
	}

}
