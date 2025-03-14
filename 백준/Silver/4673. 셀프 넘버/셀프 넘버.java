import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean[] arr = new boolean[10001];

    for(int i = 1; i < 10001; i++)
    {
      int t = create(i);
      if(t < 10001)
      {
        arr[t] = true;
      }
    }

    for(int i = 1; i < 10001; i++)
    {
      if(!arr[i]) bw.write(i+"\n");
    }
    bw.flush();

  }

  public static int create(int n)
  {
    int sum = n;
    while(n != 0)
    {
      sum += n % 10;
      n = n / 10;
    }
    return sum;
  }
}