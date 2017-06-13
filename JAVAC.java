//Do what you can't.

import java.io.*;
import java.util.*;
import java.math.BigInteger;
class JAVAC {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    String input=in.nextLine();
    while (!input.equals("")){
      boolean cap=false;
      boolean us=false;
      String ans="";
      int i=0;
      while(i<input.length()){
        char tp=input.charAt(i);
        if (i==0 && ('A'<=tp)&&(tp<='Z'))
          break;
        if ((i==0 || i==input.length()-1) && tp=='_')
          break;
        if (('A'<=tp)&&(tp<='Z'))
          cap=true;
        if (tp=='_')
          us=true;
        if (i+1<input.length() && (tp=='_' && input.charAt(i+1)=='_')){
          break;
        }
        if (cap && us)
          break;
        if (tp=='_' && (i+1)<input.length()){
          ans+=(input.charAt(i+1)+"").toUpperCase();
          if (('A'<=input.charAt(i+1))&&(input.charAt(i+1)<='Z'))
            break;
          i+=2;
          continue;
        }
        else if (('A'<=tp)&&(tp<='Z') )
          ans+="_"+(tp+"").toLowerCase();
        else
          ans+=tp+"";
        i++;
      }
      if (i<input.length())
        System.out.println("Error!");
      else{
        System.out.println(ans);
      }
      if (in.hasNextLine())
        input=in.nextLine();
      else
        input="";

    }
}
}
