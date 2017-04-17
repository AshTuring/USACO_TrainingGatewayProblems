/*
ID: -----
LANG: JAVA
TASK: preface
*/
import java.util.*;
import java.io.*;


public class preface {
	static HashMap<Integer, String> map;
	static int[] numerals = {1, 5, 10, 50,100, 500, 1000};
	static String total;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("preface.in"));
		PrintWriter out = new PrintWriter("preface.out");
		
		map = new HashMap<>();
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M"); 
		
		int num = in.nextInt();
		int[] arr = new int[7];
		total = "";
		
		for(int i = 1; i <= num; i++)
		{
			total += roman(i);
			//System.out.println(i+" "+roman(i));
		}
		
		for(int i = 0; i < total.length(); i++)
		{
			char c = total.charAt(i);
			if(c == 'I')
				arr[0]++;
			else if(c=='V')
				arr[1]++;
			else if(c=='X')
				arr[2]++;
			else if(c=='L')
				arr[3]++;
			else if(c=='C')
				arr[4]++;
			else if(c=='D')
				arr[5]++;
			else
				arr[6]++;
		}
		for(int i = 0; i < arr.length; i++)
			if(arr[i] > 0)
			{
				if(i == 0)
					out.println("I " + arr[0]);
				else if(i == 1)
					out.println("V " + arr[1]);
				else if(i == 2)
					out.println("X " + arr[2]);
				else if(i == 3)
					out.println("L " + arr[3]);
				else if(i == 4)
					out.println("C " + arr[4]);
				else if(i == 5)
					out.println("D " + arr[5]);
				else
					out.println("M " + arr[6]);
			}
		
			out.close();
		/*	
			Executing...
			   Test 1: TEST OK [0.173 secs, -1221112 KB]
			   Test 2: TEST OK [0.245 secs, -1187312 KB]
			   Test 3: TEST OK [0.230 secs, -1187312 KB]
			   Test 4: TEST OK [0.238 secs, -1187312 KB]
			   Test 5: TEST OK [0.317 secs, -1187312 KB]
			   Test 6: TEST OK [0.626 secs, -1187312 KB]
			   Test 7: TEST OK [0.490 secs, -1187312 KB]
			   Test 8: TEST OK [0.670 secs, -1187180 KB]
		*/
	}
	
	public static String roman(int n)
	{
		if(map.containsKey(n))
			return map.get(n);
		
		if(n >= 1004)
		{
			int num = n/1000;
			String ans = "";
			for(int i = 0; i < num; i++)
				ans += "M";
			 ans += roman(n-1000*num);
			 map.put(n, ans);
			 return ans;
		}
		
		//use greedy
		String greedy = "";
		{
			int temp = n;
			int thousand = temp/1000;
			for(int i = 0; i < thousand; i++)
				greedy += map.get(1000);
			temp -= 1000*thousand;
			
			int fiveHundred = temp/500;
			for(int i = 0; i < fiveHundred; i++)
				greedy += map.get(500);
			temp -= 500*fiveHundred;
			
			int hundred = temp/100;
			for(int i = 0; i < hundred; i++)
				greedy += map.get(100);
			temp -= 100*hundred;
			
			int fifty = temp/50;
			for(int i = 0; i < fifty; i++)
				greedy += map.get(50);
			temp -= 50*fifty;
			
			int ten = temp/10;
			for(int i = 0; i < ten; i++)
				greedy += map.get(10);
			temp -= 10*ten;
			
			int five = temp/5;
			for(int i = 0; i < five; i++)
				greedy += map.get(5);
			temp -= 5*five;
			
			int one = temp;
			for(int i = 0; i < one; i++)
				greedy += map.get(1);
			temp -= one;
			
			if(valid(greedy))
			{
				map.put(n, greedy);
				return greedy;
			}
				
		}
		
		//find appropriate subsums
		int prev = prefix(n);
		int next = next(n);
		String memo = "";
		if(next-prev == n)
			memo = map.get(prev)+map.get(next);
		else if(next-prev < n)
			memo = map.get(prev)+map.get(next)+roman(n-next+prev);
		else
			memo = map.get(previous(n)) + roman(n-previous(n));
			
		map.put(n, memo);
		return memo;
	}
	
	public static int previous(int n)
	{
		for(int i = numerals.length-1; i >= 0; i--)
			if(numerals[i] < n)
				return numerals[i];
		return -1;
	}
	
	public static int prefix(int n)
	{
		int index ;
		for(index = 0; index < numerals.length; index++)
			if(numerals[index] == next(n))
				break;
		
		for(int i = Math.max(0, index-2); i < index; i++)
			if(!map.get(numerals[i]).equals("V") && !map.get(numerals[i]).equals("L") && !map.get(numerals[i]).equals("D"))
				return numerals[i];
		return -1;
	}
	
	public static int next(int n)
	{
		for(int i = 0; i < numerals.length; i++)
			if(numerals[i]> n)
				return numerals[i];
		return -1;
	}
	
	public static boolean valid(String s)
	{
		if(s.length()==1)
			return true;
		
		if(s.length() == 2)
		{
			String s1 = s.substring(0, 1); String s2 = s.substring(1, 2);
			return !((s1.equals("V") || s1.equals("L") || s1.equals("D")) && (s2.equals("V") || s2.equals("L") || s2.equals("D")));	
		}
		
		for(int i = 0; i < s.length()-1; i++)
		{
			String s1 = s.substring(i, i+1);
			String s2 = s.substring(i+1, i+2);
			
			if(((s1.equals("V") || s1.equals("L") || s1.equals("D")) && 
				(s2.equals("V") || s2.equals("L") || s2.equals("D"))))
				return false;
		}
		
		for(int i = 0; i < s.length()-3; i++)
		{
			String s1 = s.substring(i, i+1);
			String s2 = s.substring(i+1, i+2);
			String s3 = s.substring(i+2, i+3);
			String s4 = s.substring(i+3, i+4);
			
			if(((s1.equals("I") || s1.equals("X") || s1.equals("C") || s1.equals("M"))) &&
				(s1.equals(s2)) &&
				(s2.equals(s3)) &&
				(s3.equals(s4)))
				return false;
		}
		
		return true;
	}
}
