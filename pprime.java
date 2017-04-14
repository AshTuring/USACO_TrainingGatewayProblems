import java.util.*;
import java.io.*;


public class pprime {
	public static void main(String[] args) throws IOException {
		//long start = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		
		StringBuilder ans = new StringBuilder();
		
		StringTokenizer token = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(token.nextToken());
		int b = Integer.parseInt(token.nextToken());
		
		//generate palindromes appropriately
		//single digit
		if(a < 10)
			for(int i = a; i <= Math.min(9, b); i++)
				if(i==5 || i==7) ans.append(i+"\n");
		
		//2 digits
		if(a <= 99 && b > 9)
			//generate all palindromes that are 2 digits long, check if [a, b], and then check primality
			for(int i = 1; i <= 9; i+=2)
			{
					int num = Integer.parseInt(""+i+i);
					if(num >= a && num <= b && primalityTest(num))
						ans.append(num+"\n");
			}
		
		
		//3 digits
		if(a <= 999 && b > 100)
		{
			for(int i = 1; i <= 9; i+=2)
				for(int x = 0; x <= 9; x++)
				{
					int num = Integer.parseInt(""+i+x+i);
					if(num >= a && num <= b && primalityTest(num))
						ans.append(num+"\n");
				}
		}
		
		//4 digits
		if(a <= 9999 && b > 1000)
		{
			for(int i = 1; i <= 9; i+=2)
				for(int x = 0; x <= 9; x++)
				{
					int num = Integer.parseInt(""+i+x+x+i);
					if(num >= a && num <= b && primalityTest(num))
						ans.append(num+"\n");
				}
		}
		
		//5 digits
		if(a <= 99999 && b > 10000)
		{
			for(int i = 1; i <= 9; i+=2)
				for(int x = 0; x <= 9; x++)
					for(int z = 0; z <= 9; z++)
					{
						int num = Integer.parseInt(""+i+x+z+x+i);
						if(num >= a && num <= b && primalityTest(num))
							ans.append(num+"\n");
					}
		}
		
		//6 digits
		if(a <= 999999 && b > 100000)
		{
			for(int i = 1; i <= 9; i+=2)
				for(int x = 0; x <= 9; x++)
					for(int z = 0; z <= 9; z++)
					{
						int num = Integer.parseInt(""+i+x+z+z+x+i);
						if(num >= a && num <= b && primalityTest(num))
							ans.append(num+"\n");
					}
		}
		
		
		//7 digits
		if(a <= 9999999 && b >= 1000000)
		{
			for(int i = 1; i <= 9; i+=2)
				for(int x = 0; x <= 9; x++)
					for(int z = 0; z <= 9; z++)
						for(int y = 0; y <= 9; y++)
						{
							int num = Integer.parseInt(""+i+x+z+y+z+x+i);
							if(num >= a && num <= b && primalityTest(num))
								ans.append(num+"\n");
						}
		}
		
		//8 digits
		if(a <= 99999999 && b >= 10000000)
		{
			for(int i = 1; i <= 9; i+=2)
				for(int x = 0; x <= 9; x++)
					for(int z = 0; z <= 9; z++)
						for(int y = 0; y <= 9; y++)
						{
							int num = Integer.parseInt(""+i+x+z+y+y+z+x+i);
							if(num >= a && num <= b && primalityTest(num))
								ans.append(num+"\n");
						}
		}
		
		
		out.print(ans);
		out.close();
		
		/*long end = System.currentTimeMillis();
		System.out.printf("run time: %.3fs\n", (end-start)/1000.0);*/
		

	}
	
	public static boolean primalityTest(int n)
	{
		if(n <= 1) return false;
		if(n <= 3) return true;
		
		if(n % 2 == 0 || n%3==0)
			return false;
		
		for(int i = 5; i*i <= n; i+=6)
		{
			if(n%i==0 || n%(i+2) == 0)
				return false;
		}
		return true;
		
	}
}
