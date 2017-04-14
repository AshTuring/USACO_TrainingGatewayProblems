
import java.util.*;
import java.io.*;


public class milk3 {
	
	static boolean[][][] sol;
	static TreeSet<Integer> set;
	static int A;
	static int B;
	static int C;
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("milk3.in"));
		PrintWriter out = new PrintWriter("milk3.out");
		
		A = in.nextInt();
		B = in.nextInt();
		C = in.nextInt();
		sol = new boolean[A+1][B+1][C+1];
		set = new TreeSet<>();
		
		int a = A; int b = B; int c = C;
		
		dfs(0, 0, c);
		out.println(set.toString().replace("[", "").replace("]", "").replace(",", ""));
		out.close();
	}
	
	public static void dfs(int a, int b, int c)
	{
		//System.out.println(a+" "+b+" "+c);
		
		if(sol[a][b][c])
			return;
		
		sol[a][b][c] = true;
		
		if(a == 0)
			set.add(c);
		
		if(a > 0)
		{
			//pour into B
			if(b < B)
				dfs(a - Math.min(a, B-b), b + Math.min(a, B-b), c);
			//pour into C
			if(c < C)
				dfs(a - Math.min(a, C-c), b, c + Math.min(a, C-c));
		}
		
		if(b > 0)
		{
			//pour into A
			if(a < A)
				dfs(a + Math.min(A-a, b), b - Math.min(b, A-a), c);
			
			//pour into C
			if(c < C)
				dfs(a, b - Math.min(b, C-c), c + Math.min(b, C-c));
		}
		
		if(c > 0)
		{
			//pour into A
			if(a < A)
				dfs(a + Math.min(c, A-a), b, c - Math.min(c, A-a));
			
			//pour into B
			if(b < B)
				dfs(a, b + Math.min(c, B-b), c - Math.min(c, B-b));
		}
	}
}
