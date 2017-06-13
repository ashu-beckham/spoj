//Do what you can't.

import java.io.*;
import java.util.*;
import java.math.BigInteger;
class ACPC11C {
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int[] a = new int[n + 2];
      for (int i = 1; i <= n; i++)
        a[i] = in.nextInt();
      int[] fsum = new int[n + 2];
      for (int i = 1; i <= n; i++)
        fsum[i] = fsum[i - 1] + a[i];
      int[] bsum = new int[n + 2];
      for (int i = n; i >= 1; i--)
        bsum[i] = bsum[i + 1] + a[i];
      //System.out.println("fsum is: " + Arrays.toString(fsum));
      //System.out.println("bsum is: " + Arrays.toString(bsum));
      int minl = Integer.MAX_VALUE;
      for (int i = 1; i <= n; i++) {
        if (2 * fsum[i - 1] + bsum[i + 1] < minl)
          minl = 2 * fsum[i - 1] + bsum[i + 1] ;
        if (2 * bsum[i + 1] + fsum[i - 1] < minl)
          minl = 2 * bsum[i + 1] + fsum[i - 1];

      }
      w.println(minl);
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
