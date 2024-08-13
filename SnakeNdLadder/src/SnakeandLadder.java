import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeandLadder {

    List<Players> playersList;
    List<Snakes> snakeList;
    List<Ladders> laddersList;
    Queue<Players> playersQueue;
    boolean gameover;

    final int BOARD =100;

    Queue<Players> playrerqueue;


    public SnakeandLadder(List<Players> playersList, List<Snakes> snakesList, List<Ladders> laddersList) {
        
        this.playersList= playersList;
        this.laddersList=laddersList;
        this.snakeList= snakesList;
        this.gameover=false;
        
    }


    public void Start() {

        playrerqueue = new LinkedList<>();

        for(Players P : playersList){

            playrerqueue.offer(P);
        }

        while(!gameover){


            Players currentPlayer = playrerqueue.poll();

            Dice dice = new Dice();

            int move = dice.generate();

            playermove(move, dice, currentPlayer);

            playrerqueue.offer(currentPlayer);
        }
    }

    private void playermove(int move, Dice dice, Players currentPlayer) {

        Checker checker = new Checker();

        if(!currentPlayer.breakmove && move==6){

            currentPlayer.breakmove=true;
            playermove(0,dice,currentPlayer);

        }else if(currentPlayer.breakmove){

            currentPlayer.playerpos+=move;

            if(currentPlayer.playerpos>100){

                currentPlayer.playerpos-=move;
                System.out.println("Too Much Moves!");
                return;
            }

            if(currentPlayer.playerpos==100){

                System.out.println("Player"+currentPlayer.playername+" Wins");
                gameover=true;
                return;
            }

            boolean snake =checker.checkforsnakes(currentPlayer,snakeList);
            boolean ladder =checker.checkforladders(currentPlayer,laddersList);

            System.out.println("Player Turn : "+currentPlayer.playername);


            System.out.println("Dice says:"+ move+ " your place will be"+ currentPlayer.playerpos);


            if(snake){

                System.out.println("Bit by snake! current location"+currentPlayer.playerpos);

            }

            if(ladder){

                System.out.println("Hit by ladder! current location"+currentPlayer.playerpos);

            }


        } else if (!currentPlayer.breakmove) {

            System.out.println("Awaiting move 6 to start! for player!"+currentPlayer.playername);
        }
    }


}
