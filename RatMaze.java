/*
	the aim is to find a path for a mouse to solve a maze(if one exists). a block is indicated by 0 in maze and a clear way with 1. the mouse begins at 
	box (0,0), and can take any of the two moves: 1) move forward, i.e from left to right, or 2) move downward
*/





import java.util.Arrays;
import java.util.Scanner;

class RatMaze
{
	static boolean issafe(int n, int x, int y,int[][] maze,int[][] sol)                           //check if mouse can move to this square
	{
		return( x<n && y<n && x>=0 && y>=0 && maze[x][y]==1);
	}


	static boolean path(int n,int x, int y, int [] xmoves, int[] ymoves, int[][] maze, int[][] sol)          //pathfinder function
	{

		if(x==n-1 && y==n-1)                                                                             //endpoint has been reached
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
			
			if(path(n,x+1,y,xmoves,ymoves,maze,sol))                                            //check moving forward
			{
				return true;
			}
			
			if(path(n,x,y+1,xmoves,ymoves,maze,sol))                                            //cheeck moving downward
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

		

		
