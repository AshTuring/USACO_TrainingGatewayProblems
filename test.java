
import java.io.*;
import java.util.*;
public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("test.in"));
		PrintWriter out = new PrintWriter(new File("test.out"));
		
		String[] s = in.nextLine().split(" ");
		int ans = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
		
		out.println(ans);
		out.close();
	}

}
