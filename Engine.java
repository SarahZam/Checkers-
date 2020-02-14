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
		
		int [] move = {c1,r1,c2,r2,m};

		return move;
		
	}


//PRINTS OUT AVAILABLE ACTIONS

public static ArrayList<String> actions(States board, States.Pieces turn){
    ArrayList<String> captures = new ArrayList<>();
    ArrayList<String> moves = new ArrayList<>();
    switch (turn){
        case black:
            for (int i = 0; i < board.board.size() ; i++) {
                for (int j = 0; j < board.board.size() ; j++) {
                    if (board.board.get(i).get(j) == States.Pieces.black){
                    	 String a1 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j+2);
    					 String a2 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j);
    					 String a3 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j+3);
    					 String a4 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j-1);
    					
                        if (States.LegalMove(a1,board)){
                            moves.add(a1);
                        }
                        if (States.LegalMove(a2,board)){
                            moves.add(a2);
                        }
                        if (States.Legalcapture(a3,board)){
                            captures.add(a3);
                        }
                        if (States.Legalcapture(a4,board)){
                            captures.add(a4);
                        }
                    }
                }
            }

            for (int i = 0; i < board.board.size() ; i++) {
                for (int j = 0; j < board.board.size() ; j++) {
                    if (board.board.get(i).get(j) == States.Pieces.blackKing){
                    	String a1 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j+2);
   					 String a2 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j);
   					 String a3 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j+3);
   					 String a4 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j-1);
   					 String a5 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j);
   					 String a6 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j+2);
   					 String a7 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j+3);
   					 String a8 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j-1);
   					
                        if (States.LegalMove(a1,board)){
                            moves.add(a1);
                        }
                        if (States.LegalMove(a2,board)){
                            moves.add(a2);
                        }
                        if (States.Legalcapture(a3,board)){
                            captures.add(a3);
                        }
                        if (States.Legalcapture(a4,board)){
                            captures.add(a4);
                        }
                        if (States.LegalMove(a5,board)){
                            moves.add(a5);
                        }
                        if (States.LegalMove(a6,board)){
                            moves.add(a6);
                        }
                        if (States.Legalcapture(a7,board)){
                            captures.add(a7);
                        }
                        if (States.Legalcapture(a8,board)){
                            captures.add(a8);
                        }
                    }
                }
            }
            if (captures.size() != 0){
                return captures;
            }else if (moves.size() != 0){
                return moves;
            }else return captures;
        case white:
            for (int i = 0; i < board.board.size() ; i++) {
                for (int j = 0; j < board.board.size() ; j++) {
                    if (board.board.get(i).get(j) == States.Pieces.white){
                    	 String a1 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j);
    					 String a2 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j+2);
    					 String a3 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j+3);
    					 String a4 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j-1);
    					if (States.LegalMove(a1,board)){
                            moves.add(a1);
                        }
                        if (States.LegalMove(a2,board)){
                            moves.add(a2);
                        }
                        if (States.Legalcapture(a3,board)){
                            captures.add(a3);
                        }
                        if (States.Legalcapture(a4,board)){
                            captures.add(a4);
                        }
                    }
                }
            }

            for (int i = 0; i < board.board.size() ; i++) {
                for (int j = 0; j < board.board.size() ; j++) {
                    if (board.board.get(i).get(j) == States.Pieces.whiteKing){
                    	 String a1 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j+2);
    					 String a2 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i+1)) + String.valueOf(j);
    					 String a3 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j+3);
    					 String a4 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i+2)) + String.valueOf(j-1);
    					 String a5 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j);
    					 String a6 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "-" + String.valueOf((char)('a'+i-1)) + String.valueOf(j+2);
    					 String a7 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j+3);
    					 String a8 = String.valueOf((char)('a'+i)) + String.valueOf(j+1) + "x" + String.valueOf((char)('a'+i-2)) + String.valueOf(j-1);
    					 if (States.LegalMove(a1,board)){
                            moves.add(a1);
                        }
                        if (States.LegalMove(a2,board)){
                            moves.add(a2);
                        }
                        if (States.Legalcapture(a3,board)){
                            captures.add(a3);
                        }
                        if (States.Legalcapture(a4,board)){
                            captures.add(a4);
                        }
                        if (States.LegalMove(a5,board)){
                            moves.add(a5);
                        }
                        if (States.LegalMove(a6,board)){
                            moves.add(a6);
                        }
                        if (States.Legalcapture(a7,board)){
                            captures.add(a7);
                        }
                        if (States.Legalcapture(a8,board)){
                            captures.add(a8);
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

//UTILITY
public static int utilityTest(ArrayList<ArrayList<States.Pieces>> board){
    int whiteNum = 0;
    int blackNum = 0;
    for (ArrayList<States.Pieces> row:board) {
        for (States.Pieces piece:row) {
            if (piece == States.Pieces.white || piece == States.Pieces.whiteKing){
                whiteNum++;
            }
            if (piece == States.Pieces.black || piece == States.Pieces.blackKing){
                blackNum++;
            }
        }
    }
    if (whiteNum > blackNum){
        return 0;
    }
    if (whiteNum == blackNum){
        return 1;
    }
    else {
        return 2;
    }
}


//CHECKS IF GAME IS OVER
public static boolean terminalTest(States board){
    int white = 0;
    int black = 0;
    for (ArrayList<States.Pieces> row:board.board) {
        for (States.Pieces piece:row) {
            if (piece == States.Pieces.white || piece == States.Pieces.whiteKing){
                white++;
            }
            if (piece == States.Pieces.black || piece == States.Pieces.blackKing){
                black++;
            }
        }
    }
    if (white == 0 || black == 0){
        return true;
    }
    else if (white == 1 && black == 1){
        return true;
    }
    else if (actions(board, States.Pieces.black).size() == 0 || actions(board, States.Pieces.white).size() == 0){
        return true;
    }
    return false;
}


//random

public static States random(States board){
    ArrayList<String> actions =  actions(board, States.Pieces.black);
    Random a=new Random();
    int rand = a.nextInt(actions.size());
    return States.king(States.result(board,actions.get(rand)));
}


public static int maxValue(States board){
    board = States.king(board);
    int tempValue = -1;
    if (terminalTest(board)){
        return utilityTest(board.board);
    }
    else for (String action:actions(board, States.Pieces.black)) {
        tempValue = java.lang.Math.max(tempValue,minValue(States.result(board,action)));
    }
    return tempValue;
}


public static int minValue(States board){
    board = States.king(board);
    int tempValue = Integer.MAX_VALUE;
    if (terminalTest(board)){
        return utilityTest(board.board);
    }
    else
        for (String action:actions(board, States.Pieces.white)) {
            tempValue = java.lang.Math.min(tempValue,maxValue(States.result(board,action)));
        }
    return tempValue;
}


//MINMAX 
public static String minMax(States board){
    String bestAction = "";
    board = States.king(board);
    int maxUtility = - 1;
    for (String action:actions(board, States.Pieces.black)) {
        int temp = minValue(States.result(board,action));
        if (minValue(States.result(board,action)) > maxUtility){
            maxUtility = temp;
            bestAction = action;
        }
    }
    return bestAction;
}


public static int hMaxValue(States board, int currentDepth, int maxDepth){
    currentDepth++;
    if (currentDepth >= maxDepth){
        return evalution(board);
    }
    board = States.king(board);
    int tempValue = Integer.MIN_VALUE;
    for (String action:actions(board, States.Pieces.black)) {
        tempValue = java.lang.Math.max(tempValue,hMinValue(States.result(board,action),currentDepth,maxDepth));
    }
    return tempValue;
}

public static int hMinValue(States board,int currentDepth, int maxDepth){
    currentDepth++;
    if (currentDepth >= maxDepth){
        return evalution(board);
    }
    board = States.king(board);
    int tempValue = Integer.MAX_VALUE;

    for (String action:actions(board, States.Pieces.white)) {
        tempValue = java.lang.Math.min(tempValue,hMaxValue(States.result(board,action),currentDepth,maxDepth));
    }
    return tempValue;
}


//HEURISTIC MIN MAX OH GOD
public static String hMinMax(States board,int depth){
    String bestAction = "";
    board = States.king(board);
    int maxUtility = Integer.MIN_VALUE;
    for (String action:actions(board, States.Pieces.black)) {
        int temp = hMinValue(States.result(board,action),0,depth);
        if ((temp) > maxUtility){
            maxUtility = temp;
            bestAction = action;
        }
    }
    return bestAction;
}

public static int evalution(States board){
    int result = 0;
    for (ArrayList<States.Pieces> row:board.board) {
        for (States.Pieces piece:row) {
            if (piece == States.Pieces.white){
                result-=1;
            }
            else if (piece == States.Pieces.whiteKing){
                result-=2;
            }
            else if (piece == States.Pieces.black){
                result+=1;
            }
            else if (piece == States.Pieces.blackKing){
                result+=2;
            }
        }
    }
    return result;
}

public static int abmaxvalue(States board, int alpha, int beta){
    board = States.king(board);
    int v=Integer.MIN_VALUE;
    if(terminalTest(board)){
        return utilityTest(board.board);
    }
    for(String action:actions(board,States.Pieces.black)){
        v=Math.max(v,abminvalue(States.result(board,action),alpha,beta));
        if(v >= beta){return v;}
        alpha=Math.max(alpha,v);
    }
    return v;
}

public static int abminvalue(States board, int alpha, int beta){
    board=States.king(board);
    int v=Integer.MAX_VALUE;
    if(terminalTest(board)){
        return utilityTest(board.board);
    }
    for(String action:actions(board,States.Pieces.white)){
        v=Math.min(v,abmaxvalue(States.result(board,action),alpha,beta));
        if(v <= alpha){return v;}
        beta=Math.min(alpha,v);
    }
    return v;
}

//ALPHA BETAAAAAAAAAAAAA
public static String alphabeta(States board){
    String move=" ";
    board=States.king(board);
    int max=Integer.MIN_VALUE;
    for (String action:actions(board,States.Pieces.black)) {
        int v = abminvalue(States.result(board,action),Integer.MIN_VALUE,Integer.MAX_VALUE);
        if (v>max){
            max=v;
            move = action;
        }
    }
    return move;
}
}
