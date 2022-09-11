/*
	the aim of this problem is to find a path on the chessboard so that  a knight piece should reach each square exactly once, following th rules of Chess. 
	The knight begins from position (0,0) of the chessboard. 
	a matrix will be displayed, with each square filled with the path step at which that square has been covered
*/


import java.util.Arrays;
import java.util.Scanner;

class Knight
{
	static boolean is_safe(int n,int x, int y, int[][] sol)                                             //check if that square is safe to land
	{	
		return(x >= 0 && x < n && y >= 0 && y < n && sol[x][y] == -1);
	}

	static boolean knightTour(int n,int x,int y, int counter, int[][] sol,int[] xmoves, int[] ymoves)         //moving Knight
	{
		if(counter==n*n)                                                                                  //all squares have been covered
		{	for(int[] i:sol)
			{
				System.out.println(Arrays.toString(i));                                           //print the sequence
			}
			return true;
		}
		
		for(int k=0;k<8;k++)                                                                        //trying each of the 8 possible moves a knight can make
		{
			int nextx=x+xmoves[k];
			int nexty=y+ymoves[k];
			
			if(is_safe(n,nextx,nexty,sol))
			{
				sol[nextx][nexty]=counter;
				if(knightTour(n,nextx,nexty,counter+1,sol,xmoves,ymoves))                      //if this path followed leads to a solution, then return true
				{
					return true;
				}

				else                                                                         // if a solution cannot be found on this path, retace back one stage
				{
					sol[nextx][nexty]=-1;
				}
			}
		}
		

		return false;
	}

		

	
	
		
	public static void main(String[] args)                                                             //driver code
	{
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[][] sol=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				sol[i][j]=-1;
			}
		}
		for(int[] i:sol)
		{
			System.out.println(Arrays.toString(i));
		}


		sol[0][0]=0;
		int[] xmoves=new int[]{2, 1, -1, -2, -2, -1, 1, 2};
		int[] ymoves=new int[]{ 1, 2, 2, 1, -1, -2, -2, -1 };

		knightTour(n,0,0,1,sol,xmoves,ymoves);
	}
}
