import java.io.IOException;
import java.util.*;
import java.io.*;
import java.lang.Math;
import java.math.BigInteger;
import java.util.Arrays;
class ANARC08H  {
	//using josephus iterative method find remaining person
	public static long josh(long n, long k) {
		long a=1;
		for(int i=1;i<=n;i++)
			a=(a+k-1)%i+1;
		return a;
	}
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();  //input number of person
		long k = in.nextLong();
		while (n!=0 && k!=0) {
			//person to be skipped
			long ans = josh(n, k);  //josh method to find remaining person
			System.out.printf("%d %d %d\n", n, k, ans); //output person remained
			n = in.nextLong();  
			k = in.nextLong();
		}
	}
}