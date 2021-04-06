import java.io.*;
import java.util.*;
public class StuckInRut {
	public static void main(String[] args) throws IOException {
		// initialize file I/O
		//Scanner s = new Scanner( System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//BufferedReader br = new BufferedReader(new FileReader("../data/1.in"));

		//System.out.println("");

		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../data/1.out")));


		// read number of cows
		StringTokenizer st = new StringTokenizer(br.readLine());
		int no_cows = Integer.parseInt(st.nextToken());

        //Read the cow position and direction
		String [] direction = new String[no_cows];
		int [] x  = new int[no_cows];
		int [] y =  new int[no_cows];

		int max_x = -1;

		for (int i=0; i< no_cows; i++)
		{
		    st = new StringTokenizer(br.readLine());

		    direction[i] = st.nextToken();
		    x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());


		}

        ArrayList<CollisionPoint> collisionPoints = new ArrayList<CollisionPoint>();

		for (int i=0; i< no_cows; i++)
		{
		    for (int j=0; j < no_cows; j++)
		    {
		       if (! direction[i].equals(direction[j]))
		       {
		           int a = i;
		           int b = j;
		           if(direction[a].equals("N"))
		           {
		                swap(a, b);
		           }

		           if ( x[a] < x[b] && y[a]> y[b])
		           {
		               int timeA = x[b] - x[a];
		               int timeB = y[a] - y[b];

                       if ( timeA > timeB )
                       {
                                CollisionPoint p = new CollisionPoint(a, b, timeA, timeB);
                                collisionPoints.add(p);
                       }else if ( timeB > timeA)
                       {
                                CollisionPoint p = new CollisionPoint(a, b, timeA, timeB);
                                collisionPoints.add(p);
                       }

                       // if timeA = timeB, both cow continues as it is so we don't consider them as collision point

		           }

		       }

		    }
		}


		// Sort the collision Points in order of time2;
        int [] stoppedTime = new int[no_cows];
        // Initialize the array to a very large time
        int INF = 100000000;

        for( int i= 0; i < no_cows; i++)
        {
            stoppedTime[i] = INF;
        }

		for ( CollisionPoint p: collisionPoints )
		{
            if ( p.t1 < stoppedTime[p.cow1] &&  p.t2 < stoppedTime[p.cow2] )
             stoppedTime[p.cow2] = p.t2;
             // Cow2 gets stopped because it was slower of the 2
		}

		for (int i=0; i < no_cows; i++)
		{

		    if ( stoppedTime[i] == INF )
		        pw.println("Infinity");
		    else
		        pw.println(stoppedTime[i]);
		}

		pw.close();
	}

	static void swap(int i, int j)
	{
	    int temp = i;
	    i = j;
	    j = temp;
	}
}

class CollisionPoint
{
    CollisionPoint(int i, int j, int ti, int tj)
    {
        cow1 = i;
        cow2 = j;
        t1 = ti;
        t2 = tj;
    }

    int cow1;
    int cow2;
    int t1;
    int t2;
}

