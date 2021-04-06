import java.io.*;
import java.util.*;
public class Random {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("../Data/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../Data/1.out")));

		// read in the locations of the corners of the rectangles
		StringTokenizer st = new StringTokenizer(br.readLine());
		int bx = Integer.parseInt(st.nextToken());
		int by = Integer.parseInt(st.nextToken());

		// read in the locations of the corners of the rectangles
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());


		int ax = 0;
		int ay = 0;

		int t = 0; //keep track of time

		while ( ax < bx && ay < by)
		{
			ax += m ;
			ay += n;
			bx -= p;
			by -= q;

			t += 1;
		}

		if ( ax == bx && ay == by )
		{
				pw.println(t);
		} else
		{
			pw.println(-1);
		}
		pw.close();



	}
}