package Rally.Org.Candidate.gameOfLife;

import java.util.Random;


public class GameOfLife {
	
	
public static final  int size=5;
	

	private  int[][] IterateBoard(int[][] board) {
		
		int[][] evolvedBoard= new int[size][size];
		
	//	int count=1;
		for(int i=0; i< board.length;i++){
			for(int j=0; j< board.length;j++){
				// current cell
				
				int currentCell= board[i][j];
				int liveCellsCount=0;
				
				//survey neighbors
				//right
				if(verify(i,j+1)){
					if(board[i][j+1] ==1 ){
						liveCellsCount++;
					}
				
				}
			
				//left
				if( verify(i,j-1)){
					if(board[i][j-1] ==1){
						liveCellsCount++;
					}
					
				}
				//top
		
				if (verify(i-1,j)){
					if(board[i-1][j] ==1){
						
						liveCellsCount++;
					}
					
				}

				//down
					if( verify(i+1,j)){
						if(board[i+1][j] ==1){
							liveCellsCount++;
						}
						
					}
			
				//top-left
					if( verify(i-1,j-1)){
						if(board[i-1][j-1] ==1){
							liveCellsCount++;
						}
						
					}
								
				//top-right
					if(verify(i-1,j+1)){
						if(board[i-1][j+1] ==1){
							liveCellsCount++;
						}
						
					}
				
				//bottom-right
					if( verify(i+1,j+1)){
						if(board[i+1][j+1] ==1){
							liveCellsCount++;
						}
						
					}
			
				//bottom- left
					if( verify(i+1,j-1)){
						if(board[i+1][j-1] ==1){
							liveCellsCount++;
						}
						
					}

					evolve(board, evolvedBoard, i, j, currentCell,
							liveCellsCount);

			}// end of currnet element

		}
		return evolvedBoard;
	}



	/**
	 * Decsion making is done here.
	 * @param board
	 * @param evolvedBoard
	 * @param i
	 * @param j
	 * @param currentCell
	 * @param liveCellsCount
	 */
	private void evolve(int[][] board, int[][] evolvedBoard, int i, int j,
			int currentCell, int liveCellsCount) {
		evolvedBoard[i][j]=board[i][j];
		//if alive ; 
		if(currentCell ==1){
			//kill due to over population - or lack of live neighbors
			if(liveCellsCount >  3   || ( liveCellsCount< 2) )   {
				evolvedBoard[i][j]=0; // kill
			}	
		}
		//if dead
		
		else{
			if(liveCellsCount == 3 ){
				 //Resurrect if the dead cell has exactly 3 live neighbors
				evolvedBoard[i][j]=1;
			}
		}
	}





	private void makeBoard(Random rand, int[][] board) {
		for(int i=0; i< board.length;i++){
			for(int j=0; j< board.length;j++){
	
				board[i][j]=rand.nextInt(2) ;
				
			}
		}
	}

	private  void printBoard(int[][] board) {
		for(int i=0; i< board.length;i++){
			for(int j=0; j< board.length;j++){
	
			System.out.print("\t"+board[i][j]);
			
			
			}
			System.out.println();
	    	}
	}
	
	
	
	private static boolean verify(int i, int j){
		return (i >= 0 && j >=0 &&  i <=size-1 && j<=size-1  );

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 GameOfLife game = new  GameOfLife();
		Random rand = new Random();
		int[][] board= new int[size][size];

		
		board[0][0]=0;
		board[0][1]=1;		
		board[0][2]=0;
		board[0][3]=0;
		board[0][4]=0;
		
		board[1][0]=1;
		board[1][1]=0;		
		
		
		board[1][2]=0;
		board[1][3]=1;
		board[1][4]=1;
		
		board[2][0]=1;
		board[2][1]=1;		
		board[2][2]=0;
		board[2][3]=0;
		board[2][4]=1;
		
		
		
		board[3][0]=0;
		board[3][1]=1;		
		board[3][2]=0;
		board[3][3]=0;
		board[3][4]=0;
		
		
	
		board[4][0]=1;
		board[4][1]=0;		
		board[4][2]=0;
		board[4][3]=0;
		board[4][4]=1;
		

		//game.makeBoard(rand, board);
		System.out.println("The Orginal board !");
		game.printBoard(board);

		int[][] evolvedBoard=game.IterateBoard(board);
		
		System.out.println("Evolved board");
		game.printBoard(evolvedBoard);


	}

	

}

