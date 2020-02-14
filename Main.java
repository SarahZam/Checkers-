import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int size = 0;
		
		Scanner scan = new Scanner(System.in);
		
		Engine g = new Engine();
		System.out.println("Welcome to Sarah and Prinaya's Checkers Game! ");
		System.out.println("RULES FOR THE GAME: \r\n" +
				"1. You play the white pieces [w]! The computer plays the black pieces[b]!!\r\n " +
				"2. Input your move in the form of a1-b2 and your captures in the form of a1xc3 [NOTICE THE SECOND STATE IN CAPTURE IN THE INPUT IS THE POSITION THE PLAYER WILL REACH AFTER THE CAPTURE. NOT THE POSITION OF THE PIECE YOU ARE TRYING TO CAPTURE!]\r\n"
				+"PLEASE PUT IN THE INPUTS CAREFULLY! \r\n" +
				"3. If the game doesn't end in 10 turns (5 turns each) for 4x4 board and 50 turns (25 turns each) for 8x8 board then it's a draw");
		
		System.out.println("Which board do you want to play? Type in 1 or 2: \r\n"+
				"1. Small 4x4 Checkers\r\n" + 
				"2. Standard 8x8 Checkers");
		int boardSize = scan.nextInt();
		if(boardSize == 1) {
			size = 4;
		}
		else if (boardSize == 2){
			size = 8;
		} 
		else {
			System.out.println("Invalid input.");
		}
		
		Board b = new Board(size);
		
		System.out.println("Choose your opponent:\r\n" + 
				"1. Human vs Human\r\n" +
				"2. An agent that plays randomly\r\n" + 
				"3. An agent that uses MINIMAX\r\n" + 
				"4. An agent that uses MINIMAX with alpha-beta pruning\r\n" + 
				"5. An agent that uses H-MINIMAX with a fixed depth cutoff");
		
		int opponent = scan.nextInt();
		
		
		//Dont forget to cross this out
		
		int movesNum = 0; 
		int n = 0; 
		
		if(opponent == 1) {
			if(size == 4) {
				movesNum = 5;
			} else {
				movesNum = 25;
			}
			while(true&&n<movesNum) {
				
				b = Board.King(b);
				b.displayBoard();
				System.out.println();
				System.out.println("Available Moves:");
				System.out.println(Engine.actions(b, Board.black));

				System.out.println("First Player: ");
				String tes = scan.next();
				
				b = Board.result(b, tes);
				// System.out.println(GameEngine.actions(b, b.black));
				b.displayBoard();
				System.out.println();
				System.out.println("Available Moves:");
				System.out.println(Engine.actions(b, Board.white));
				System.out.println("Second Player: ");

				String tes2 = scan.next();
				//g.userInput(tes);
				b = Board.result(b, tes2);
				// System.out.println(GameEngine.actions(b, b.black));
			}
		}
		
		//Random
		else if(opponent ==2 ) {
			if(size == 4) {
				movesNum = 5;
			} else {
				movesNum = 25;
			}
			while(true&&n<movesNum) {
				b = Board.King(b);
				b.displayBoard();
				b = Engine.random(b);
				System.out.println("Available moves: ");
				System.out.println(Engine.actions(b, Board.black));
				System.out.println("The agent made a random move.");
				b.displayBoard();
				if(Engine.terminalTest(b)) {
					System.out.println("Game over");
					break;
				}
				
				System.out.println("Available Moves:");
				System.out.println(Engine.actions(b, Board.white));
				System.out.println("Your move: ");
				
				String input = scan.next();
				b = Board.result(b, input);
				
			}
			
		}
		
		
		// Minimax
		else if(opponent == 3) {
			 
			if(size == 4) {
				movesNum = 5;
			} else {
				movesNum = 25;
			}
			
			while(true&&n<movesNum) {
				b = Board.King(b);
				b.displayBoard();
				Board temp = new Board(size);
				 for(int i = 0; i < size; i ++) {
					 for(int j = 0 ; j< size; j++) {
						 Board.board.get(i).set(j, Board.board.get(i).get(j));
					 }
				 }
				 System.out.println("Calculating move for computer....");
				 String comp = Engine.minMax(b);
				 if(comp.equals("")) {
					 comp = Engine.actions(temp, Board.black).get(0);
				 }
				 
				 System.out.println("The computer made the move " + comp);
				 temp = Board.result(temp, comp);
				 temp = Board.King(temp);
				 temp.displayBoard();
				 b = temp; 
				 if(Engine.terminalTest(b)) {
					 System.out.println("Game Over");
					 break;
				 }
				 System.out.println("Available Moves:");
				 System.out.println(Engine.actions(b, Board.white));
				 System.out.println("Your move: ");
				 String input = scan.next();
				b = Board.result(b, input);
				 System.out.println(Engine.actions(b, Board.black));
			}
		}
		
		//AlphaBeta Pruning
		else if(opponent == 4) {
			
			if(size == 4) {
				movesNum = 5;
			} else {
				movesNum = 25;
			}
			while(true && n<movesNum) {
				
			}
			
		}
		
		//H-minimax
		else if(opponent == 5) {
			
		}
	}

}
