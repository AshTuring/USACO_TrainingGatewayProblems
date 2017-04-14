
import java.util.*;
import java.io.*;

public class combo {

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("combo.in"));
		PrintWriter out = new PrintWriter(new File("combo.out"));
		
		int N = in.nextInt();
		int[] lock = {in.nextInt(),in.nextInt(), in.nextInt()};
		int[] master = {in.nextInt(), in.nextInt(),in.nextInt()};
		
		int count = 0;
		
		for(int i= 1 ; i <= N; i++)
		{
			for(int x = 1; x<= N; x++)
			{
				for(int y = 1; y <= N; y++)
				{
					boolean lockWorks0 = i == lock[0] || right(i, N) == lock[0] || right(right(i,N),N) == lock[0] || left(i,N) == lock[0] || left(left(i,N),N) == lock[0];
					boolean lockWorks1 = x == lock[1] ||right(x, N) == lock[1] || right(right(x,N),N) == lock[1] || left(x,N) == lock[1] || left(left(x,N),N) == lock[1];
					boolean lockWorks2 = y == lock[2] || right(y, N) == lock[2] || right(right(y,N),N) == lock[2] || left(y,N) == lock[2] || left(left(y,N),N) == lock[2];
					
					boolean masterWorks0 = i == master[0]|| right(i, N) == master[0] || right(right(i,N),N) == master[0] || left(i,N) == master[0] || left(left(i,N),N) == master[0];
					boolean masterWorks1 = x == master[1] || right(x, N) == master[1] || right(right(x,N),N) == master[1] || left(x,N) == master[1] || left(left(x,N),N) == master[1];
					boolean masterWorks2 = y == master[2] || right(y, N) == master[2] || right(right(y,N),N) == master[2] || left(y,N) == master[2] || left(left(y,N),N) == master[2];
					
					if((lockWorks0 && lockWorks1 && lockWorks2) ||(masterWorks0 && masterWorks1 && masterWorks2))
						count++;
					
				}
			}
		}
		
		out.println(count);
		out.close();

	}
	
	public static int right(int val, int N)
	{
		if(N==1)
			return 1;
		
		int mod = val + 1;
		if(mod > N)
			return mod %= N;
		
		return mod;
	}
	
	public static int left(int val, int N)
	{
		if(N==1)
			return 1;
		int mod =val -1;
		if(mod < 1)
			return N;
		
		return mod;
	}

}
