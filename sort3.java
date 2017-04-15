
import java.util.*;
import java.io.*;


public class sort3 {
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("sort3.in"));
		PrintWriter out = new PrintWriter("sort3.out");
		
		int num = in.nextInt();
		
		int[] arr = new int[num];
		int one = 0;
		int two = 0;
		int three = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = in.nextInt();
			
			if(arr[i] == 1)
				one++;
			else if(arr[i] == 2)
				two++;
			else
				three++;	
		}
		
		int s1 = 0;
		int e1 = s1+one-1;
		int s2 = e1+1;
		int e2 = s2+two-1;
		int s3 = e2+1;
		int e3 = s3+three-1;
		
		//System.out.printf("%d %d %d %d %d %d\n", s1, e1, s2, e2, s3, e3);
		
		int[][] arr2 = new int[4][4];
		
		//Check section 1
		for(int i = s1; i <= e1; i++)
		{
			arr2[1][arr[i]]++;
		}
		//Check section 2
		for(int i = s2; i <= e2; i++)
		{
			arr2[2][arr[i]]++;
		}
		//Check section 3
		for(int i = s3; i <= e3; i++)
		{
			arr2[3][arr[i]]++;
		}
		
		
		int count = 0;
		
		//Switch 2s and 1s
		int swap = Math.min(arr2[1][2], arr2[2][1]);
		count+= swap;
		arr2[1][2] -= swap;
		arr2[2][1] -= swap;
		
		//Switch 3s and 1s
		swap = Math.min(arr2[1][3], arr2[3][1]);
		count+= swap;
		arr2[1][3] -= swap;
		arr2[3][1] -= swap;
		
		//Switch 3s and 2s
		swap = Math.min(arr2[2][3], arr2[3][2]);
		count+= swap;
		arr2[2][3] -= swap;
		arr2[3][2] -= swap;
		
		//rest of them
		count += (arr2[1][2] + arr2[1][3] + arr2[2][1] + arr2[2][3] + arr2[3][1] + arr2[3][2]) * 2 / 3; 
		out.println(count);
		out.close();

	}
}
