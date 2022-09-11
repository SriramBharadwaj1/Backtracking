import java.util.Arrays;
import java.util.Scanner;

class RatMaze
{
	static boolean issafe(int n, int x, int y,int[][] maze,int[][] sol)
	{
		return( x<n && y<n && x>=0 && y>=0 && maze[x][y]==1);
	}


	static boolean path(int n,int x, int y, int [] xmoves, int[] ymoves, int[][] maze, int[][] sol)
	{

		if(x==n-1 && y==n-1)
		{	
			sol[x][y]=1;
			for(int [] i:sol)
			{
				System.out.println(Arrays.toString(i));
			}
			return true;
		}

	
				
		if(issafe(n,x,y,maze))
		{
			sol[x][y]=1;
			
			if(path(n,x+1,y,xmoves,ymoves,maze,sol))
			{
				return true;
			}
			
			if(path(n,x,y+1,xmoves,ymoves,maze,sol))
			{
				return true;
			}

			sol[x][y]=0;
			return false;
		}

		return false;
	}
		

	public static void main(String[] args)
	{
		int[][] maze={{1,0,0,0},
				  {1,1,0,1},
				  {0,1,0,0},
				  {1,1,1,1}};
		int n=maze.length;
		int[][] sol=new int[n][n];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				sol[i][j]=0;
			}
		}
		
		sol[0][0]=1;

		int[] xmoves={1,0};
		int[] ymoves={0,-1};

		path(n,0,0,xmoves,ymoves,maze,sol);

	}

}

		

		
