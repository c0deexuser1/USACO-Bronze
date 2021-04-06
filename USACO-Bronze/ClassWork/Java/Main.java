import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


    // Increment Operator ++  --> Increments by 1
    // Decrement Operator --  --> Decrements by 1
    // Operators ==  Equality Opreator
    // Operator >
    // Operator >=
    // Operator <=
    // Operator <
    // Operator +=     x += 2  ==>  x = x +2
    // Operator -=     x -= 1  ==>  x = x -1
    // Operator *=     x *= 2  ==>  x = x*2
    // Prefix and PostFix

    //++i   // Prefix operator  --> Increment the i first before I use it

    //i++   // Postfix operator --> Increment the i after I use it.

    // break
    // continue

    // Homework :  How to find out if a number is prime

    int N = 15;

    for ( int i=2; i<N; i++)
    {
        if( N%i ==0)
        {
            System.out.println("This is not a prime number");
            break;
        }
        // Will have to check if N is divisble by i
        // If it divisble then modulo is 0
    }
    















        // Increment in a for loop.

        /*
        for (int i=0; i <10; i++)
        {
            System.out.println(i);
        }

        // Decrement in a for loop

        for (int i=10; i >0; i--)
        {
            System.out.println(i);
        }

        // Print increment of 2 in a for loop

        for (int i=0; i <10; i+= 2)
        {
            System.out.println(i);
        }

        // Calculate factorial N in a for loop.

        int N = 5;

        int fact = 1;

        for (int i=1; i <= N; i ++)
        {
            fact = fact*i;
        }
        System.out.println(fact);

        // Print powers of 2 in a for loop

        for (int i=0; i < N; i++)
        {
            System.out.println(Math.pow(2, i));
        }

        for(int i = 100; i >= 0; i -= 10 ){
			System.out.print(i + ", ");
		}

        // What does Break statement do ?

        int j = 0;
		for(j = 0; j < 3 ; j++){
			break;
		}
		System.out.println(j);

        // What does Continue statement do ?

        int j = 0;
		for(j = 0; j < 3 ; j++){
			continue;
		}
		System.out.println(j);

        How to find out if a number is prime
        */

    }
}