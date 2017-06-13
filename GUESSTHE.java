//Do what you can't.

import java.io.*;
import java.util.*;
import java.math.BigInteger;
class GUESSTHE {
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    String s = in.readString();
    while (!s.equals("*")) {
      char[] ca = s.toCharArray();
      if (ca[0] == 'N') {
        w.println(-1);
        s = in.readString();
        continue;
      }
      ArrayList<Long> lcm = new ArrayList<>();
      ArrayList<Long> nm = new ArrayList<>();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'Y')
          lcm.add((long)(i + 1));
        else
          nm.add((long)(i + 1));
      }
      long LCM = lcm.get(0);
      for (int i = 1; i < lcm.size(); i++) {
        LCM = lcM(LCM, lcm.get(i));
      }
      int i = 0;
      for (; i < nm.size(); i++) {
        if (LCM % nm.get(i) == 0)
          break;
      }
      if (i == nm.size())
        w.println(LCM);
      else
        w.println(-1);
      s = in.readString();
    }
    w.close();
  }
  static long gcd(long a, long b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }
  static long lcM(long a, long b) {
    return (a * b) / (gcd(a, b));
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