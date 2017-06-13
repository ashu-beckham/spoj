//Do what you can't.

import java.io.*;
import java.util.*;
import java.math.BigInteger;
class GERGOVIA {
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int n = in.nextInt();
    while (n != 0) {
      long[] a = new long[n];
      Deque<Integer> pos = new LinkedList<>();
      Deque<Integer> neg = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        a[i] = in.nextLong();
        if (a[i] > 0)
          pos.add(i);
        else
          neg.add(i);
      }
      long ans = 0;
      while (pos.size() > 0 && neg.size() > 0) {
        //System.out.println("pos is : " + pos);
        //System.out.println("neg is : " + neg);
        long f1 = a[pos.getFirst()];
        long s1 = a[neg.getFirst()];
        long f = Math.abs(f1);
        long s = Math.abs(s1);
        //System.out.println("f is : " + f);
        //System.out.println("s is : " + s);
        if (f < s) {
          ans += f * (Math.abs(pos.getFirst() - neg.getFirst()));
          if (s1 < 0)
            a[neg.getFirst()] += f1;
          else
            a[neg.getFirst()] += f1;
          pos.removeFirst();
        } else if (s < f) {
          ans += s * (Math.abs(pos.getFirst() - neg.getFirst()));
          if (f1 < 0)
            a[pos.getFirst()] += s1;
          else
            a[pos.getFirst()] += s1;
          neg.removeFirst();
        } else {
          ans += s * (Math.abs(pos.getFirst() - neg.getFirst()));
          pos.removeFirst();
          neg.removeFirst();
        }
      }
      w.println(ans);
      n = in.nextInt();
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
