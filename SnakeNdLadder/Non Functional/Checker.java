import java.util.List;

public class Checker {


    public boolean checkforsnakes(Players currentPlayer, List<Snakes> snakeList) {

        for(Snakes S : snakeList){

            if(currentPlayer.playerpos == S.startingpoint){

                currentPlayer.playerpos = S.endingpoint;

                return true;
            }
        }
        return false;
    }

    public boolean checkforladders(Players currentPlayer, List<Ladders> laddersList) {

        for(Ladders L : laddersList){

            if(currentPlayer.playerpos == L.startingpoint){

                currentPlayer.playerpos = L.endingpoint;

                return true;
            }
        }

        return false;
    }
}
