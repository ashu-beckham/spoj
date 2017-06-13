//Do what you can't.

import java.io.*;
import java.util.*;
import java.math.BigInteger;
class AMR12D    {
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);

    int t = in.nextInt();
    while (t-- > 0) {
      String s=in.readString();
      int n=s.length();
      HashSet<String> sbs=new HashSet<>();
      for(int i=0;i<n;i++){
        for(int j=i+1;j<=n;j++){
          sbs.add(s.substring(i,j));
        }
      }
      int i=0,sz=sbs.size();
      for(String x:sbs){
        String r=rev(x);
        if (!sbs.contains(r))
          break;
        i++;
      }
      if (i==sz)
        w.println("YES");
      else
        w.println("NO");
    }


    w.close();
  }
  static String rev(String s){
    StringBuilder b = new StringBuilder(s);
    return b.reverse().toString(); 
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
