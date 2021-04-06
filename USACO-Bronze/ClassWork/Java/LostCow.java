import java.io.*;
import java.util.*;
public class LostCow {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("../data/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../data/1.out")));

		// read number of buckets
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x_init = Integer.parseInt(st.nextToken());
		int y_init = Integer.parseInt(st.nextToken());

		int unit = 1;
		boolean found = false;

		int x = x_init;
		int d = 0;

		while(!found)
		{
			x = x_init + unit;
			unit = unit*(-2);

			if(x > y_init)
			{
				found = true;
				d += Math.abs(y_init-x_init);
			}else
			{
				d += 2*Math.abs(x-x_init);
			}
		}

		pw.println(d);

		pw.close();
	}
}