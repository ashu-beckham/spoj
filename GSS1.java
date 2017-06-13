//Do what you can't.
import java.io.*;
import java.util.*;
import java.math.BigInteger;
class GSS1  {
  static int[] seg;
  static int[] a;
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();
    seg = new int[4 * n + 2];
    build(1, 0, n - 1);
    int q = in.nextInt();
    while (q-- > 0) {
      w.println(query(1, 0, n - 1, in.nextInt() - 1, in.nextInt() - 1));
      w.close();
    }
  }
  static void build(int node, int start, int end) {
    if (start > end)
      return;
    if (start == end){
      System.out.println()
      seg[node] = a[start];
      return;
    }
    else {
      int mid = (start + end) / 2;
      build(2 * node, start, mid);
      build(2 * node + 1, mid + 1, end);
      seg[node] = Math.max(seg[2 * node], seg[2 * node + 1]);

    }
  }
  static void update(int node, int start, int end, int ind, int val) {
    if (start == end) {
      //System.out.println("node is : "+node);
      seg[node] = val;

      a[ind] = val;
      return;
    }
    int mid = (start + end) / 2;
    if (start <= ind && mid >= ind)
      update(2 * node, start, mid, ind, val);

    else
      update(2 * node + 1, mid + 1, end, ind, val);

    seg[node] = Math.max(seg[2 * node], seg[2 * node + 1]);

  }
  static int query(int node, int start, int end, int l, int r) {
    if (start > r || end < l)
      return Integer.MIN_VALUE;
    if (l <= start && end <= r)
      return seg[node];
    int mid = (start + end) / 2;
    return Math.max(query(2 * node, start, mid, l, r), query(2 * node + 1, mid + 1, end, l, r));
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
