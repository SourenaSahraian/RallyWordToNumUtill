package Rally.Org.Candidate.gameOfLife;
import java.util.Random;


public class GameOfLife {
	
public static final  int size=5;
	
	private  void IterateBoard(int[][] board) {

		for(int i=0; i< board.length;i++){
			for(int j=0; j< board.length;j++){
				
				int currentCell= board[i][j];
				int liveCellsCount=0;
			
				//find neighbors for the current cell
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
					// modify currnet element according to set of rules
					evolve(board, i, j, currentCell, liveCellsCount);

			}

		}
	}




/**
 * Decsion making is made here.
 * @param board
 * @param i
 * @param j
 * @param currentCell
 * @param liveCellsCount
 */
	private void evolve(int[][] board, int i, int j, int currentCell,
			int liveCellsCount) {
		//Decision is made here.
		//if alive ; 
		if(currentCell ==1){
			//kill due to over population - or lack of live neighbors
			if(liveCellsCount >  3   || ( liveCellsCount< 2) )   {
				board[i][j]=0; // kill
			}	
		}
		//if dead
		
		else{
			if(liveCellsCount == 3 ){
				 //Resurrect if the dead cell has exactly 3 live neighbors
				board[i][j]=1;
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
		
		GameOfLife game = new GameOfLife();
		Random rand = new Random();
		int[][] board= new int[size][size];
	
		game.makeBoard(rand, board);
		System.out.println("The Orginal board !");
		game.printBoard(board);

		game.IterateBoard(board);
		System.out.println("Evolved board");
		game.printBoard(board);

	}


	

}
