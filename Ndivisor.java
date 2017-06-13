//Do what you can't.
//MAY13D

import java.io.*;
import java.util.*;
import java.math.BigInteger;
class Ndivisor {
  static boolean[] primes;
  static int[] div;
  static PrintWriter w = new PrintWriter(System.out);
  static void  sieve(int l,int r){
    primes=new boolean[r-l+1];
    Arrays.fill(primes,true);
    for (int i = 2; i * i <= r; i++) {
    for (int j = Math.max(i * i, (l + (i - 1)) / i  * i); j <= r; j += i) {
        primes[j - l] = false;
      }
    }
    //System.out.println("array is : "+Arrays.toString(primes));
    for (int i = Math.max(l, 2); i <= r; i++) {
    if (primes[i - l]) {
        w.println((i)+" ");
    }
    }


  }
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);

    int t=in.nextInt();
    while (t-->0){
    int a=in.nextInt(),b=in.nextInt();
    sieve(a, b);
    w.println();
    }
    w.close();
    }

  static class InputReader {

    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, snumChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int snext() {
      if (snumChars == -1)
      throw new InputMismatchException();
      if (curChar >= snumChars) {
        curChar = 0;
        try {
          snumChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (snumChars <= 0)
        return -1;
      }
      return buf[curChar++];
    }

    public int nextInt() {
      int c = snext();
      while (isSpaceChar(c)) {
        c = snext();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = snext();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9')
        throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = snext();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public long nextLong() {
      int c = snext();
      while (isSpaceChar(c)) {
        c = snext();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = snext();
      }
      long res = 0;
      do {
        if (c < '0' || c > '9')
        throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = snext();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public int[] nextIntArray(int n) {
      int a[] = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = nextInt();
      }
      return a;
    }

    public String readString() {
      int c = snext();
      while (isSpaceChar(c)) {
        c = snext();
      }
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = snext();
      } while (!isSpaceChar(c));
      return res.toString();
    }

    public String nextLine() {
      int c = snext();
      while (isSpaceChar(c))
      c = snext();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = snext();
      } while (!isEndOfLine(c));
      return res.toString();
    }

    public boolean isSpaceChar(int c) {
      if (filter != null)
      return filter.isSpaceChar(c);
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
      return c == '\n' || c == '\r' || c == -1;
    }

    public interface SpaceCharFilter {
      public boolean isSpaceChar(int ch);
    }
  }
}
