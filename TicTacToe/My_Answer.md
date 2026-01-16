

Stage 1:

Inorder to develop the game , I'm going to create multiple classes of single responsibility.


Main.java -> executes the game.

Board.java -> handles board based logic like adding entries , validate entries 
Game.java -> uses the board to conduct the game. does things like declare winner. update status , check game status & turns.

GameStatus.java -> enum which holds all the statuses

