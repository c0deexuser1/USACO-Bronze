import java.io.*;
import java.util.*;
public class Fibonacci {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("../data/1.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int fib_n = Integer.parseInt(st.nextToken());

        System.out.println(fib(fib_n));

    }

    public static int fib(int n)
    {
        if ( n==0)
          return 0;
        if ( n==1 )
          return 1;
        else
          return fib(n-1)+ fib(n-2);
    }
}