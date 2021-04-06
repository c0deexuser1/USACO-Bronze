import java.io.*;
import java.util.*;
public class Mowing {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("../data/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../data/1.out")));

			// read number of buckets
		StringTokenizer st = new StringTokenizer(br.readLine());
		int no_mows = Integer.parseInt(st.nextToken());

		String [] direction = new String[no_mows];
		int [] units  = new int[no_mows];
		int [][] time_visited = new int[2001][2001];

		int max_x = -1;

		for (int i=0; i< no_mows; i++)
		{
		    st = new StringTokenizer(br.readLine());
		    direction[i] = st.nextToken();

		    units[i] = Integer.parseInt(st.nextToken());

		}

        int currentPosX = 1000;
        int currentPosY = 1000;

        int timeCounter = 0;

        for (int i=0; i< no_mows; i++)
        {
            int directX = 0;
            int directY = 0;

            if (direction[i].equals("S"))
            {
                directY = -1;
            }

            if (direction[i].equals("N"))
            {
                directY = 1;
            }

            if (direction[i].equals("E"))
            {
                directX = 1;
            }

            if (direction[i].equals("W"))
            {
                directX = -1;
            }

            for ( int j=0; j < units[i]; j++)
            {
                timeCounter ++;

                currentPosX += directX;
                currentPosY += directY;
                //System.out.println("X=" +currentPosX + "," + "Y=" + currentPosY );

                if ( time_visited[currentPosX][currentPosY] == 0)
                {
                    time_visited[currentPosX][currentPosY] = timeCounter;
                      // This means this square has not been visited before
                }
                else
                {
                    // This has been visited before - First find out the difference between
                    // last visit and this visit.
                    int timeDiff = timeCounter - time_visited[currentPosX][currentPosY];
                    time_visited[currentPosX][currentPosY] = timeCounter;

                    max_x = (max_x == -1) ? timeDiff : Math.min(timeDiff, max_x);

                }
            }
            }
            pw.println(max_x);
            pw.close();
        }

}