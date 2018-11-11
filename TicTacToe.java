import java.util.Scanner;
import java.util.Random;
public class TicTacToe {
	
      public static void main(String[] args) {
			Random r = new Random( 34246988);
			// Create tic-tac-toe board
			int[][] board = new int[3][3];
			for (int row = 0; row < board.length; row++) {
				for (int col = 0; col < board[row].length; col++) {
					board[row][col] = 0;
				}
			}
			
			// set int var for wins
			int wins = 0;
			// show player1 board
            printArr(board);
            while (wins != 1) {
            	// PLAYER1's TURN ---
            	// check if board is full
            	int empty = 0;
            	for (int row = 0; row < board.length; row++) {
    				for (int col = 0; col < board[row].length; col++) {
    					if (board[row][col] == 0) {
    						empty ++;
    					}
    				}
    			}
            	// break if board full
            	if (empty == 0) {
            		System.out.println("The board is full. Neither player won.");
            		break;
            	}
            	// player1's input
            	Scanner p1 = new Scanner(System.in);
            	System.out.println("Player 1, enter the row and column of the space you want to move to. ");
            	int p1row = p1.nextInt() - 1;
            	int p1col = p1.nextInt() - 1;
            	// check if space is empty
            	while (board[p1row][p1col] == 1) {
            		System.out.println("This space is not empty. Try again.");
            		System.out.println("Player 1, enter the row and column of the space you want to move to. ");
                	p1row = p1.nextInt() - 1;
                	p1col = p1.nextInt() - 1;
            	}
            	while (board[p1row][p1col] == 2) {
            		System.out.println("This space is not empty. Try again.");
            		System.out.println("Player 1, enter the row and column of the space you want to move to. ");
                	p1row = p1.nextInt() - 1;
                	p1col = p1.nextInt() - 1;
            	}
            	// put 1 into chosen empty space
            	board[p1row][p1col] = 1;
            	// show board after player 1's turn
            	printArr(board);
            	// check for wins
            	if (checkRow(board) == 1) {
            		wins = 1;
            		System.out.println("Player 1 wins.");
            		break;
            	}
            	else if (checkCol(board) == 1) {
            		wins = 1;
            		System.out.println("Player 1 wins.");
            		break;
            	}
            	else if (checkDiagonal(board) == 1) {
            		wins = 1;
            		System.out.println("Player 1 wins.");
            		break;
            	}
            	
            	// check if board is full
            	empty = 0;
            	for (int row = 0; row < board.length; row++) {
    				for (int col = 0; col < board[row].length; col++) {
    					if (board[row][col] == 0) {
    						empty ++;
    					}
    				}
    			}
            	// break while loop to end game if board full
            	if (empty == 0) {
            		System.out.println("The board is full. Neither player won.");
            		break;
            	}
            	
            	// PLAYER 2's TURN ---
            	System.out.println("Player 2, enter the row and column of the space you want to move to. ");
            	int p2row = p1.nextInt() - 1;
            	int p2col = p1.nextInt() - 1;
            	while (board[p2row][p2col] == 1) {
            		System.out.println("This space is not empty. Try again.");
            		System.out.println("Player 1, enter the row and column of the space you want to move to. ");
                	p2row = p1.nextInt() - 1;
                	p2col = p1.nextInt() - 1;
            	}
            	while (board[p2row][p2col] == 2) {
            		System.out.println("This space is not empty. Try again.");
            		System.out.println("Player 1, enter the row and column of the space you want to move to. ");
                	p2row = p1.nextInt() - 1;
                	p2col = p1.nextInt() - 1;
            	}
            	// put 2 into empty space
            	board[p2row][p2col] = 2;
            	// show board after player 2's turn
            	printArr(board);
            	// check for wins
            	if (checkRow(board) == 2) {
            		wins = 1;
            		System.out.println("Player 2 wins.");
            		continue;
            	}
            	else if (checkCol(board) == 2) {
            		wins = 1;
            		System.out.println("Player 2 wins.");
            		continue;
            	}
            	else if (checkDiagonal(board) == 2) {
            		wins = 1;
            		System.out.println("Player 2 wins.");
            		continue;
            	}
            }
	      
            // 1000 iterations of the game, within 3 modes. 
	    // After the thousand games in each mode, display the number of times X won, O won and ties
            
            // MODE 1
            // X and O move **randomly as described above. 
	    // If a random square chosen has been played, have the player choose again
            System.out.println("Beginning Mode 1...");
    		// create counter for iterations
    		int counter1 = 0;
    		// wins and ties counters
    		int xwins = 0;
    		int owins = 0;
    		int ties = 0;
    		// create random variable for plays
    		Random r1 = new Random(34246988);
    		// for each game 1 to 1000
             while (counter1 < 1000) {
             	 // create new empty board
                 String[][] board1 = new String[3][3];
     			for (int row = 0; row < board1.length; row++) {
     				for (int col = 0; col < board1[row].length; col++) {
     					board1[row][col] = "0";
     				}
     			}
     			int newgame = 0;
     			while (newgame != 1) {
    	            	// X's TURN
    	            	printsArr(board1);
    	            	// check if board is full
    	            	int empty = 0;
    	            	for (int row = 0; row < board1.length; row++) {
    	    				for (int col = 0; col < board1[row].length; col++) {
    	    					if (board1[row][col] == "0") {
    	    						empty ++;
    	    					}
    	    				}
    	    			}
    	            	// break while loop to end game if board full
    	            	if (empty == 0) {
    	            		System.out.println("The board is full. Neither player won.");
    	            		counter1 ++;
    	            		newgame = 1;
    	            		ties ++;
    	            		break; 
    	            	}
    	            	// player1's move
    	            	int p1row = r1.nextInt(3);
    	            	int p1col = r1.nextInt(3);
    	            	// check if space is empty
    	            	while (board1[p1row][p1col] == "X") {
    	            		p1row = r1.nextInt(3);
    		            	p1col = r1.nextInt(3);
    	            	}
    	            	while (board1[p1row][p1col] == "O") {
    	            		p1row = r1.nextInt(3);
    		            	p1col = r1.nextInt(3);
    	            	}
    	            	System.out.println("X's move is row " + (p1row + 1) + " and column " + (p1col + 1) + ".");
    	            	// put x into space
    	            	board1[p1row][p1col] = "X";
    	            	// show board after player 1's turn
    	            	printsArr(board1);
    	            	// check for wins
    	            	if (checksRow(board1) == "X") {
    	            		counter1 ++;
    	            		newgame = 1;
    	            		xwins ++;
    	            		System.out.println("X wins.");
    	            		break;
    	            	}
    	            	else if (checksCol(board1) == "X") {
    	            		counter1 ++;
    	            		newgame = 1;
    	            		xwins ++;
    	            		System.out.println("X wins.");
    	            		break;
    	            	}
    	            	else if (checksDiagonal(board1) == "X") {
    	            		counter1 ++;
    	            		newgame = 1;
    	            		xwins ++;
    	            		System.out.println("X wins.");
    	            		break;
    	            	}
             	
    	            	// check if board is full
    	            	empty = 0;
    	            	for (int row = 0; row < board1.length; row++) {
    	    				for (int col = 0; col < board1[row].length; col++) {
    	    					if (board1[row][col] == "0") {
    	    						empty ++;
    	    					}
    	    				}
    	    			}
    		         	// check if board is full
    		         	if (empty == 0) {
    		         		System.out.println("The board is full. Neither player won.");
    		         		counter1 ++;
    		         		newgame = 1;
    		         		ties ++;
    		         		break;
    		         	}
             	
    		         	// PLAYER 2's TURN
    		         	// player2's move
    		         	int p2row = r1.nextInt(3);
    		         	int p2col = r1.nextInt(3);
    		     
    		         	// check if space is empty
    		         	while (board1[p2row][p2col] == "X") {
    		         		p2row = r1.nextInt(3);
    			            p2col = r1.nextInt(3);
    		         	}
    		         	while (board1[p2row][p2col] == "O") {
    		         		p2row = r1.nextInt(3);
    			            p2col = r1.nextInt(3);
    		         	}
    		         	
    		         	System.out.println("O's move is row " + (p2row+1) + " and column " + (p2col+1));
    		         	// put o into space
    		         	board1[p2row][p2col] = "O";
    		         	// check for wins
    		         	if (checksRow(board1) == "O") {
    		         		printsArr(board1);
    		         		counter1 ++;
    		         		newgame = 1;
    		         		owins ++;
    		         		System.out.println("O wins.");
    		         		continue;
    		         	}
    		         	else if (checksCol(board1) == "O") {
    		         		printsArr(board1);
    		         		counter1 ++;
    		         		newgame = 1;
    		         		owins ++;
    		         		System.out.println("O wins.");
    		         		continue;
    		         	}
    		         	else if (checksDiagonal(board1) == "O") {
    		         		printsArr(board1);
    		         		counter1 ++;
    		         		newgame = 1;
    		         		owins ++;
    		         		System.out.println("O wins.");
    		         		continue;
    		         	}
             }
            }
            // print mode 1 totals
            System.out.println("Mode 1 Totals - ");
            System.out.println("X wins:" + xwins);
            System.out.println("O wins:" + owins);
            System.out.println("Ties:" + ties);
           
            // MODE 2
            // X always moves to the middle square in the first move.
            
            // MODE 3
            // O always moves to the middle square in the first move, if X has not moved there.

            
            // check match in ROW
			//System.out.println(checkRow(board));
			// check match in COLUMN 
			//System.out.println(checkCol(board));
			// check match in DIAGONAL
			//System.out.println(checkDiagonal(board));
		}
      	
       // print int array
		public static void printArr(int[][] arr) {
			for (int row = 0; row < arr.length; row++) {
				for (int col = 0; col < arr[row].length; col++) {
					System.out.print(arr[row][col] + " ");
				}
				System.out.println(" ");
			}
		}
		
		// print string array
		public static void printsArr(String[][] arr) {
			for (int row = 0; row < arr.length; row++) {
				for (int col = 0; col < arr[row].length; col++) {
					System.out.print(arr[row][col] + " ");
					if ((col+1)%3 == 0) {
						System.out.println("");
					}
				}
			}
		}

		public static int checkRow(int[][] arr) {
			for (int player = 1; player <= 2; player++) {
				for (int row = 0; row < arr.length; row++) {
					int total = 0;
					for (int col = 0; col < arr[row].length; col++) {
						if (arr[row][col] == player) {
							total++;
						}
					}
					if (total == 3) {
						return player;
					}
				}
			}
			return 0;
		}
		
		// check row for XO board
		public static String checksRow(String[][] board1) {
			String playermove = null;
			for (int player = 1; player <= 2; player++) {
				for (int row = 0; row < board1.length; row++) {
					int total = 0;
					for (int col = 0; col < board1[row].length; col++) {
						if (player == 1) {
							playermove = "X";
							if (board1[row][col] == playermove) {
								total++;
							}
						}
						else if (player == 2) {
							playermove = "O";
							if (board1[row][col] == playermove) {
								total++;
							}
						}
					}
					if (total == 3) {
						return playermove;
					}
				}
			}
			return "0";
		}
		
		public static int checkCol(int[][] arr) {
			for (int player = 1; player <= 2; player++) {
				for (int row = 0; row < arr.length; row++) {
					int total = 0;
					for (int col = 0; col < arr[row].length; col++) {
						if (arr[col][row] == player) {
							total++;
						}
					}
					if (total == 3) {
						return player;
					}
				}
			}
			return 0;
		}
		// check col for XO board
		public static String checksCol(String[][] arr) {
			String playermove = null;
			for (int player = 1; player <= 2; player++) {
				for (int row = 0; row < arr.length; row++) {
					int total = 0;
					for (int col = 0; col < arr[row].length; col++) {
						if (player == 1) {
							playermove = "X";
							if (arr[col][row] == playermove) {
								total++;
							}
						}
						else if (player == 2) {
							playermove = "O";
							if (arr[col][row] == playermove) {
								total++;
							}
						}
					}
					if (total == 3) {
						return playermove;
					}
				}
			}
			return "0";
		}
		
		public static int checkDiagonal(int[][] arr) {	 
			for (int player = 1; player <= 2; player++) {
			int total = 0;
				for (int i=0; i < arr.length; i++) {
					if (arr[i][i]== player) {
						total++;
					}
					if (total == 3) {
						return player;
					}
				}
		      }
			// check the other diagonal
			for (int player = 1; player <= 2; player++) {
				int total = 0;
					for (int i=0; i < arr.length; i++) {
						if (arr[i][(arr.length-1)-i]== player) {
							total++;
						}
						if (total == 3) {
							return player;
						}
					}
			      }
			return 0;
	       	}
		
		// check diagonal for XO board
		public static String checksDiagonal(String[][] arr) {	
			String playermove = null;
			for (int player = 1; player <= 2; player++) {
			int total = 0;
				for (int i=0; i < arr.length; i++) {
					if (player == 1) {
						playermove = "X";
						if (arr[i][i]== playermove) {
							total++;
						}
					}
					if (player == 2) {
						playermove = "O";
						if (arr[i][i]== playermove) {
							total++;
						}
					}
					if (total == 3) {
						return playermove;
					}
				}
		      }
			// check the other diagonal
			for (int player = 1; player <= 2; player++) {
				int total = 0;
					for (int i=0; i < arr.length; i++) {
						if (player == 1) {
							playermove = "X";
							if (arr[i][(arr.length-1)-i]== playermove) {
								total++;
							}
						}
						if (player == 2) {
							playermove = "O";
							if (arr[i][(arr.length-1)-i]== playermove) {
								total++;
							}
						}
						if (total == 3) {
							return playermove;
						}
					}
			      }
			return "0";
	       	}
}
