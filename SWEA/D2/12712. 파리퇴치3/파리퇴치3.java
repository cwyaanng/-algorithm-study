
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] table = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    table[i][j] = sc.nextInt();
                }
            }
            
            int result = Integer.MIN_VALUE; 
            
            int[][] dir1 = {{-1,-1} , {-1 , 1}, {1,1} , {1,-1}};
            int[][] dir2 = {{-1,0},{0,-1},{1,0},{0,1}};
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    int way1 = table[i][j];
                    int way2 = table[i][j]; 
                    for(int k = 1; k < m; k++)
                    {
                        for(int p = 0; p < 4; p++)
                        {
                            if(i + dir1[p][0]*k >=0 && i + dir1[p][0]*k < n
                               && j+dir1[p][1] * k >= 0 && j+dir1[p][1] * k < n)
                            {
                                way1 += table[i + dir1[p][0]*k][j+dir1[p][1] * k]; 
                            }
                            if(i + dir2[p][0]*k >=0 && i + dir2[p][0]*k < n
                               && j+dir2[p][1] * k >= 0 && j+dir2[p][1] * k < n)
                            {
                                way2 += table[i + dir2[p][0]*k][j+dir2[p][1] * k]; 
                            }
                        }
                    }
                    way1 = Math.max(way1, way2);
                    result = Math.max(result, way1); 
                }
            }
            System.out.println("#"+test_case+" "+result);
		}
        
	}
}