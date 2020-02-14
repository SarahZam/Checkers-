import java.util.ArrayList;



public class States {

    enum Pieces  {empty, white, black, whiteKing, blackKing};
    ArrayList<ArrayList<Pieces>> board = new ArrayList<ArrayList<Pieces>>();



    public States (int size){
       
        for (int i = 0; i < size; i++){
            ArrayList<Pieces> temp = new ArrayList<>();
            for (int j = 0; j < size; j++){
                temp.add(Pieces.empty);
            }
            board.add(temp);
        }

        //initial board
        if (size==4) {
            for (int i = 1; i < size; i += 2) {
                board.get(0).set(i, Pieces.black);
                board.get(size - 1).set(i - 1, Pieces.white);
            }
        }else if(size==8){
            for (int i=1;i<size;i+=2){
                board.get(0).set(i,Pieces.black);
                board.get(1).set(i-1,Pieces.black);
                board.get(2).set(i,Pieces.black);
                board.get(5).set(i-1,Pieces.white);
                board.get(6).set(i,Pieces.white);
                board.get(7).set(i-1,Pieces.white);
            }
        }

    }
 

    //printing out the board

    public void displayBoard(){
    	
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
				switch (board.get(i).get(j)){
                case empty:
                    System.out.print("[ ]");
                    break;
                case black:
                    System.out.print("[b]");
                    break;
                case white:
                    System.out.print("[w]");
                    break;
                case blackKing:
                    System.out.print("[B]");
                    break;
                case whiteKing:
                    System.out.print("[W]");
                    break;
            }
			}
		}
		
    }


    //checks for kings
    public static States king(States chessboard) {
        for (int i = 1; i < chessboard.board.get(0).size(); i += 2) {
            if (chessboard.board.get(0).get(i) == Pieces.white) {
                chessboard.board.get(0).set(i, Pieces.whiteKing);
            }
            if (chessboard.board.get(chessboard.board.size() - 1).get(i - 1) == Pieces.black) {
                chessboard.board.get(chessboard.board.size() - 1).set(i - 1, Pieces.blackKing);
            }
        }
        return chessboard;
    }


    //checks if move is legit
    public static boolean LegalMove(String move,States b) {
        int[] moves =Engine.userInput(move);
        
        if (moves[3] > b.board.size() - 1 || moves[2] > b.board.size() - 1 || moves[3] < 0 || moves[2] < 0){
            return false;
        }
        Pieces type=b.board.get(moves[1]).get(moves[0]);
        
        
        if(type==Pieces.white) {
            if(moves[3]!=moves[1]-1 || (moves[2]!=moves[0]+1 && moves[2]!=moves[0]-1)) {
                return  false;
            }
        }
        
        
        //done
        if(type==Pieces.black) {
            if(moves[3]!=moves[1]+1 || (moves[2]!=moves[0]+1 && moves[2]!=moves[0]-1)) {
                return  false;
            }
        }
        
        //
        if(type==Pieces.whiteKing||type==Pieces.blackKing) {
            if((moves[3]!=moves[1]-1 && moves[3]!=moves[1]+1) || (moves[2]!=moves[0]+1 && moves[2]!=moves[0]-1)) {
                return false;
            }
        }
        
        //done
        if(b.board.get(moves[3]).get(moves[2])!=Pieces.empty) {
            return false;
        }
        
        return true;
    }
   

    //checks for captures
    public static boolean Legalcapture(String capture,States b){


        int cap[]=Engine.userInput(capture);
        
        //
        if (cap[3] > b.board.size() - 1 || cap[2] > b.board.size() - 1 || cap[3] < 0 || cap[2] < 0){
            return false;
        }
        
        
        Pieces type=b.board.get(cap[1]).get(cap[0]);
        if (type==Pieces.white){
            if(cap[3]!=cap[1]-2 || (cap[2]!=cap[0]-2 && cap[2]!=cap[0]+2)){
                return false;
            }else if(b.board.get((cap[1]+cap[3])/2).get((cap[0]+cap[2])/2) != Pieces.black && b.board.get((cap[1]+cap[3])/2).get((cap[0]+cap[2])/2) != Pieces.blackKing){
                return  false;
            }else if(b.board.get(cap[3]).get(cap[2])!=Pieces.empty){
                return false;
            }
        }
        
        
        if (type==Pieces.black){

            if(cap[3]!=cap[1]+2 || (cap[2]!=cap[0]-2 && cap[2]!=cap[0]+2)){
                return false;
                
            }else if(b.board.get((cap[1]+cap[3])/2).get((cap[0]+cap[2])/2) != Pieces.white && b.board.get((cap[1]+cap[3])/2).get((cap[0]+cap[2])/2) != Pieces.whiteKing){
                return false;
            }else if(b.board.get(cap[3]).get(cap[2])!=Pieces.empty){
                return false;
            }
        }
        if (type==Pieces.whiteKing) {
            if ((cap[3] != cap[1] - 2 && cap[3] != cap[1]+2 ) || (cap[2] != cap[0] - 2 && cap[2] != cap[0] + 2)) {
                return false;
            } else if (b.board.get((cap[1]+cap[3])/2).get((cap[0]+cap[2])/2) != Pieces.black && b.board.get((cap[1]+cap[3])/2).get((cap[0]+cap[2])/2) != Pieces.blackKing) {
                return false;
            } else if (b.board.get(cap[3]).get(cap[2]) != Pieces.empty) {
                return false;
            }
        }



        if (type == Pieces.blackKing) {
            if ((cap[3] != cap[1] - 2 && cap[3] != cap[1]+2 ) || (cap[2] != cap[0] - 2 && cap[2] != cap[0] + 2)){
                return false;
            } else if (b.board.get((cap[1]+cap[3])/2).get((cap[0]+cap[2])/2) != Pieces.white && b.board.get((cap[1]+cap[3])/2).get((cap[0]+cap[2])/2) != Pieces.whiteKing) {
                return false;
            } else if (b.board.get(cap[3]).get(cap[2]) != Pieces.empty) {
                return false;
            }
        }
        return true;
    }

    	//RESULT THE ACTIONS ON THE STATES
    public static States result(States board, String action){
        if (action.length()==0){
            return board;
        }
        int[] cor = Engine.userInput(action);
        States.Pieces currType = board.board.get(cor[1]).get(cor[0]);
        board.board.get(cor[1]).set(cor[0], States.Pieces.empty);
        board.board.get(cor[3]).set(cor[2],currType);
        if (cor[4] == 2) {
            board.board.get((cor[1] + cor[3])/2).set((cor[0] + cor[2])/2, States.Pieces.empty);
        }
        return board;
    }

}
