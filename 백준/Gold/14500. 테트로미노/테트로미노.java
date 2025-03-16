
import java.util.*;
import java.io.*;


public class Main{

  static boolean[][] arr;
  static int result = Integer.MIN_VALUE;
  static int[][] board;
  static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
  static int N;
  static int M;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    arr = new boolean[N][M];

    for(int i = 0; i < N; i++)
    {
      StringTokenizer s = new StringTokenizer(br.readLine() , " ");
      for(int j = 0; j < M; j++)
      {
        board[i][j] = Integer.parseInt(s.nextToken());
      }
    }

    for(int i = 0; i < N; i++)
    {
      for(int j = 0; j < M; j++)
      {
        arr[i][j] = true;
        dfs(i,j,1,board[i][j]);
        arr[i][j] = false;
      }
    }

    bw.write(result+"\n");
    bw.flush();
  }

  public static void dfs(int row, int column , int count , int current_value)
  {
    if(count == 4)
    {
      result = Math.max(result,current_value);
      return ;
    }

    //4방향으로 탐색
    for(int i = 0; i < 4; i++){

      int nr = row + dir[i][0];
      int nc = column + dir[i][1];

      //범위 벗어나면 패스
      if (nr < 0 || nc < 0 || nr >= N || nc >= M)
      {
        continue;
      }

      if(!arr[nr][nc]) {

        if(count == 2)
        {
          arr[nr][nc] = true;
          dfs(row, column, count + 1, current_value + board[nr][nc]);
          arr[nr][nc] = false;
        }


        arr[nr][nc] = true;
        dfs(nr, nc, count + 1, current_value + board[nr][nc]);
        arr[nr][nc] = false;
      }




    }





  }

}