import java.util.*;

public class TicTacToe 
{
	private static char playerSymbol = 'X';
	private static char computerSymbol = 'o';
	
	public static void main(String[] args)
	{
		runGame();
	}
	
	private static void runGame()
	{
		Scanner scan = new Scanner(System.in);
		
		char[][] board = {{' ', ' ', ' '},
						  {' ', ' ', ' '},
						  {' ', ' ', ' '}};
		
		printBoard(board);
		
		
		while(true)
		{
			playerMove(scan, board);
			if(isGameFinished(board, playerSymbol))
			{
				break;
			}
			computerMove(board);
			if(isGameFinished(board, computerSymbol))
			{
				break;
			}
		}
		
		scan.close();	
	}
	
	private static boolean isGameFinished(char[][] board, char symbol)
	{
		for(int i = 0; i < board.length; i++)
		{
			if(checkRow(board, i, symbol) || checkColumn(board, i, symbol) || checkDiagonal(board, symbol))		
			{
				if(symbol == playerSymbol)
				{
					System.out.println("Player wins");
				}
				else
					System.out.println("Computer wins");
				
				return true;
			}
		}	
		
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				if(board[i][j] == ' ')
					return false;
			}
		}
		System.out.println("It's a tie!");
		return true;
	}
	
	private static void computerMove(char[][] board)
	{
		for (int i = 1; i <= 9; i++) 
		{
	        if (isMoveValid(board, Integer.toString(i))) 
	        {
	            makeMove(board, Integer.toString(i), computerSymbol);
	            
	            if (isGameFinished(board, computerSymbol)) 
	            {
	                System.out.println("\nComputer move at " + i);
	                printBoard(board);
	                return;
	            }
	            makeMove(board, Integer.toString(i), ' '); // undo move
	        }
	    }

	    // Check if the player can win in the next move and block it
	    for (int i = 1; i <= 9; i++) 
	    {
	        if (isMoveValid(board, Integer.toString(i))) 
	        {
	            makeMove(board, Integer.toString(i), playerSymbol);
	            
	            if (isGameFinished(board, playerSymbol)) 
	            {
	                makeMove(board, Integer.toString(i), computerSymbol); 
	                System.out.println("\nComputer move at " + i);
	                printBoard(board);
	                return;
	            }
	            makeMove(board, Integer.toString(i), ' '); // undo move
	        }
	    }

	    // If neither of the above conditions are met, make a random move
	    Random random = new Random();
	    while (true) {
	        int position = random.nextInt(9) + 1;
	        if (isMoveValid(board, Integer.toString(position))) {
	            System.out.println("\nComputer move at " + position);
	            makeMove(board, Integer.toString(position), 'o');
	            printBoard(board);
	            break;
	        }
	    }
	}

	private static void playerMove(Scanner scan, char[][] board) {
		while(true)
		{
			System.out.println("\nPlace your move: Select between(1-9))");
			String playerPosition = scan.nextLine();
			
			if(isMoveValid(board, playerPosition))
			{
				makeMove(board, playerPosition, playerSymbol);
				printBoard(board);
				break;
			}
			else
				System.out.println("Invalid move.");
				
		}
	}
	
	private static boolean isMoveValid(char[][] board, String position)
	{
		switch(position)
		{
			case "1": 
				return (board[0][0] == ' ');
			case "2": 
				return (board[0][1] == ' ');
			case "3": 
				return (board[0][2] == ' ');
			case "4": 
				return (board[1][0] == ' ');
			case "5": 
				return (board[1][1] == ' ');
			case "6": 
				return (board[1][2] == ' ');
			case "7": 
				return (board[2][0] == ' ');
			case "8": 
				return (board[2][1] == ' ');
			case "9": 
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}

	private static void makeMove(char[][] board, String position, char symbol) {
		switch(position)
		{
			case "1": 
				board[0][0] = symbol;
				break;
			case "2": 
				board[0][1] = symbol;
				break;
			case "3": 
				board[0][2] = symbol;
				break;
			case "4": 
				board[1][0] = symbol;
				break;
			case "5": 
				board[1][1] = symbol;
				break;
			case "6": 
				board[1][2] = symbol;
				break;
			case "7": 
				board[2][0] = symbol;
				break;
			case "8": 
				board[2][1] = symbol;
				break;
			case "9": 
				board[2][2] = symbol;
				break;
			default: 
				System.out.print(":(");
		}
	}
	
	private static boolean checkRow(char[][] board, int row, char symbol) {
	    return board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol;
	}

	private static boolean checkColumn(char[][] board, int col, char symbol) {
	    return board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol;
	}

	private static boolean checkDiagonal(char[][] board, char symbol) {
	    return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
	           (board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol);
	}

	private static void printBoard(char[][] board) {
		System.out.println();
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	}
}
