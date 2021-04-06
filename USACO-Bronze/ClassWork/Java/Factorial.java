import java.io.*;
import java.util.*;
public class Factorial {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("../data/1.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

        System.out.println(fact(n));

    }

    public static int fact(int n)
    {
        if ( n==1)
          return 1;
        else
          return n*fact(n-1);
    }
}