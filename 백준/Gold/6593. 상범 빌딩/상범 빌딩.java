import java.util.*;
import java.io.*;

public class Main{
  public static int l;
  public static int r;
  public static int c;

  public static boolean[][][] visited;
  public static char[][][] arr;
  public static int[][] dir = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,-1},{0,0,1}};
  public static class Info{
    int l;
    int r;
    int c;
    int num;

    public Info(int l , int r , int c,int num){
     this.l = l;
     this.r = r;
     this.c = c;
     this.num = num;
    }
    public Info(){}
  }
  public static void main(String[] args) throws IOException{

    //상 하 좌 우 동 서 이동
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true)
    {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      l = Integer.parseInt(st.nextToken());
      if(l == 0) break;
      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      arr = new char[l][r][c];
      visited = new boolean[l][r][c];
      Info start = new Info();

      //배열 안에 집어 넣기
      for(int j = 0; j < l; j++)
      {
        for(int k = 0; k < r; k++)
        {
          char[] s = br.readLine().toCharArray();
          for(int m = 0; m < c; m++)
          {
            arr[j][k][m] = s[m];
            if(s[m] == 'S') start = new Info(j,k,m,0);
          }
        }
        br.readLine();
      }

      // 시작점 넣고 탐색 시작
      int result = bfs(start);
      if(result == -1) bw.write("Trapped!\n");
      else bw.write("Escaped in " + result +" minute(s).\n");

    }
    bw.flush();


  }


  public static int bfs(Info start)
  {
    //큐에 지금 좌표 넣기
    Queue<Info> queue = new LinkedList<>();
    queue.add(start);

    //queue안에서 원소 꺼내며 반복
    while(!queue.isEmpty())
    {

      Info loc = queue.poll();
      visited[loc.l][loc.r][loc.c] = true;

      for(int i = 0; i < 6; i++)
      {
        int nl = loc.l + dir[i][0];
        int nr = loc.r + dir[i][1];
        int nc = loc.c + dir[i][2];

        if(nl >=0 && nl < l && nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nl][nr][nc])
        {
          visited[nl][nr][nc] = true;
          if(arr[nl][nr][nc] == 'E') return loc.num + 1;
          else if (arr[nl][nr][nc] == '.') queue.add(new Info(nl,nr,nc,loc.num+1));
        }
      }
    }
    return -1;
  }
}