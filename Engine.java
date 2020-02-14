import java.util.ArrayList;
import java.util.Random;

public class Engine {
	
	
	//CONCEPT: so we take in the string of the user input and put it into an array of characters which are then converted into an array of integers which are then used to calculate moves and what not
	public static int[] userInput(String input) {
		
		char[] ch = input.toCharArray();
		
		int r1 =0;
		switch(ch[0]) {
		case 'a':
			r1 = 0;
			break;
		case 'b' :
			r1 = 1;
			break;
		case 'c':
			r1 = 2;
			break;
		case 'd' :
			r1 = 3;
			break;
		case 'e':
			r1 = 4;
			break;
		case 'f' :
			r1 = 5;
			break;
		case 'g':
			r1 = 6;
			break;
		case 'h' :
			r1 = 7;
			break;
		}
		
		int c1 = Character.getNumericValue(ch[1])-1;
		
		switch(ch[1]) {
		case '1':
			c1 = 0;
			break;
		case '2' :
			c1 = 1;
			break;
		case '3':
			c1 = 2;
			break;
		case '4' :
			c1 = 3;
			break;
		case '5':
			c1 = 4;
			break;
		case '6' :
			c1 = 5;
			break;
		case '7':
			c1 = 6;
			break;
		case '8' :
			c1 = 7;
			break;
		}
		
		
		int r2=0; 
		switch(ch[3]) {
		case 'a':
			r2 = 0;
			break;
		case 'b' :
			r2 = 1;
			break;
		case 'c':
			r2 = 2;
			break;
		case 'd' :
			r2 = 3;
			break;
		case 'e':
			r2 = 4;
			break;
		case 'f' :
			r2 = 5;
			break;
		case 'g':
			r2 = 6;
			break;
		case 'h' :
			r2 = 7;
			break;
		}
		
		
		int c2 = 0;
		
		switch(ch[4]) {
		case '1':
			c2 = 0;
			break;
		case '2' :
			c2 = 1;
			break;
		case '3':
			c2 = 2;
			break;
		case '4' :
			c2 = 3;
			break;
		case '5':
			c2 = 4;
			break;
		case '6' :
			c2 = 5;
			break;
		case '7':
			c2 = 6;
			break;
		case '8' :
			c2 = 7;
			break;
		}
		
		int m = 0;
		switch(ch[2]) {
		case '-':
			m = 1;
			break;
		case 'x':
			m = 2;
			break;
		}
		
		int[] move = {r1,c1,m,r2,c2};
		//int [] move = {c1,r1,c2,r2,m};

		return move;
		
	}
	
	  public static String getCharForNumber(int i) {
	        return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	    }

	   public static ArrayList<String> actions(Board board, Pieces turn){
	        ArrayList<String> captures = new ArrayList<>();
	        ArrayList<String> moves = new ArrayList<>();
	        
	        if(turn == board.black || turn == board.blackKing) {
	                for (int i = 0; i < board.board.size() -1; i++) {
	                    for (int j = 0; j < board.board.size()-1 ; j++) {
	                        if (board.board.get(i).get(j) == board.black ){
	                            String actionOne = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i+2) + (j);
	                            String actionTwo = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i+2) + (j+2);
	                            String actionThree = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i+3) + (j-1);
	                            String actionFour = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i+3) + (j+3);
	                            if (Board.LegalMove(actionOne,board)){
	                                moves.add(actionOne);
	                            }
	                            if (Board.LegalMove(actionTwo,board)){
	                                moves.add(actionTwo);
	                            }
	                            if (Board.capture(actionThree,board)){
	                                captures.add(actionThree);
	                            }
	                            if (Board.capture(actionFour,board)){
	                                captures.add(actionFour);
	                            }
	                        }
	                    }
	                }

	                for (int i = 0; i < board.board.size() ; i++) {
	                    for (int j = 0; j < board.board.size() ; j++) {
	                        if (board.board.get(i).get(j) == Board.blackKing){
	                            String actionOne = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i+2) + (j);
	                            String actionTwo = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i+2) + (j+2);
	                            String actionThree = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i+3) + (j-1);
	                            String actionFour = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i+3) + (j+3);
	                            String actionFive = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i) + (j);
	                            String actionSix = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i) + (j+2);
	                            String actionSeven = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i-1) + (j+3);
	                            String actionEight = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i-1) + (j-1);
	                            if (Board.LegalMove(actionOne,board)){
	                                moves.add(actionOne);
	                            }
	                            if (Board.LegalMove(actionTwo,board)){
	                                moves.add(actionTwo);
	                            }
	                            if (Board.capture(actionThree,board)){
	                                captures.add(actionThree);
	                            }
	                            if (Board.capture(actionFour,board)){
	                                captures.add(actionFour);
	                            }
	                            if (Board.LegalMove(actionFive,board)){
	                                moves.add(actionFive);
	                            }
	                            if (Board.LegalMove(actionSix,board)){
	                                moves.add(actionSix);
	                            }
	                            if (Board.capture(actionSeven,board)){
	                                captures.add(actionSeven);
	                            }
	                            if (Board.capture(actionEight,board)){
	                                captures.add(actionEight);
	                            }
	                        }
	                    }
	                }
	                if (captures.size() != 0){
	                    return captures;
	                }else if (moves.size() != 0){
	                    return moves;
	                }else return captures;}
	        if(turn == Board.white || turn == board.whiteKing) {
	                for (int i = 0; i < board.board.size() ; i++) {
	                    for (int j = 0; j < board.board.size() ; j++) {
	                        if (board.board.get(i).get(j) == Board.white){
	                            String actionOne = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i) + (j);
	                            String actionTwo = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i) + (j+2);
	                            String actionThree = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i+1) + (j-1);
	                            String actionFour = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i+1) + (j+3);
	                            if (Board.LegalMove(actionOne,board)){
	                                moves.add(actionOne);
	                            }
	                            if (Board.LegalMove(actionTwo,board)){
	                                moves.add(actionTwo);
	                            }
	                            if (Board.capture(actionThree,board)){
	                                captures.add(actionThree);
	                            }
	                            if (Board.capture(actionFour,board)){
	                                captures.add(actionFour);
	                            }
	                        }
	                    }
	                }

	                for (int i = 0; i < board.board.size() ; i++) {
	                    for (int j = 0; j < board.board.size() ; j++) {
	                        if (board.board.get(i).get(j) == Board.whiteKing){
	                            String actionOne = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i+2) + (j);
	                            String actionTwo = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i+2) + (j+2);
	                            String actionThree = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i+3) + (j-1);
	                            String actionFour = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i+3) + (j+3);
	                            String actionFive = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i) + (j);
	                            String actionSix = getCharForNumber(i+1) + (j+1) + "-" + getCharForNumber(i) + (j+2);
	                            String actionSeven = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i-1) + (j+3);
	                            String actionEight = getCharForNumber(i+1) + (j+1) + "x" + getCharForNumber(i-1) + (j-1);
	                            if (Board.LegalMove(actionOne,board)){
	                                moves.add(actionOne);
	                            }
	                            if (Board.LegalMove(actionTwo,board)){
	                                moves.add(actionTwo);
	                            }
	                            if (Board.capture(actionThree,board)){
	                                captures.add(actionThree);
	                            }
	                            if (Board.capture(actionFour,board)){
	                                captures.add(actionFour);
	                            }
	                            if (Board.LegalMove(actionFive,board)){
	                                moves.add(actionFive);
	                            }
	                            if (Board.LegalMove(actionSix,board)){
	                                moves.add(actionSix);
	                            }
	                            if (Board.capture(actionSeven,board)){
	                                captures.add(actionSeven);
	                            }
	                            if (Board.capture(actionEight,board)){
	                                captures.add(actionEight);
	                            }
	                        }
	                    }
	                }
	                if (captures.size() != 0){
	                    return captures;
	                }else if (moves.size() != 0){
	                    return moves;
	                }else return captures;
	        }
	        return null;
	    }

	/*
 public static ArrayList<String> actions(Board b, Pieces player){
	 
	 ArrayList<String> moves = new ArrayList<>();
	 ArrayList<String> captures = new ArrayList<>();
	 
	 if(player == Board.black ) {
		 for(int i = 0 ; i < Board.board.size(); i++) {
			 for(int j = 0 ; j < Board.board.size(); j++) {
				 if(Board.board.get(i).get(j)== Board.black) {
					 String a1 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j+2);
					 String a2 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j);
					 String a3 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j+3);
					 String a4 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j-1);
					 if(Board.LegalMove(a1, b)) {
						 moves.add(a1);
					 }
					 if(Board.LegalMove(a2, b)) {
						 moves.add(a2);
					 }
					 if(Board.capture(a3,b)) {
						 captures.add(a3);
					 }
					 if(Board.capture(a4, b)) {
						 captures.add(a4);
					 }
				 }
			 }
		 }
		 
		 for(int i = 0; i < Board.board.size(); i++) {
			 for(int j = 0; j < Board.board.size(); j++) {
				 if(Board.board.get(i).get(j) == Board.blackKing) {
					 String a1 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j+2);
					 String a2 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j);
					 String a3 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j+3);
					 String a4 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j-1);
					 String a5 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j);
					 String a6 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j+2);
					 String a7 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j+3);
					 String a8 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j-1);
					 if(Board.LegalMove(a1, b)) {
						 moves.add(a1);
					 }
					 if(Board.LegalMove(a2, b)) {
						 moves.add(a2);
					 }
					 if(Board.capture(a3,b)) {
						 captures.add(a3);
					 }
					 if(Board.capture(a4, b)) {
						 captures.add(a4);
					 }if(Board.LegalMove(a5, b)) {
						 moves.add(a5);
					 }
					 if(Board.LegalMove(a6, b)) {
						 moves.add(a6);
					 }
					 if(Board.capture(a7,b)) {
						 captures.add(a7);
					 }
					 if(Board.capture(a8, b)) {
						 captures.add(a8);
					 }
				 }
			 }
		 }
		 
		 if(captures.size() != 0) {
			 return captures;
		 }
		 else if(moves.size() !=  0) {
			 return moves;
		 }
		 else return captures;
	 }
	 
	 
	 
	 
	 else if(player == Board.white ) {
		 for(int i = 0 ; i < Board.board.size(); i++) {
			 for(int j = 0 ; j < Board.board.size(); j++) {
				 if(Board.board.get(i).get(j)== Board.white) {
					 String a1 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j);
					 String a2 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j+2);
					 String a3 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j+3);
					 String a4 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j-1);
					 if(Board.LegalMove(a1, b)) {
						 moves.add(a1);
					 }
					 if(Board.LegalMove(a2, b)) {
						 moves.add(a2);
					 }
					 if(Board.capture(a3,b)) {
						 captures.add(a3);
					 }
					 if(Board.capture(a4, b)) {
						 captures.add(a4);
					 }
				 }
			 }
		 }
		 
		 for(int i = 0; i < Board.board.size(); i++) {
			 for(int j = 0; j < Board.board.size(); j++) {
				 if(Board.board.get(i).get(j) == Board.whiteKing) {
					 String a1 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j+2);
					 String a2 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j);
					 String a3 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j+3);
					 String a4 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j-1);
					 String a5 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j);
					 String a6 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j+2);
					 String a7 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j+3);
					 String a8 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j-1);
					 if(Board.LegalMove(a1, b)) {
						 moves.add(a1);
					 }
					 if(Board.LegalMove(a2, b)) {
						 moves.add(a2);
					 }
					 if(Board.capture(a3,b)) {
						 captures.add(a3);
					 }
					 if(Board.capture(a4, b)) {
						 captures.add(a4);
					 }if(Board.LegalMove(a5, b)) {
						 moves.add(a5);
					 }
					 if(Board.LegalMove(a6, b)) {
						 moves.add(a6);
					 }
					 if(Board.capture(a7,b)) {
						 captures.add(a7);
					 }
					 if(Board.capture(a8, b)) {
						 captures.add(a8);
					 }
				 }
			 }
		 }
		 
		 if(captures.size() != 0) {
			 return captures;
		 }
		 else if(moves.size() !=  0) {
			 return moves;
		 }
		 else return captures;
	 }
	 
	 
	 return null;
	 
 }
	 
*/

	public static boolean terminalTest(Board b) {
		
		int white =0 ;
		int black = 0; 
		
		for(ArrayList<Pieces> row : Board.board) {
			for(Pieces piece : row) {
				if(piece == Board.white || piece == Board.whiteKing) {
					white++;
				}
				if(piece == Board.black || piece == Board.blackKing) {
					black++;
				}
			}
		}
		if(white == 0 || black == 0) {
			return true;
		}
		
		else if(white == 1 && black ==1) {
			return true;
		}
		
		else if(actions(b,Board.black).size()==0 || actions(b,Board.white).size() == 0) {
			return true;
		}
		return false;
	}
	
	public static int utilityTest(ArrayList<ArrayList<Pieces>> board) {
		int white = 0;
		int black = 0;
		
		for(ArrayList<Pieces> row : board) {
			for(Pieces piece : row) {
				if(piece == Board.white || piece == Board.whiteKing) {
					white++;
				}
				if(piece == Board.black || piece == Board.blackKing) {
					black++;
				}
			}
		}
		if(white>black) {
			return 0;
		}
		if(white == black) {
			return 1;
		}
		else {
			return 2;
		}
	}
	
	public static Board random(Board board) {
		ArrayList<String> actions = actions(board, Board.black);
		Random ran = new Random();
		int x = ran.nextInt(actions.size());
		return Board.King(Board.result(board, actions.get(x)));
	}
	
	public static int maxValue(Board b){
        b = Board.King(b);
        int tempValue = -1;
        if (terminalTest(b)){
            return utilityTest(Board.board);
        }
        else for (String action:actions(b, Board.black)) {
            tempValue = java.lang.Math.max(tempValue,minValue(Board.result(b,action)));
        }
        return tempValue;
    }

    public static int minValue(Board b){
        b = Board.King(b);
        int tempValue = Integer.MAX_VALUE;
        if (terminalTest(b)){
            return utilityTest(Board.board);
        }
        else
            for (String action:actions(b, Board.white)) {
                tempValue = java.lang.Math.min(tempValue,maxValue(Board.result(b,action)));
            }
        return tempValue;
    }

    public static String minMax(Board b){
        String bestAction = "";
        b = Board.King(b);
        int maxUtility = - 1;
        for (String action:actions(b, Board.black)) {
            int temp = minValue(Board.result(b,action));
            if (minValue(Board.result(b,action)) > maxUtility){
                maxUtility = temp;
                bestAction = action;
            }
        }
        return bestAction;
    }
    
    
    public static int hMaxValue(Board b, int currentDepth, int maxDepth){
        currentDepth++;
        if (currentDepth >= maxDepth){
            return eval(b);
        }
        b = Board.King(b);
        int tempValue = Integer.MIN_VALUE;
        for (String action:actions(b, Board.black)) {
            tempValue = java.lang.Math.max(tempValue,hMinValue(Board.result(b,action),currentDepth,maxDepth));
        }
        return tempValue;
    }

    public static int hMinValue(Board b,int currentDepth, int maxDepth){
        currentDepth++;
        if (currentDepth >= maxDepth){
            return eval(b);
        }
        b = Board.King(b);
        int tempValue = Integer.MAX_VALUE;

        for (String action:actions(b, Board.white)) {
            tempValue = java.lang.Math.min(tempValue,hMaxValue(Board.result(b,action),currentDepth,maxDepth));
        }
        return tempValue;
    }

    

    public static String hMinMax(Board b,int depth){
        String bestAction = "";
        b = Board.King(b);
        int maxUtility = Integer.MIN_VALUE;
        for (String action:actions(b, Board.black)) {
            int temp = hMinValue(Board.result(b,action),0,depth);
            if ((temp) > maxUtility){
                maxUtility = temp;
                bestAction = action;
            }
        }
        return bestAction;
    }
    
    public static int eval(Board b){
        int result = 0;
        for (ArrayList<Pieces> row:Board.board) {
            for (Pieces piece:row) {
                if (piece == Board.white){
                    result-=1;
                }
                else if (piece == Board.whiteKing){
                    result-=2;
                }
                else if (piece == Board.black){
                    result+=1;
                }
                else if (piece == Board.blackKing){
                    result+=2;
                }
            }
        }
        return result;
    }

    

    public static int abmaxvalue(Board b, int alpha, int beta){
        b = Board.King(b);
        int v=Integer.MIN_VALUE;
        if(terminalTest(b)){
            return utilityTest(Board.board);
        }
        for(String action:actions(b,Board.black)){
            v=Math.max(v,abminvalue(Board.result(b,action),alpha,beta));
            if(v >= beta){return v;}
            alpha=Math.max(alpha,v);
        }
        return v;
    }

    public static int abminvalue(Board b, int alpha, int beta){
        b=Board.King(b);
        int v=Integer.MAX_VALUE;
        if(terminalTest(b)){
            return utilityTest(Board.board);
        }
        for(String action:actions(b,Board.white)){
            v=Math.min(v,abmaxvalue(Board.result(b,action),alpha,beta));
            if(v <= alpha){return v;}
            beta=Math.min(alpha,v);
        }
        return v;
    }
    public static String alphaBeta(Board b){
        String move=" ";
        b=Board.King(b);
        int max=Integer.MIN_VALUE;
        for (String action:actions(b,Board.black)) {
            int v = abminvalue(Board.result(b,action),Integer.MIN_VALUE,Integer.MAX_VALUE);
            if (v>max){
                max=v;
                move = action;
            }
        }
        return move;
    }

}


