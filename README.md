# Checkers-
Implementation of Minimax, minimax with Heuristics and alphabeta in the checkers game
1. All the requirements for the first question were met. We used an adversarial state-space search approach to solving the problem. The adversarial state space search methods are all in the class States.java and Engine.java. We designed the data-structures using the formal model of the game. We are able to search the entire tree for 4X4 checkers. 
2. We have also developed a program that plays 8X8 checkers and we use heuristic MINIMAX with alpha-beta pruning to choose the best move. It also does not take significant time to choose a move. 

Other information: 
Please be very careful in how you enter the input. Please use the instructions provided in the beginning of the game. Input your move in the form of a1-b2 and your captures in the form of a1xc3. The second state in the capture is the place your piece will end up on after the capture. It is not the place of the piece you have captured. If the input is not put in as instructed, the game will not function as intended. The black pieces are the computer and the white pieces are the player. 
The main method Is contained in the class main.java. 
