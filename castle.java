/*
ID: ashwin.13
LANG: JAVA
TASK: castle
*/
import java.util.*;
import java.io.*;


public class castle {
	
	public static void main(String[] args) throws IOException {
//		long start = System.currentTimeMillis();
		
		Scanner in = new Scanner(new File("castle.in"));
		PrintWriter out = new PrintWriter("castle.out");
		int col = in.nextInt();
		int row = in.nextInt();
		
		int[][] board = new int[row][col];
		
		for(int r = 0; r < board.length; r++)
			for(int c = 0; c < board[r].length; c++)
				board[r][c] = in.nextInt();
		
		int[][] comp = new int[row][col];
		for(int i = 0; i < row; i++)
			Arrays.fill(comp[i], -1);
		
		int count = -1;
		for(int r = 0; r < board.length; r++)
			for(int c = 0; c < board[r].length; c++)
			{
				if(comp[r][c] == -1)
				{
					count++;
					comp[r][c] = count;
					fill(board, comp, r, c, count);
				}
			}
		
		int[] size = new int[count+1];
		for(int r = 0; r < comp.length; r++)
			for(int c = 0; c < comp[r].length; c++)
				size[comp[r][c]]++;
		
		//find biggest room
		int biggest = -1;
		for(int i = 0; i < size.length; i++)
			biggest = Math.max(biggest, size[i]);
		
		//find best wall to remove
		int max = biggest;
		int R = -1;
		int C = -1;
		String dir = "";

		for(int c = 0; c < board[0].length; c++)
			for(int r = board.length-1; r >= 0; r--)
			{
				//check north
				if(r-1 >= 0 && hasNorth(board[r][c]) && comp[r][c] != comp[r-1][c])
				{
					int temp = size[comp[r][c]] + size[comp[r-1][c]];
					if(temp > max)
					{
						max = temp; R = r; C = c; dir = "N";
					}
				}
				
				//check east
				if(c+1 < board[r].length && hasEast(board[r][c]) && comp[r][c] != comp[r][c+1])
				{
					int temp = size[comp[r][c]] + size[comp[r][c+1]];
					if(temp > max)
					{
						max = temp; R = r; C = c; dir = "E";
					}
				}
			}
		
		out.println(count+1);
		out.println(biggest);
		out.println(max);
		out.println((R+1)+" "+(C+1)+" "+dir);
		out.close();

		
//		long end = System.currentTimeMillis();
//		System.out.printf("runtime: %.3fs\n", (end-start)/1000.0);
	}
	
	//flood fill algorithm
	public static void fill(int[][] board, int[][] comp, int row, int col, int num)
	{
		//fill west
		if(!hasWest(board[row][col]) && col-1 >= 0 && comp[row][col-1] == -1)
		{
			comp[row][col-1] = num;
			fill(board, comp, row, col-1, num);
		}
		
		//fill east
		if(!hasEast(board[row][col]) && col+1 < board[row].length && comp[row][col+1] == -1)
		{
			comp[row][col+1] = num;
			fill(board, comp, row, col+1, num);
		}
		
		//fill north
		if(!hasNorth(board[row][col]) && row-1 >= 0 && comp[row-1][col] == -1)
		{
			comp[row-1][col] = num;
			fill(board, comp, row-1, col, num);
		}
		
		//fill south
		if(!hasSouth(board[row][col]) && row+1 < board.length && comp[row+1][col] == -1)
		{
			comp[row+1][col] = num;
			fill(board, comp, row+1, col, num);
		}
	}
	
	
	public static boolean hasWest(int num)
	{
		return num % 2 == 1;
	}
	
	public static boolean hasSouth(int num)
	{
		return num >= 8;
	}
	
	public static boolean hasEast(int num)
	{
		if(hasSouth(num))
			num-= 8;
		
		return num >= 4;
	}
	
	
	public static boolean hasNorth(int num)
	{
		if(hasSouth(num))
			num-=8;
		if(hasEast(num))
			num -= 4;
		return num >= 2;
	}
}
