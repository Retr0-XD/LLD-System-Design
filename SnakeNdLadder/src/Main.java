import javax.xml.transform.Templates;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Snake and Ladder Game!");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of players!");

        int players = sc.nextInt();

        List<Players> playersList = new ArrayList<>();


        for(int i=0; i<players; i++){

            System.out.println("Enter player"+ i +" name");

            playersList.add(new Players(sc.next()));
        }

        System.out.println("Enter the number of Snakes");

        int snakes = sc.nextInt();

        List<Snakes> snakesList = new ArrayList<>();

        for(int i=0; i<snakes; i++){


            System.out.println("Enter Starting and Ending Point for Snake"+i);

            int startingpoint = sc.nextInt();
            int endingpoint = sc.nextInt();


            if(startingpoint>endingpoint) {

                if(checkforduplicatesSnakes(snakesList, startingpoint, endingpoint)) {

                    snakesList.add(new Snakes(startingpoint, endingpoint));

                }else{

                    System.out.println("Duplicates Found");
                }

            }else{

                System.out.println("ending point is bigger!");
            }
        }


        System.out.println("Enter the number of Ladders");

        int ladders = sc.nextInt();

        List<Ladders> laddersList = new ArrayList<>();

        for(int i=0; i<ladders; i++){


            System.out.println("Enter Starting and Ending Point for Ladder "+i);

            int startingpoint = sc.nextInt();
            int endingpoint = sc.nextInt();


            if(startingpoint<endingpoint) {

                if(checkforduplicatesLadders(laddersList, startingpoint, endingpoint)) {

                    laddersList.add(new Ladders(startingpoint, endingpoint));

                }else{

                    System.out.println("Duplicates Found");
                }

            }else{

                System.out.println("ending point is smaller!");
            }
        }

        SnakeandLadder Game = new SnakeandLadder(playersList, snakesList, laddersList);

        Game.Start();
    }

    private static boolean checkforduplicatesLadders(List<Ladders> laddersList, int startingpoint, int endingpoint) {

        if(!laddersList.isEmpty()){

            for(Ladders L : laddersList){

                if(L.startingpoint == startingpoint || L.endingpoint==endingpoint){

                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkforduplicatesSnakes(List<Snakes> snakesList, int startingpoint, int endingpoint) {

        if(!snakesList.isEmpty()){

            for(Snakes S : snakesList){

                if(S.startingpoint == startingpoint || S.endingpoint==endingpoint){

                    return false;
                }
            }
        }

        return true;
    }


}