import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();
    String target = br.readLine();

    int i = 0;
    int count = 0;
    while(i+target.length()-1 < s.length())
    {
      if(s.substring(i,i+target.length()).equals(target))
      {
        count += 1;
        i += target.length();
      }else{
        i++;
      }
    }




    bw.write(count+"\n");
    bw.flush();
  }
}