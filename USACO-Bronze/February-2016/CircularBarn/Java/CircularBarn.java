import java.io.*;
import java.util.*;
public class CircularBarn {
	public static void main(String[] args) throws IOException {
		// initialize file I/O
		BufferedReader br = new BufferedReader(new FileReader("../Data/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../Data/1.out")));
		// read in N
		int n = Integer.parseInt(br.readLine());
		int[] cows = new int[n];
		// read in how many cows need to be in each room
		for(int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(br.readLine());
		}
		// the answer cannot exceed N * N * 100, since there are at most 100N cows, each of which can move at most N
		int ans = n * n * 100;
		for(int unlock = 0; unlock < n; unlock++) {
			// assume we unlock the door at index "unlock", compute the distance all cows travel
			int currentDistance = 0;
			for(int offset = 0; offset < n; offset++) {
				// count how many cows have to walk a distance of "offset"
				currentDistance += offset * cows[(unlock+offset)%n];
			}
			// update the answer
			if(currentDistance < ans) {
				ans = currentDistance;
			}
		}
		// print the answer
		pw.println(ans);
		// close output stream
		pw.close();
	}
}