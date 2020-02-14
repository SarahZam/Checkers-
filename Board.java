import java.util.ArrayList;




public class Board {

	static Pieces empty = new Pieces("[ ]");
	static Pieces white = new Pieces("[w]");
	static Pieces black = new Pieces("[b]");
	static Pieces whiteKing = new Pieces("[W]");
	static Pieces blackKing = new Pieces("[B]");
	
	static Engine g  = new Engine();
	
	static ArrayList<ArrayList<Pieces>> board = new ArrayList<ArrayList<Pieces>>();
	
	public Board(int size) {
		
		for(int i = 0; i < size; i++) {
			ArrayList<Pieces> temp = new ArrayList<>();
			for(int j = 0; j < size; j++) {
				temp.add(empty);
			}
			board.add(temp);
		}
		
		//initial board
		if(size == 4) {
			for(int i = 1; i < size; i+=2) {
				board.get(0).set(i, black);
				board.get(size-1).set(i-1, white);
			}
		}
		
		else if(size == 8) {
			for(int i = 1; i < size; i+=2) {
				board.get(0).set(i, black);
				board.get(1).set(i-1, black);
				board.get(2).set(i, black);
				board.get(5).set(i-1,white);
				board.get(6).set(i, white);
				board.get(7).set(i-1, white);
				
			}
		}
	}
	
	//displays board
	public void displayBoard() {
		int n = board.size();
		System.out.print("  ");
		for(int i = 1; i <= n; i++) {
			System.out.print(i + "  ");
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
			}
			System.out.println();
			System.out.print((char)('A'+i));
			for(int j = 0; j <n ; j++) {
				if(board.get(i).get(j) == empty) {
					System.out.print(empty.name);
				}
				else if(board.get(i).get(j) == black) {
					System.out.print(black.name);
				}
				else if(board.get(i).get(j) == white) {
					System.out.print(white.name);
				}
				else if(board.get(i).get(j) == blackKing) {
					System.out.print(blackKing.name);
				}
				else if(board.get(i).get(j) == whiteKing) {
					System.out.print(whiteKing.name);
				}
			}
		}
		
	}
	
public static Board result(Board b, String input) {
		
		if(input == null) {
			return b;
		}
		
		
		int [] move = Engine.userInput(input);
		Pieces current = Board.board.get(move[0]).get(move[1]);
		
		

		
			//disapears old positions
			Board.board.get(move[0]).set(move[1], Board.empty);
			//appears in new position - like magic u knw
			Board.board.get(move[3]).set(move[4], current);
		
		
			
			Board.board.get((move[0]+move[3])/2).set((move[1]+move[4])/2, Board.empty);
			return b;
			
		
		
	}
	

	//checks for King
	public static Board King(Board b) {
		for(int i = 1; i < Board.board.get(0).size(); i+=2) {
			if(Board.board.get(0).get(i) == white) {
				Board.board.get(0).set(i, whiteKing);
			}
			if(Board.board.get(Board.board.size()-1).get(i) == black) {
				Board.board.get(Board.board.size()-1).set(i, blackKing);
			}
		}
		return b;
	}
	
	/*
	   public static boolean LegalMove(String move,Board chessboard) {
	        int[] cor =GameEngine.userInput(move);
	        
	        if (cor[3] > chessboard.board.size() - 1 || cor[2] > chessboard.board.size() - 1 || cor[3] < 0 || cor[2] < 0){
	            return false;
	        }
	        Pieces type=chessboard.board.get(cor[1]).get(cor[0]);
	        
	        
	        if(type==white) {
	            if(cor[3]!=cor[1]-1 || (cor[2]!=cor[0]+1 && cor[2]!=cor[0]-1)) {
	                return  false;
	            }
	        }
	        
	        
	        //done
	        if(type==black) {
	            if(cor[3]!=cor[1]+1 || (cor[2]!=cor[0]+1 && cor[2]!=cor[0]-1)) {
	                return  false;
	            }
	        }
	        
	        //
	        if(type==whiteKing||type==blackKing) {
	            if((cor[3]!=cor[1]-1 && cor[3]!=cor[1]+1) || (cor[2]!=cor[0]+1 && cor[2]!=cor[0]-1)) {
	                return false;
	            }
	        }
	        
	        //done
	        if(chessboard.board.get(cor[3]).get(cor[2])!=empty) {
	            return false;
	        }
	        
	        return true;
	    }
	    //x,y,x1,y1

	    public static boolean capture(String capture, Board chessboard){


	        int cor[]=GameEngine.userInput(capture);
	        
	        //
	        if (cor[3] > chessboard.board.size() - 1 || cor[2] > chessboard.board.size() - 1 || cor[3] < 0 || cor[2] < 0){
	            return false;
	        }
	        
	        
	       Pieces type=chessboard.board.get(cor[1]).get(cor[0]);
	        if (type==white){
	            if(cor[3]!=cor[1]-2 || (cor[2]!=cor[0]-2 && cor[2]!=cor[0]+2)){
	                return false;
	            }else if(chessboard.board.get((cor[1]+cor[3])/2).get((cor[0]+cor[2])/2) != black && chessboard.board.get((cor[1]+cor[3])/2).get((cor[0]+cor[2])/2) != blackKing){
	                return  false;
	            }else if(chessboard.board.get(cor[3]).get(cor[2])!=empty){
	                return false;
	            }
	        }
	        
	        
	        if (type==black){

	            if(cor[3]!=cor[1]+2 || (cor[2]!=cor[0]-2 && cor[2]!=cor[0]+2)){
	                return false;
	                
	            }else if(chessboard.board.get((cor[1]+cor[3])/2).get((cor[0]+cor[2])/2) != white && chessboard.board.get((cor[1]+cor[3])/2).get((cor[0]+cor[2])/2) != whiteKing){
	                return false;
	            }else if(chessboard.board.get(cor[3]).get(cor[2])!=empty){
	                return false;
	            }
	        }
	        if (type==whiteKing) {
	            if ((cor[3] != cor[1] - 2 && cor[3] != cor[1]+2 ) || (cor[2] != cor[0] - 2 && cor[2] != cor[0] + 2)) {
	                return false;
	            } else if (chessboard.board.get((cor[1]+cor[3])/2).get((cor[0]+cor[2])/2) != black && chessboard.board.get((cor[1]+cor[3])/2).get((cor[0]+cor[2])/2) != blackKing) {
	                return false;
	            } else if (chessboard.board.get(cor[3]).get(cor[2]) != empty) {
	                return false;
	            }
	        }



	        if (type == blackKing) {
	            if ((cor[3] != cor[1] - 2 && cor[3] != cor[1]+2 ) || (cor[2] != cor[0] - 2 && cor[2] != cor[0] + 2)){
	                return false;
	            } else if (chessboard.board.get((cor[1]+cor[3])/2).get((cor[0]+cor[2])/2) != white && chessboard.board.get((cor[1]+cor[3])/2).get((cor[0]+cor[2])/2) != whiteKing) {
	                return false;
	            } else if (chessboard.board.get(cor[3]).get(cor[2]) != empty) {
	                return false;
	            }
	        }
	        return true;
	    }
	    */
	
	public static boolean LegalMove(String input, Board b) {
		
		int [] move = Engine.userInput(input);
		
		
		//Checks if the move is out of bounds of the board
		if((move[3]>Board.board.size()-1) || (move[3]<0) 
				|| (move[4]>Board.board.size()-1) ||(move[4]<0)){
					//System.out.println("Out of bounds");
					return false;
				}
		
		//moves black piece
		if(Board.board.get(move[0]).get(move[1])==black) {
			if((move[3]!=move[0]+1) 
				|| ((move[4]!=move[1]+1) && (move[4]!=move[1]-1))) {
				return false;
			}
		}
		
		//moves white piece
		if(Board.board.get(move[0]).get(move[1])==white) {
			if((move[3]!=move[0]-1) 
				|| ((move[4]!=move[1]+1)
				&& (move[4]!=move[1]-1))) {
					return false;
				}
		}
		
		//moves kings
		
		if(Board.board.get(move[0]).get(move[1]) == blackKing || Board.board.get(move[0]).get(move[1]) == whiteKing) {
			if(((move[3]!=move[0]-1) && (move[3]!=move[0]+1)) 
					|| ((move[4]!=move[1]+1)
					&& (move[4]!=move[1]-1))) {
						return false;
					}
			
		}	
		
		if(Board.board.get(move[3]).get(move[4]) != Board.empty) {
			return false;
		}
		
		return true;
	}
	
	public static boolean capture(String input, Board b) {
		int[] move = Engine.userInput(input);
		
		//int[] move = {r1,c1,m,r2,c2};
		
		//Checks if the move is out of bounds of the board
		if(move[3]>Board.board.size()-1 || (move[3]<0) 
			|| (move[4]>Board.board.size()-1) ||(move[4]<0)){
			return false;
		}
		
		//capture for black
		if(Board.board.get(move[0]).get(move[1]) == black) {
			
			//checks if the new move is legit
			if((move[3]!=move[0]+2) || ((move[4]!=move[1]+2) && (move[4]!=move[1]-2))) {
				return false;
			}
			
			//checks if the new move lands in an empty space
			else if(Board.board.get(move[3]).get(move[4]) != empty) {
				return false;
			}
			
			//Checks if the next tile has opposite piece
			else if(Board.board.get((move[0] + move[3])/2).get((move[1]+move[4])/2) != Board.white ||  Board.board.get((move[0] + move[3])/2).get((move[1]+move[4])/2) != Board.whiteKing) {
				return false;
			}
			
			
		}
		
		//capture for white
		if(Board.board.get(move[0]).get(move[1]) == white) {
					
			//checks if the new move is legit
			if((move[3]!=move[0]-2) || ((move[4]!=move[1]+2) && (move[4]!=move[1]-2))) {
				return false;
			}
					
			//checks if the new move lands in an empty space
			else if(Board.board.get(move[3]).get(move[4]) != empty) {
				return false;
			}
					
			//Checks if the next tile has opposite piece
			else if(Board.board.get((move[0] + move[3])/2).get((move[1]+move[4])/2) != Board.black ||  Board.board.get((move[0] + move[3])/2).get((move[1]+move[4])/2) != Board.blackKing) {
				return false;
			}		
		}
		
		//white king
		if(Board.board.get(move[0]).get(move[1]) == whiteKing) {
			
			//checks if the new move is legit
			if(((move[3]!=move[0]-2) && ((move[3]!=move[0]+2))) || ((move[4]!=move[1]+2) && (move[4]!=move[1]-2))) {
				return false;
			}
					
			//checks if the new move lands in an empty space
			else if(Board.board.get(move[3]).get(move[4]) != empty) {
				return false;
			}
					
			//Checks if the next tile has opposite piece
			else if(Board.board.get((move[0]+move[3])/2).get((move[1]+move[4])/2)!=Board.black && Board.board.get((move[0]+move[3])/2).get((move[1]+move[4])/2)!=Board.blackKing) {
				return false;
			}		
		}
		
		//black king
		if(Board.board.get(move[0]).get(move[1]) == blackKing) {
			
			//checks if the new move is legit
			if(((move[3]!=move[0]-2) && ((move[3]!=move[0]+2))) || ((move[4]!=move[1]+2) && (move[4]!=move[1]-2))) {
				return false;
			}
					
			//checks if the new move lands in an empty space
			else if(Board.board.get(move[3]).get(move[4]) != empty) {
				return false;
			}
					
			//Checks if the next tile has opposite piece
			else if(Board.board.get((move[0]+move[3])/2).get((move[1]+move[4])/2)!=Board.white && Board.board.get((move[0]+move[3])/2).get((move[1]+move[4])/2)!=Board.whiteKing) {
				return false;
			}		
		}
		
		return true;
	}
	
	
}

