import java.util.Scanner;

//prinaya coubey
//Sarah zaman

public class Main {
	
		public static void main(String[] args) {
			
			
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Welcome to Sarah and Prinaya's Checkers Game! ");
			System.out.println("RULES FOR THE GAME: \r\n" +
					"1. You play the white pieces [w]! The computer plays the black pieces[b]!!\r\n " +
					"2. Input your move in the form of a1-b2 and your captures in the form of a1xc3 [NOTICE THE SECOND STATE IN CAPTURE IN THE INPUT IS THE POSITION THE PLAYER WILL REACH AFTER THE CAPTURE. NOT THE POSITION OF THE PIECE YOU ARE TRYING TO CAPTURE!]\r\n"
					+"PLEASE PUT IN THE INPUTS CAREFULLY! \r\n"
					+"3. The game will be a draw if it goes on for 10 turns in 4x4 or 50 turns in 8x8 \r\n");
			
			System.out.println("Which board do you want to play? Type in 1 or 2: \r\n"+
					"1. Small 4x4 Checkers\r\n" + 
					"2. Standard 8x8 Checkers");
			Scanner scan = new Scanner(System.in);
	        int boardSize = scan.nextInt();
	        int size = 0;
	        if(boardSize == 1) {
				size = 4;
			}
			else if (boardSize == 2){
				size = 8;
			} 
			else {
				System.out.println("Invalid input.");
			}
	        
	        States b = new States(size);
	        
	        System.out.println("Choose your opponent:\r\n" + 
					"1. Human vs Human\r\n" +
					"2. An agent that plays randomly\r\n" + 
					"3. An agent that uses MINIMAX\r\n" + 
					"4. An agent that uses MINIMAX with alpha-beta pruning\r\n" + 
					"5. An agent that uses H-MINIMAX with a fixed depth cutoff (for 4x4 = 10 and for 8x8 =50) ");
			
			int opponent = scan.nextInt();
			int movesNum = 0; 
			int n = 0; 
			
			if(size == 4) {
				movesNum = 5;
			} else {
				movesNum = 25;
			}
			
			if(opponent == 1) {
				if(size == 4) {
					movesNum = 5;
				} else {
					movesNum = 25;
				}
				while(true&&n<movesNum) {
					
					b = States.king(b);
					b.displayBoard();
					System.out.println();
					System.out.println("Available Moves:");
					System.out.println(Engine.actions(b, States.Pieces.black));

					System.out.println("First Player: ");
					String tes = scan.next();
					
					b = States.result(b, tes);
					// System.out.println(GameEngine.actions(b, b.black));
					b.displayBoard();
					System.out.println();
					System.out.println("Available Moves:");
					System.out.println(Engine.actions(b, States.Pieces.white));
					System.out.println("Second Player: ");

					String tes2 = scan.next();
					//g.userInput(tes);
					b = States.result(b, tes2);
					// System.out.println(GameEngine.actions(b, b.black));
				}
			}
			
			
			
			//Random
			else if(opponent ==2 ) {
				
				while(true&&n<movesNum) {
					b = States.king(b);
					b.displayBoard();
					b = Engine.random(b);
					System.out.println();
					System.out.println("Available moves: ");
					System.out.println(Engine.actions(b, States.Pieces.black));
					System.out.println("The agent made a random move.");
					b.displayBoard();
					System.out.println();
					if(Engine.terminalTest(b)) {
						System.out.println("Game over");
						break;
					}
					System.out.println("Available Moves:");
					System.out.println(Engine.actions(b, States.Pieces.white));
					System.out.println("Your move: ");
					
					String input = scan.next();
					b = States.result(b, input);
					
				}
				
			}
			
			// Minimax
			else if(opponent == 3) {	
				
					while(true&&n<movesNum) {
	                    b = b.king(b);
	                    b.displayBoard();

	                    States copy = new States(size);
	                    for (int i = 0; i < size; i++) {
	                        for (int j = 0; j < size; j++) {
	                            copy.board.get(i).set(j, b.board.get(i).get(j));
	                        }
	                    }
	                    System.out.println();
	                    System.out.println("Calculating move...");
	                    System.out.println("Available moves: ");
						System.out.println(Engine.actions(b, States.Pieces.black));
						
	                    String aiMove = Engine.minMax(b);
	                    if (aiMove.equals("")){
	                        aiMove = Engine.actions(copy, States.Pieces.black).get(0);
	                    }
	                    System.out.println("The Computer made the move " + aiMove);
	                    copy = States.result(copy, aiMove);
	                    copy = States.king(copy);
	                    copy.displayBoard();
	                    b = copy;
	                    if (Engine.terminalTest(b)) {
	                        System.out.println("Game Over!");
	                        break;
	                    }
	                    System.out.println("Available moves: ");
						System.out.println(Engine.actions(b, States.Pieces.white));
						
	                    System.out.println("Your Turn: ");
	                    String move = scan.next();
	                    b = States.result(b, move);
	                    System.out.println(Engine.actions(b, States.Pieces.black)); 
				}
			}
			
			
			//Alphabeta
			if(opponent == 4) {
				
					States board = new States(size);
	                while (true) {
	                    board = board.king(board);
	                    board.displayBoard();

	                    States copy = new States(size);
	                    for (int i = 0; i < size; i++) {
	                        for (int j = 0; j < size; j++) {
	                            copy.board.get(i).set(j, board.board.get(i).get(j));
	                        }
	                    }
	                    System.out.println();
	                    System.out.println("Calculating move...");
	                    String aiMove = Engine.alphabeta(board);
	                    if (aiMove.equals("")){
	                        aiMove = Engine.actions(copy, States.Pieces.black).get(0);
	                    }
	                    System.out.println("Available moves: ");
						System.out.println(Engine.actions(b, States.Pieces.black));
	                    System.out.println("The Computer made the move " + aiMove);
	                    copy = States.result(copy, aiMove);
	                    copy = States.king(copy);
	                    copy.displayBoard();
	                    board = copy;
	                    if (Engine.terminalTest(board)) {
	                        System.out.println("Game Over!");
	                        break;
	                    }
	                    
	                    System.out.println("Available moves: ");
						System.out.println(Engine.actions(b, States.Pieces.white));
	                    System.out.println("Your turn: ");
	                    String move = scan.next();
	                    if (move.equals("")){
	                        move = Engine.actions(copy, States.Pieces.white).get(0);
	                    }
	                    board = States.result(board, move);
	                    System.out.println(Engine.actions(board, States.Pieces.black));
	            
				}
			}
			
			
			
			//HMINIMAX
			if(opponent == 5) {
				if(size==4) {
					System.out.println("depth is set at 10");
	                States board = new States(4);
	                while (true) {
	                    board = board.king(board);
	                    board.displayBoard();

	                    States copy = new States(4);
	                    for (int i = 0; i < 4; i++) {
	                        for (int j = 0; j < 4; j++) {
	                            copy.board.get(i).set(j, board.board.get(i).get(j));
	                        }
	                    }
	                    System.out.println();
	                    System.out.println("Calculating move...");
	                    System.out.println("Available moves: ");
						System.out.println(Engine.actions(b, States.Pieces.black));
						
	                    String aiMove = Engine.hMinMax(board, 10);
	                    if (aiMove.equals("")){
	                        aiMove = Engine.actions(copy, States.Pieces.black).get(0);
	                    }
	                    System.out.println();
	                    System.out.println("The Computer made the move " + aiMove);
	                    copy = States.result(copy, aiMove);
	                    copy = States.king(copy);
	                    copy.displayBoard();
	                    board = copy;
	                    if (Engine.terminalTest(board)) {
	                        System.out.println("Game Over!");
	                        break;
	                    }
	                    System.out.println();
	                    System.out.println("Available moves: ");
						System.out.println(Engine.actions(b, States.Pieces.white));
						
	                    System.out.println("Your Turn: ");
	                    String move = scan.next();
	                    board = States.result(board, move);
	                    System.out.println(Engine.actions(board, States.Pieces.black));
				}
			}
				else if (size == 8) {
					System.out.println("Search depth is 50");
	                States board = new States(8);
	                while (true) {
	                    board = board.king(board);

	                    States copy = new States(8);
	                    for (int i = 0; i < 8; i++) {
	                        for (int j = 0; j < 8; j++) {
	                            copy.board.get(i).set(j, board.board.get(i).get(j));
	                        }
	                    }
	                    System.out.println();
	                    System.out.println("Calculating move...");
	                    System.out.println("Available moves: ");
						System.out.println(Engine.actions(b, States.Pieces.black));
						
	                    String aiMove = Engine.hMinMax(board, 50);
	                    if (aiMove.equals("")){
	                        aiMove = Engine.actions(copy, States.Pieces.black).get(0);
	                    }
	                    System.out.println("The Computer made the move " + aiMove);
	                    copy = States.result(copy, aiMove);
	                    copy = States.king(copy);
	                    copy.displayBoard();
	                    board = copy;
	                    if (Engine.terminalTest(board)) {
	                        System.out.println("Game Over!!");
	                        break;
	                    }
	                    System.out.println("Available moves: ");
						System.out.println(Engine.actions(b, States.Pieces.white));
						
	                    System.out.println("Your Turn: ");
	                    String move = scan.next();
	                    board =States.result(board, move);
	                    board.displayBoard();
	                    System.out.println(Engine.actions(board, States.Pieces.black));
	                }
				}
			}
		}
}