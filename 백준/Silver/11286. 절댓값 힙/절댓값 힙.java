import java.util.*;
import java.io.*;

public class Main{

  public static class Number implements Comparable<Number>{
    int x;
    int abs;
    public Number(int x)
    {
      this.x = x;
      this.abs = Math.abs(x);
    }

    public int compareTo(Number n)
    {
      if(this.abs != n.abs)
      {
        return this.abs - n.abs;
      }else{
        return this.x - n.x;
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Number> queue = new PriorityQueue<>();

    for(int i = 0; i < N; i++)
    {
      int a = Integer.parseInt(br.readLine());
      if(a != 0) queue.add(new Number(a));
      else
      {
        Number num = queue.poll();
        if(num != null) bw.write(num.x+"\n");
        else bw.write("0\n");
      }
    }
    bw.flush();



  }
}