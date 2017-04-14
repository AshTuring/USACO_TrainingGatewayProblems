
import java.util.*;
import java.io.*;

public class milk {

	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("milk.in"));
		PrintWriter out = new PrintWriter(new File("milk.out"));
		
		int goal = in.nextInt();
		int num = in.nextInt();
		
		int[][] shop = new int[2][num];
		
		for(int i = 0; i < num; i++)
		{
			shop[0][i] = in.nextInt();
			shop[1][i] = in.nextInt();
		}
		
		
		mergeSort(shop, 0, shop[0].length-1);
		
		
		int current = 0;
		int cost = 0;
		int index = 0;
		
		
		while(current < goal)
		{
			int amount = shop[1][index];
			if(amount >= (goal - current))
			{
				cost += shop[0][index] * (goal-current);
				current += goal - current;
			} else
			{
				cost += shop[0][index] * shop[1][index];
				current += shop[1][index];
			}
			index++;
		}
		out.println(cost);
		out.close();
		
	}
	
	public static void mergeSort(int[][] a, int p, int r)
	{
		if(p < r)
		{
			int q = (p + r)/2;
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static String printArray(int[][] a)
	{
		String ans = "";
		for(int row = 0; row < a.length; row++)
		{
			for(int col = 0; col < a[0].length; col++)
			{
				ans += a[row][col] + " ";
			}
			ans += "\n";
		}
		ans = ans.substring(0, ans.length()-1);
		return ans;
	}
	
	public static void merge(int[][] a, int p, int q, int r)
	{
		int n1 = q-p+1;
		int n2 = r-q;
		
		int[][] L = new int[2][n1+1];
		int[][] R = new int[2][n2+1];
		
		
		int i = 0;
		for(i = 0; i < L[0].length-1; i++)
		{
			L[0][i] = a[0][i+p];
			L[1][i] = a[1][i+p];
		}
		
		int j = 0;
		for(j = 0; j < R[0].length-1; j++)
		{
			R[0][j] = a[0][q+j+1];
			R[1][j] = a[1][q+j+1];
		}
		
		L[0][L[0].length-1] = Integer.MAX_VALUE;
		L[1][L[1].length-1] = Integer.MAX_VALUE;
		
		R[0][R[0].length-1] = Integer.MAX_VALUE;
		R[1][R[1].length-1] = Integer.MAX_VALUE;
		
		i = 0;
		j = 0;
		
		for(int k = p; k <= r; k++)
		{
			if(L[0][i] <= R[0][j])
			{
				a[0][k] = L[0][i];
				a[1][k] = L[1][i];
				i++;
			} else
			{
				a[0][k] = R[0][j];
				a[1][k] = R[1][j];
				j++;
			}	
		}
		
	}

}
